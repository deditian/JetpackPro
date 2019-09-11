package com.dedi.myapplication.repository

import android.content.Context
import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dedi.myapplication.data.MovieCatalogue
import com.dedi.myapplication.utils.DataDummy
import androidx.annotation.NonNull
import com.dedi.myapplication.utils.EspressoIdlingResource


class TvShowRepository {
    companion object {
        private var tvShowRepository: TvShowRepository? = null
        @Synchronized
        @JvmStatic
        fun getIntance(): TvShowRepository {
            if (tvShowRepository == null) {
                tvShowRepository = TvShowRepository()
            }
            return tvShowRepository as TvShowRepository
        }
    }

    fun getAllTvShow(): MutableLiveData<ArrayList<MovieCatalogue>> {
        val data = MutableLiveData<ArrayList<MovieCatalogue>>()
            val getdata = DataDummy.generateTvShows()
            data.value = getdata
        return data
    }

}