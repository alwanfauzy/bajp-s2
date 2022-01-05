package com.alwan.bajpsubmission2.data.source.remote.response.tvshow

import android.os.Parcelable
import com.alwan.bajpsubmission2.data.source.remote.response.Genres
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowDetailResponse(
    val id: Int?,
    val name: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
    val overview: String? = null,
    val genres: ArrayList<Genres>? = null,
) : Parcelable
