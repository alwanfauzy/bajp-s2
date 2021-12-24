package com.alwan.bajpsubmission1.ui.movie

import androidx.lifecycle.ViewModel
import com.alwan.bajpsubmission1.data.DummyCatalogue
import com.alwan.bajpsubmission1.data.model.Catalogue

class MovieViewModel : ViewModel() {
    fun getMovies(): ArrayList<Catalogue> = DummyCatalogue.getMovie()

    fun getDetailMovie(id : Int): Catalogue = DummyCatalogue.getDetailMovie(id)
}