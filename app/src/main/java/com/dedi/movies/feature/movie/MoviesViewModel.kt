package com.dedi.movies.feature.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dedi.movies.BuildConfig
import com.dedi.movies.data.MovieRespone
import com.dedi.movies.repository.ApiCallback


class MoviesViewModel(val moviesCallback: ApiCallback) : ViewModel() {
    fun getMovies(): LiveData<MovieRespone> {
        return moviesCallback.getMovies(BuildConfig.API_KEY)
    }

}