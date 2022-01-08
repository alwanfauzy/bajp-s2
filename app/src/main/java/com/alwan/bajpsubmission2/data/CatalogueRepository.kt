package com.alwan.bajpsubmission2.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alwan.bajpsubmission2.data.source.local.entity.*
import com.alwan.bajpsubmission2.data.source.remote.RemoteDataSource
import com.alwan.bajpsubmission2.data.source.remote.response.movie.MovieDetailResponse
import com.alwan.bajpsubmission2.data.source.remote.response.tvshow.TvShowDetailResponse
import com.alwan.bajpsubmission2.utils.toGenreString

class CatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    CatalogueDataSource {

    override fun getMovies(): LiveData<ArrayList<CatalogueEntity>> {
        val movieResult = MutableLiveData<ArrayList<CatalogueEntity>>()

        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onMoviesLoaded(movies: ArrayList<MovieDetailResponse>?) {
                val movieList = ArrayList<CatalogueEntity>()

                if (movies != null) {
                    for (response in movies) {
                        with(response) {
                            val movie = CatalogueEntity(
                                id, title, voteAverage, posterPath
                            )
                            movieList.add(movie)
                        }
                    }
                    movieResult.postValue(movieList)
                }
            }
        })
        return movieResult
    }

    override fun getDetailMovie(movieId: String): LiveData<CatalogueDetailEntity> {
        val movieDetailResult = MutableLiveData<CatalogueDetailEntity>()

        remoteDataSource.getDetailMovie(object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onDetailMovieLoaded(movieDetail: MovieDetailResponse?) {
                if (movieDetail != null) {
                    with(movieDetail) {
                        val listGenres = ArrayList<String>()

                        genres?.forEach { genre ->
                            genre.name?.let { listGenres.add(it) }
                        }

                        val detailMovie = CatalogueDetailEntity(
                            id,
                            title,
                            overview,
                            genres.toGenreString(),
                            voteAverage,
                            posterPath
                        )
                        movieDetailResult.postValue(detailMovie)
                    }
                }
            }
        }, movieId)
        return movieDetailResult
    }

    override fun getTvShows(): LiveData<ArrayList<CatalogueEntity>> {
        val tvResult = MutableLiveData<ArrayList<CatalogueEntity>>()

        remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onTvShowsLoaded(tvShows: ArrayList<TvShowDetailResponse>?) {
                val tvList = ArrayList<CatalogueEntity>()
                if (tvShows != null) {
                    for (response in tvShows) {
                        with(response) {
                            val tvShow = CatalogueEntity(
                                id,
                                name,
                                voteAverage,
                                posterPath
                            )
                            tvList.add(tvShow)
                        }
                    }
                    tvResult.postValue(tvList)
                }
            }
        })
        return tvResult
    }

    override fun getDetailTvShow(tvShowId: String): LiveData<CatalogueDetailEntity> {
        val movieDetailResult = MutableLiveData<CatalogueDetailEntity>()

        remoteDataSource.getDetailTvShow(object : RemoteDataSource.LoadDetailTvShowCallback {
            override fun onDetailTvShowLoaded(tvShowDetail: TvShowDetailResponse?) {
                if (tvShowDetail != null) {
                    with(tvShowDetail) {
                        val listGenres = ArrayList<String>()

                        genres?.forEach { genre ->
                            genre.name?.let { listGenres.add(it) }
                        }

                        val detailMovie = CatalogueDetailEntity(
                            id,
                            name,
                            overview,
                            genres.toGenreString(),
                            voteAverage,
                            posterPath
                        )
                        movieDetailResult.postValue(detailMovie)
                    }
                }
            }
        }, tvShowId)
        return movieDetailResult
    }

    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null
        fun getInstance(remoteData: RemoteDataSource): CatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: CatalogueRepository(remoteData)
            }
    }
}