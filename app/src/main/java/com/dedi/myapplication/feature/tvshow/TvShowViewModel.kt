package com.dedi.myapplication.feature.tvshow

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dedi.myapplication.BuildConfig

import com.dedi.myapplication.data.TvShowRespone

import com.dedi.myapplication.repository.ApiRepository


class TvShowViewModel constructor(application: Application, movieRepository: ApiRepository) : ViewModel() {

    fun getTvShow(): LiveData<TvShowRespone> {
        return ApiRepository?.getIntance().reqTvShow(BuildConfig.API_KEY)
    }

    class Factory(private val application: Application, private val apiRepository: ApiRepository) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TvShowViewModel(application, apiRepository) as T
        }
    }
}