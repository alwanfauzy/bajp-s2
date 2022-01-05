package com.alwan.bajpsubmission2.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.alwan.bajpsubmission2.data.CatalogueRepository
import com.alwan.bajpsubmission2.data.source.local.entity.CatalogueEntity
import com.alwan.bajpsubmission2.utils.DummyCatalogue
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var tvShowObserver: Observer<ArrayList<CatalogueEntity>>

    private lateinit var tvShowViewModel: TvShowViewModel

    @Before
    fun setUp() {
        tvShowViewModel = TvShowViewModel(catalogueRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShow = DummyCatalogue.getTvShows()
        val tvShows = MutableLiveData<ArrayList<CatalogueEntity>>()
        tvShows.value = dummyTvShow

        Mockito.`when`(catalogueRepository.getTvShows()).thenReturn(tvShows)
        val tvShow = tvShowViewModel.getTvShows().value
        verify(catalogueRepository).getTvShows()
        assertNotNull(tvShow)
        assertEquals(3, tvShow?.size)

        tvShowViewModel.getTvShows().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }
}