package com.alwan.bajpsubmission2.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Catalogue(
    val id: Int?,
    val title: String?,
    val overview: String?,
    val genre: String?,
    val score: String?,
    val poster: Int?,
) : Parcelable
