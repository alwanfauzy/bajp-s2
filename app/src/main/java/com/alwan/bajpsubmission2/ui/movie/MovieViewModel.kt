package com.alwan.bajpsubmission2.ui.movie

import androidx.lifecycle.ViewModel
import com.alwan.bajpsubmission2.data.DummyCatalogue
import com.alwan.bajpsubmission2.data.model.Catalogue

class MovieViewModel : ViewModel() {
    fun getMovies(): ArrayList<Catalogue> = DummyCatalogue.getMovie()

    fun getDetailMovie(id : Int): Catalogue = DummyCatalogue.getDetailMovie(id)
}