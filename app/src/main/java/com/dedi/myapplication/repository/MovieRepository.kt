package com.dedi.myapplication.repository

import androidx.lifecycle.MutableLiveData
import com.dedi.myapplication.data.MovieCatalogue
import com.dedi.myapplication.utils.DataDummy


class MovieRepository {
    companion object {
        private var movieRepository: MovieRepository? = null
        @Synchronized
        @JvmStatic
        fun getIntance(): MovieRepository {
            if (movieRepository == null) {
                movieRepository = MovieRepository()
            }
            return movieRepository!!
        }
    }

    fun getAllMovie(): MutableLiveData<ArrayList<MovieCatalogue>> {
        val data = MutableLiveData<ArrayList<MovieCatalogue>>()
        val getdata = DataDummy.generateMovies()
        data.postValue(getdata)
        return data
    }

}