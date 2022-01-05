package com.alwan.bajpsubmission2.data

import androidx.lifecycle.LiveData
import com.alwan.bajpsubmission2.data.source.local.entity.*

interface CatalogueDataSource {
    fun getMovies(): LiveData<ArrayList<CatalogueEntity>>
    fun getDetailMovie(movieId: String): LiveData<CatalogueDetailEntity>
    fun getTvShows(): LiveData<ArrayList<CatalogueEntity>>
    fun getDetailTvShow(tvShowId: String): LiveData<CatalogueDetailEntity>
}