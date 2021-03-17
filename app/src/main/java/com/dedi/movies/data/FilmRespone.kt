package com.dedi.movies.data

import android.os.Parcelable
import com.dedi.movies.data.entity.Movie
import com.dedi.movies.data.entity.TvShow
import kotlinx.android.parcel.Parcelize


data class MovieRespone( val results: List<Movie>)


data class TvShowRespone( val results: List<TvShow>)

@Parcelize
data class DetailModel(
    val id : Int,
    val title : String,
    val Image: String,
    val overview : String,
    val status : String
):Parcelable