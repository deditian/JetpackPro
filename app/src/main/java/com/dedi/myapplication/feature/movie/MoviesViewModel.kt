package com.dedi.myapplication.feature.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dedi.myapplication.BuildConfig
import com.dedi.myapplication.data.MovieRespone
import com.dedi.myapplication.repository.ApiRepository


class MoviesViewModel(val apiRepository: ApiRepository) : ViewModel() {

    fun getMovies(): LiveData<MovieRespone> {
        return apiRepository.reqMovie(BuildConfig.API_KEY)
    }
}