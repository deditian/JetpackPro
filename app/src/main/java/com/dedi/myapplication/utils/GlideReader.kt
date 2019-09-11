package com.dedi.myapplication.utils


import android.widget.ImageView
import com.bumptech.glide.Glide

internal fun ImageView.imageLoad(url: String) {
    Glide.with(this.context).load("file:///android_asset/$url").centerCrop().into(this)
}