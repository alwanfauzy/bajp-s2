package com.alwan.bajpsubmission2.utils

import com.alwan.bajpsubmission2.data.source.local.entity.CatalogueDetailEntity
import com.alwan.bajpsubmission2.data.source.local.entity.CatalogueEntity
import com.alwan.bajpsubmission2.data.source.remote.response.Genres
import com.alwan.bajpsubmission2.data.source.remote.response.movie.MovieDetailResponse
import com.alwan.bajpsubmission2.data.source.remote.response.tvshow.TvShowDetailResponse

object DummyCatalogue {

    fun getMovies(): ArrayList<CatalogueEntity> {
        val listMovies = ArrayList<CatalogueEntity>()

        listMovies.add(
            CatalogueEntity(
                634649,
                "Spider-Man: No Way Home",
                8.4,
                "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            )
        )

        listMovies.add(
            CatalogueEntity(
                460458,
                "Resident Evil: Welcome to Raccoon City",
                6.1,
                "/6WR7wLCX0PGLhj51qyvK8MIxtT5.jpg",
            )
        )

        listMovies.add(
            CatalogueEntity(
                624860,
                "The Matrix Resurrections",
                7.1,
                "/8c4a8kE7PizaGQQnditMmI1xbRp.jpg",
            )
        )

        return listMovies
    }

    fun getMovieDetails(): ArrayList<CatalogueDetailEntity> {
        val listMovieDetails = ArrayList<CatalogueDetailEntity>()

        listMovieDetails.add(
            CatalogueDetailEntity(
                634649,
                "Spider-Man: No Way Home",
                "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                arrayListOf(
                    Genres(28, "Action"),
                    Genres(12, "Adventure"),
                    Genres(878, "Science Fiction")
                ).toGenreString(),
                8.4,
                "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            )
        )

        listMovieDetails.add(
            CatalogueDetailEntity(
                460458,
                "Resident Evil: Welcome to Raccoon City",
                "Once the booming home of pharmaceutical giant Umbrella Corporation, Raccoon City is now a dying Midwestern town. The company’s exodus left the city a wasteland…with great evil brewing below the surface. When that evil is unleashed, the townspeople are forever…changed…and a small group of survivors must work together to uncover the truth behind Umbrella and make it through the night.",
                arrayListOf(
                    Genres(27, "Horror"),
                    Genres(28, "Action"),
                    Genres(878, "Science Fiction")
                ).toGenreString(),
                6.1,
                "/6WR7wLCX0PGLhj51qyvK8MIxtT5.jpg",
            )
        )

        listMovieDetails.add(
            CatalogueDetailEntity(
                624860,
                "The Matrix Resurrections",
                "Plagued by strange memories, Neo's life takes an unexpected turn when he finds himself back inside the Matrix.",
                arrayListOf(
                    Genres(28, "Action"),
                    Genres(878, "Science Fiction")
                ).toGenreString(),
                7.1,
                "/8c4a8kE7PizaGQQnditMmI1xbRp.jpg",
            )
        )

        return listMovieDetails
    }

    fun getTvShows(): ArrayList<CatalogueEntity> {
        val listTvShows = ArrayList<CatalogueEntity>()

        listTvShows.add(
            CatalogueEntity(
                77169,
                "Cobra Kai",
                8.1,
                "/6POBWybSBDBKjSs1VAQcnQC1qyt.jpg",
            )
        )

        listTvShows.add(
            CatalogueEntity(
                88329,
                "Hawkeye",
                8.4,
                "/pqzjCxPVc9TkVgGRWeAoMmyqkZV.jpg",
            )
        )

        listTvShows.add(
            CatalogueEntity(
                73586,
                "Yellowstone",
                8.0,
                "/iqWCUwLcjkVgtpsDLs8xx8kscg6.jpg",
            )
        )

        return listTvShows
    }

    fun getTvShowDetails(): ArrayList<CatalogueDetailEntity> {
        val listTvShowDetails = ArrayList<CatalogueDetailEntity>()

        listTvShowDetails.add(
            CatalogueDetailEntity(
                77169,
                "Cobra Kai",
                "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                arrayListOf(
                    Genres(10759, "Action & Adventure"),
                    Genres(18, "Drama")
                ).toGenreString(),
                8.1,
                "/6POBWybSBDBKjSs1VAQcnQC1qyt.jpg",
            )
        )

        listTvShowDetails.add(
            CatalogueDetailEntity(
                88329,
                "Hawkeye",
                "Former Avenger Clint Barton has a seemingly simple mission: get back to his family for Christmas. Possible? Maybe with the help of Kate Bishop, a 22-year-old archer with dreams of becoming a superhero. The two are forced to work together when a presence from Barton’s past threatens to derail far more than the festive spirit.",
                arrayListOf(
                    Genres(10759, "Action & Adventure"),
                    Genres(18, "Drama")
                ).toGenreString(),
                8.4,
                "/pqzjCxPVc9TkVgGRWeAoMmyqkZV.jpg",
            )
        )

        listTvShowDetails.add(
            CatalogueDetailEntity(
                73586,
                "Yellowstone",
                "Follow the violent world of the Dutton family, who controls the largest contiguous ranch in the United States. Led by their patriarch John Dutton, the family defends their property against constant attack by land developers, an Indian reservation, and America’s first National Park.",
                arrayListOf(Genres(37, "Western"), Genres(18, "Drama")).toGenreString(),
                8.0,
                "/iqWCUwLcjkVgtpsDLs8xx8kscg6.jpg",
            )
        )

        return listTvShowDetails
    }

