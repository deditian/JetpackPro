package com.dedi.movies.repository

import androidx.lifecycle.LiveData
import com.dedi.movies.data.MovieRespone
import com.dedi.movies.data.TvShowRespone

interface ApiCallback {
    fun getMovies(uid: String): LiveData<MovieRespone>
    fun getTvShows(uid: String): LiveData<TvShowRespone>
}