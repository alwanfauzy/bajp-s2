package com.alwan.bajpsubmission2.data.source.remote.response.tvshow

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowsResponse(
    val results: ArrayList<TvShowDetailResponse>
) : Parcelable
