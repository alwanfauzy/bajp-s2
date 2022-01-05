package com.alwan.bajpsubmission2.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.alwan.bajpsubmission2.data.CatalogueRepository
import com.alwan.bajpsubmission2.data.source.local.entity.CatalogueDetailEntity
import com.alwan.bajpsubmission2.utils.DummyCatalogue
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<CatalogueDetailEntity>

    @Mock
    private lateinit var tvShowObserver: Observer<CatalogueDetailEntity>

    private lateinit var detailViewModel: DetailViewModel

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel(catalogueRepository)
    }

    @Test
    fun getDetailMovie() {
        val dummyMovieDetail = DummyCatalogue.getMovieDetails()[0]
        val dummyMovieDetailId = dummyMovieDetail.id.toString()
        val movieDetail = MutableLiveData<CatalogueDetailEntity>()
        movieDetail.value = dummyMovieDetail

        `when`(catalogueRepository.getDetailMovie(dummyMovieDetailId))
            .thenReturn(movieDetail)
        val movieDetailEntity =
            detailViewModel.getDetailMovie(dummyMovieDetailId.toInt()).value as CatalogueDetailEntity
        verify(catalogueRepository).getDetailMovie(dummyMovieDetailId)

        assertNotNull(movieDetailEntity)
        assertEquals(dummyMovieDetail.id, movieDetailEntity.id)
        assertEquals(dummyMovieDetail.name, movieDetailEntity.name)
        assertEquals(dummyMovieDetail.posterPath, movieDetailEntity.posterPath)
        assertEquals(dummyMovieDetail.overview, movieDetailEntity.overview)
        assertEquals(dummyMovieDetail.genres, movieDetailEntity.genres)
        assertEquals(dummyMovieDetail.voteAverage, movieDetailEntity.voteAverage)

        detailViewModel.getDetailMovie(dummyMovieDetailId.toInt()).observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovieDetail)
    }

    @Test
    fun getDetailTvShow() {
        val dummyTvShowDetail = DummyCatalogue.getTvShowDetails()[0]
        val dummyTvShowDetailId = dummyTvShowDetail.id.toString()
        val tvShowDetail = MutableLiveData<CatalogueDetailEntity>()
        tvShowDetail.value = dummyTvShowDetail

        `when`(catalogueRepository.getDetailTvShow(dummyTvShowDetailId))
            .thenReturn(tvShowDetail)
        val tvShowDetailEntity =
            detailViewModel.getDetailTvShow(dummyTvShowDetailId.toInt()).value as CatalogueDetailEntity
        verify(catalogueRepository).getDetailTvShow(dummyTvShowDetailId)

        assertNotNull(tvShowDetailEntity)
        assertEquals(dummyTvShowDetail.id, tvShowDetailEntity.id)
        assertEquals(dummyTvShowDetail.name, tvShowDetailEntity.name)
        assertEquals(dummyTvShowDetail.posterPath, tvShowDetailEntity.posterPath)
        assertEquals(dummyTvShowDetail.overview, tvShowDetailEntity.overview)
        assertEquals(dummyTvShowDetail.genres, tvShowDetailEntity.genres)
        assertEquals(dummyTvShowDetail.voteAverage, tvShowDetailEntity.voteAverage)

        detailViewModel.getDetailTvShow(dummyTvShowDetailId.toInt()).observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShowDetail)
    }
}