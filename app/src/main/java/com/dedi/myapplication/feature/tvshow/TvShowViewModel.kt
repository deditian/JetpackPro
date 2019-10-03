package com.dedi.myapplication.feature.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dedi.myapplication.BuildConfig
import com.dedi.myapplication.data.TvShowRespone
import com.dedi.myapplication.repository.ApiRepository


class TvShowViewModel(val apiRepository: ApiRepository) : ViewModel() {

    fun getTvShow(): LiveData<TvShowRespone> {
        return apiRepository.reqTvShow(BuildConfig.API_KEY)
    }
}