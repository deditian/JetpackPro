package com.dedi.myapplication.feature.movie

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dedi.myapplication.BuildConfig
import com.dedi.myapplication.data.MovieRespone
import com.dedi.myapplication.repository.ApiRepository


class MoviesViewModel(applicationr: Application, apiRepository: ApiRepository) : ViewModel() {

    fun getMovies(): LiveData<MovieRespone> {
        return ApiRepository?.getIntance().reqMovie(BuildConfig.API_KEY)
    }

    class Factory(private val application: Application, private val apiRepository: ApiRepository) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MoviesViewModel(application, apiRepository) as T
        }
    }
}