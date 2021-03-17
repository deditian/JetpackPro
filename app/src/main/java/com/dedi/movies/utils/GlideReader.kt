package com.dedi.movies.utils


import android.widget.ImageView
import com.bumptech.glide.Glide

internal fun ImageView.imageLoad(url: String) {
    Glide.with(this.context).load("http://image.tmdb.org/t/p/w500$url").centerCrop().into(this)
}