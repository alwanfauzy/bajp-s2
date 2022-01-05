package com.alwan.bajpsubmission2.ui.movie

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
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var moviesObserver: Observer<ArrayList<CatalogueEntity>>

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel(catalogueRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DummyCatalogue.getMovies()
        val movies = MutableLiveData<ArrayList<CatalogueEntity>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getMovies()).thenReturn(movies)
        val movie = viewModel.getMovies().value
        verify(catalogueRepository).getMovies()
        assertNotNull(movie)
        assertEquals(3, movie?.size)

        viewModel.getMovies().observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyMovies)
    }
}