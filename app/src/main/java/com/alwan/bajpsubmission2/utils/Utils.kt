package com.alwan.bajpsubmission2.utils

import android.widget.ImageView
import com.alwan.bajpsubmission2.data.source.remote.response.Genres
import com.alwan.bajpsubmission2.utils.NetworkInfo.IMG_URL
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String?) {
    Glide.with(this.context)
        .load(IMG_URL + url)
        .centerCrop()
        .into(this)
}

fun ArrayList<Genres>?.toGenreString(): String {
    var stringGenre = ""

    this?.forEachIndexed { index, genre ->
        stringGenre += if (index != this.size - 1) {
            genre.name + ", "
        } else {
            genre.name
        }
    }

    return stringGenre
}