    fun getRemoteMovies(): ArrayList<MovieDetailResponse> {
        val listMovies = ArrayList<MovieDetailResponse>()

        listMovies.add(
            MovieDetailResponse(
                634649,
                "Spider-Man: No Way Home",
                8.4,
                "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            )
        )

        listMovies.add(
            MovieDetailResponse(
                460458,
                "Resident Evil: Welcome to Raccoon City",
                6.1,
                "/6WR7wLCX0PGLhj51qyvK8MIxtT5.jpg",
            )
        )

        listMovies.add(
            MovieDetailResponse(
                624860,
                "The Matrix Resurrections",
                7.1,
                "/8c4a8kE7PizaGQQnditMmI1xbRp.jpg",
            )
        )

        return listMovies
    }

    fun getRemoteMovieDetails(): ArrayList<MovieDetailResponse> {
        val listMovieDetails = ArrayList<MovieDetailResponse>()

        listMovieDetails.add(
            MovieDetailResponse(
                634649,
                "Spider-Man: No Way Home",
                8.4,
                "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                arrayListOf(
                    Genres(28, "Action"),
                    Genres(12, "Adventure"),
                    Genres(878, "Science Fiction")
                ),
            )
        )

        listMovieDetails.add(
            MovieDetailResponse(
                460458,
                "Resident Evil: Welcome to Raccoon City",
                6.1,
                "/6WR7wLCX0PGLhj51qyvK8MIxtT5.jpg",
                "Once the booming home of pharmaceutical giant Umbrella Corporation, Raccoon City is now a dying Midwestern town. The company’s exodus left the city a wasteland…with great evil brewing below the surface. When that evil is unleashed, the townspeople are forever…changed…and a small group of survivors must work together to uncover the truth behind Umbrella and make it through the night.",
                arrayListOf(
                    Genres(27, "Horror"),
                    Genres(28, "Action"),
                    Genres(878, "Science Fiction")
                ),
            )
        )

        listMovieDetails.add(
            MovieDetailResponse(
                624860,
                "The Matrix Resurrections",
                7.1,
                "/8c4a8kE7PizaGQQnditMmI1xbRp.jpg",
                "Plagued by strange memories, Neo's life takes an unexpected turn when he finds himself back inside the Matrix.",
                arrayListOf(
                    Genres(28, "Action"),
                    Genres(878, "Science Fiction")
                ),
            )
        )

        return listMovieDetails
    }

    fun getRemoteTvShows(): ArrayList<TvShowDetailResponse> {
        val listTvShows = ArrayList<TvShowDetailResponse>()

        listTvShows.add(
            TvShowDetailResponse(
                77169,
                "Cobra Kai",
                8.1,
                "/6POBWybSBDBKjSs1VAQcnQC1qyt.jpg",
            )
        )

        listTvShows.add(
            TvShowDetailResponse(
                88329,
                "Hawkeye",
                8.4,
                "/pqzjCxPVc9TkVgGRWeAoMmyqkZV.jpg",
            )
        )

        listTvShows.add(
            TvShowDetailResponse(
                73586,
                "Yellowstone",
                8.0,
                "/iqWCUwLcjkVgtpsDLs8xx8kscg6.jpg",
            )
        )

        return listTvShows
    }

    fun getRemoteTvShowDetails(): ArrayList<TvShowDetailResponse> {
        val listTvShowDetails = ArrayList<TvShowDetailResponse>()

        listTvShowDetails.add(
            TvShowDetailResponse(
                77169,
                "Cobra Kai",
                8.1,
                "/6POBWybSBDBKjSs1VAQcnQC1qyt.jpg",
                "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                arrayListOf(Genres(10759, "Action & Adventure"), Genres(18, "Drama")),
            )
        )

        listTvShowDetails.add(
            TvShowDetailResponse(
                88329,
                "Hawkeye",
                8.4,
                "/pqzjCxPVc9TkVgGRWeAoMmyqkZV.jpg",
                "Former Avenger Clint Barton has a seemingly simple mission: get back to his family for Christmas. Possible? Maybe with the help of Kate Bishop, a 22-year-old archer with dreams of becoming a superhero. The two are forced to work together when a presence from Barton’s past threatens to derail far more than the festive spirit.",
                arrayListOf(Genres(10759, "Action & Adventure"), Genres(18, "Drama")),
            )
        )

        listTvShowDetails.add(
            TvShowDetailResponse(
                73586,
                "Yellowstone",
                8.0,
                "/iqWCUwLcjkVgtpsDLs8xx8kscg6.jpg",
                "Follow the violent world of the Dutton family, who controls the largest contiguous ranch in the United States. Led by their patriarch John Dutton, the family defends their property against constant attack by land developers, an Indian reservation, and America’s first National Park.",
                arrayListOf(Genres(37, "Western"), Genres(18, "Drama")),
            )
        )

        return listTvShowDetails
    }
}