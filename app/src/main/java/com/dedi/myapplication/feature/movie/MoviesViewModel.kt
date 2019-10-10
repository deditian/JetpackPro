package com.dedi.myapplication.feature.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dedi.myapplication.BuildConfig
import com.dedi.myapplication.data.MovieRespone
import com.dedi.myapplication.repository.ApiCallback
import com.dedi.myapplication.repository.ApiRepository
import com.dedi.myapplication.utils.EspressoIdlingResource.increment


class MoviesViewModel(val moviesCallback: ApiCallback) : ViewModel() {
    fun getMovies(): LiveData<MovieRespone> {
        return moviesCallback.getMovies(BuildConfig.API_KEY)
    }

}