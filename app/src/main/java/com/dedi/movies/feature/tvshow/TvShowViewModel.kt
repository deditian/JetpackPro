package com.dedi.movies.feature.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dedi.movies.BuildConfig

import com.dedi.movies.data.TvShowRespone
import com.dedi.movies.repository.ApiCallback


class TvShowViewModel (val tvShowCallback: ApiCallback) : ViewModel() {

    fun getTvShow(): LiveData<TvShowRespone> {
        return tvShowCallback.getTvShows(BuildConfig.API_KEY)
    }
}