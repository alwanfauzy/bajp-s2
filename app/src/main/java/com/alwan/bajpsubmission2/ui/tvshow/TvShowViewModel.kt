package com.alwan.bajpsubmission2.ui.tvshow

import androidx.lifecycle.ViewModel
import com.alwan.bajpsubmission2.data.CatalogueRepository

class TvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getTvShows() = catalogueRepository.getTvShows()
}