package com.dedi.myapplication.repository

import androidx.lifecycle.MutableLiveData
import com.dedi.myapplication.data.MovieCatalogue
import com.dedi.myapplication.utils.DataDummy


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