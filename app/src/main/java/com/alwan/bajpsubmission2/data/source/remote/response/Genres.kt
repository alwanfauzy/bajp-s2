package com.alwan.bajpsubmission2.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genres(
    val id: Int?,
    val name: String?,
): Parcelable
