package com.alwan.bajpsubmission2.ui.movie

import com.alwan.bajpsubmission2.R
import com.alwan.bajpsubmission2.data.model.Catalogue
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel
    private lateinit var movie: Catalogue

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
        movie = Catalogue(
            0,
            "Alita: Battle Angle",
            "When Alita awakens with no memory of who she is in a future world she does " +
                    "not recognize, she is taken in by Ido, a compassionate doctor who realizes " +
                    "that somewhere in this abandoned cyborg shell is the heart and soul of a " +
                    "young woman with an extraordinary past.",
            "Action, Science Fiction, Adventure",
            "71%",
            R.drawable.poster_alita
        )
    }

    @Test
    fun getMovies() {
        val movieEntities = viewModel.getMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }

    @Test
    fun getDetailMovie() {
        val detailMovie = viewModel.getDetailMovie(0)
        assertEquals(movie.id, detailMovie.id)
        assertEquals(movie.title, detailMovie.title)
        assertEquals(movie.overview, detailMovie.overview)
        assertEquals(movie.genre, detailMovie.genre)
        assertEquals(movie.score, detailMovie.score)
        assertEquals(movie.poster, detailMovie.poster)
    }
}