package com.alwan.bajpsubmission1.ui.tvshow

import com.alwan.bajpsubmission1.R
import com.alwan.bajpsubmission1.data.model.Catalogue
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel
    private lateinit var tvShow: Catalogue

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
        tvShow = Catalogue(
            0,
            "Dragon Ball",
            "Long ago in the mountains, a fighting master known as Gohan discovered a " +
                    "strange boy whom he named Goku. Gohan raised him and trained Goku in martial " +
                    "arts until he died. The young and very strong boy was on his own, but easily" +
                    " managed. Then one day, Goku met a teenage girl named Bulma, whose search for" +
                    " the mystical Dragon Balls brought her to Gokus home. Together, they set off" +
                    " to find all seven and to grant her wish.",
            "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
            "80%",
            R.drawable.poster_dragon_ball
        )
    }

    @Test
    fun getTvShows() {
        val tvShowEntities = viewModel.getTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities.size)
    }

    @Test
    fun getDetailTvShow() {
        val detailTvShow = viewModel.getDetailTvShow(0)
        assertEquals(tvShow.id, detailTvShow.id)
        assertEquals(tvShow.title, detailTvShow.title)
        assertEquals(tvShow.overview, detailTvShow.overview)
        assertEquals(tvShow.genre, detailTvShow.genre)
        assertEquals(tvShow.score, detailTvShow.score)
        assertEquals(tvShow.poster, detailTvShow.poster)
    }
}