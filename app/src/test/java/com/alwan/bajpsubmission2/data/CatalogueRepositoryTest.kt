package com.alwan.bajpsubmission2.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alwan.bajpsubmission2.data.source.remote.RemoteDataSource
import com.alwan.bajpsubmission2.utils.DummyCatalogue
import com.alwan.bajpsubmission2.utils.LiveDataTestUtil
import com.alwan.bajpsubmission2.utils.toGenreString
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class CatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote)
    private val moviesResponse = DummyCatalogue.getRemoteMovies()
    private val movieId = moviesResponse[0].id.toString()
    private val movieDetail = DummyCatalogue.getRemoteMovieDetails()[0]
    private val tvShowsResponse = DummyCatalogue.getRemoteTvShows()
    private val tvShowId = tvShowsResponse[0].id.toString()
    private val tvShowDetail = DummyCatalogue.getRemoteTvShowDetails()[0]

    @Test
    fun getMovies() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadMoviesCallback).onMoviesLoaded(moviesResponse)
            null
        }.`when`(remote).getMovies(any())

        val movieEntities = LiveDataTestUtil.getValue(catalogueRepository.getMovies())
        verify(remote).getMovies(any())
        assertNotNull(movieEntities)
        assertEquals(moviesResponse.size, movieEntities.size)
    }

    @Test
    fun getDetailMovie() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadDetailMovieCallback).onDetailMovieLoaded(
                movieDetail
            )
            null
        }.`when`(remote).getDetailMovie(any(), eq(movieId))

        val movieDetailEntity =
            LiveDataTestUtil.getValue(catalogueRepository.getDetailMovie(movieId))
        verify(remote).getDetailMovie(any(), eq(movieId))
        assertNotNull(movieDetailEntity)
        assertEquals(movieDetail.id, movieDetailEntity.id)
        assertEquals(movieDetail.title, movieDetailEntity.name)
        assertEquals(movieDetail.overview, movieDetailEntity.overview)
        assertEquals(movieDetail.genres.toGenreString(), movieDetailEntity.genres)
        assertEquals(movieDetail.posterPath, movieDetailEntity.posterPath)
        assertEquals(movieDetail.voteAverage, movieDetailEntity.voteAverage)
    }

    @Test
    fun getTvShows() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadTvShowsCallback).onTvShowsLoaded(
                tvShowsResponse
            )
            null
        }.`when`(remote).getTvShows(any())

        val tvShowEntities = LiveDataTestUtil.getValue(catalogueRepository.getTvShows())
        verify(remote).getTvShows(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowsResponse.size, tvShowEntities.size)
    }

    @Test
    fun getDetailTvShow() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadDetailTvShowCallback).onDetailTvShowLoaded(
                tvShowDetail
            )
            null
        }.`when`(remote).getDetailTvShow(any(), eq(tvShowId))

        val tvShowDetailEntity =
            LiveDataTestUtil.getValue(catalogueRepository.getDetailTvShow(tvShowId))
        verify(remote).getDetailTvShow(any(), eq(tvShowId))
        assertNotNull(tvShowDetailEntity)
        assertEquals(tvShowDetail.id, tvShowDetailEntity.id)
        assertEquals(tvShowDetail.name, tvShowDetailEntity.name)
        assertEquals(tvShowDetail.overview, tvShowDetailEntity.overview)
        assertEquals(tvShowDetail.genres.toGenreString(), tvShowDetailEntity.genres)
        assertEquals(tvShowDetail.posterPath, tvShowDetailEntity.posterPath)
        assertEquals(tvShowDetail.voteAverage, tvShowDetailEntity.voteAverage)
    }
}