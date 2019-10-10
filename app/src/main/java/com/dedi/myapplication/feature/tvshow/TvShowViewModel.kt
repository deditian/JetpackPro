package com.dedi.myapplication.feature.tvshow

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dedi.myapplication.BuildConfig

import com.dedi.myapplication.data.TvShowRespone
import com.dedi.myapplication.repository.ApiCallback

import com.dedi.myapplication.repository.ApiRepository


class TvShowViewModel (val tvShowCallback: ApiCallback) : ViewModel() {

    fun getTvShow(): LiveData<TvShowRespone> {
        return tvShowCallback.getTvShows(BuildConfig.API_KEY)
    }
}