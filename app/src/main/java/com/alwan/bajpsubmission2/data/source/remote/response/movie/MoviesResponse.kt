package com.alwan.bajpsubmission2.data.source.remote.response.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoviesResponse(
    val results: ArrayList<MovieDetailResponse>
) : Parcelable
