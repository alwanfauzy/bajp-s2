package com.alwan.bajpsubmission2.ui.movie

import androidx.lifecycle.ViewModel
import com.alwan.bajpsubmission2.data.CatalogueRepository

class MovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getMovies() = catalogueRepository.getMovies()
}