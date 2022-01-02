package com.alwan.bajpsubmission2.ui.tvshow

import androidx.lifecycle.ViewModel
import com.alwan.bajpsubmission2.data.DummyCatalogue
import com.alwan.bajpsubmission2.data.model.Catalogue

class TvShowViewModel : ViewModel() {
    fun getTvShows() : ArrayList<Catalogue> = DummyCatalogue.getTvShow()

    fun getDetailTvShow(id: Int) : Catalogue = DummyCatalogue.getDetailTvShow(id)
}