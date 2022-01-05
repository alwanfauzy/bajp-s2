package com.alwan.bajpsubmission2.data.source.remote.response.movie

import android.os.Parcelable
import com.alwan.bajpsubmission2.data.source.remote.response.Genres
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetailResponse(
    val id: Int?,
    val title: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
    val overview: String? = null,
    val genres: ArrayList<Genres>? = null,
) : Parcelable
