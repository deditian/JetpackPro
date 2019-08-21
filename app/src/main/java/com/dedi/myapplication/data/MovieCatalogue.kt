package com.dedi.myapplication.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MovieCatalogue(
    val courseId: String?,
    val title: String?,
    val overview: String?,
    val imagePath: String?
) : Parcelable