package com.dedi.myapplication.repository

import androidx.lifecycle.LiveData
import com.dedi.myapplication.data.MovieRespone
import com.dedi.myapplication.data.TvShowRespone

interface ApiCallback {
    fun getMovies(uid: String): LiveData<MovieRespone>
    fun getTvShows(uid: String): LiveData<TvShowRespone>
}