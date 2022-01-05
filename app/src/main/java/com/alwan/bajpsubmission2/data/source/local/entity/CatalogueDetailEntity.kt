package com.alwan.bajpsubmission2.data.source.local.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatalogueDetailEntity(
    val id: Int?,
    val name: String?,
    val overview: String?,
    val genres: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
) : Parcelable
