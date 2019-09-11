package com.dedi.myapplication.repository

import android.content.Context
import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dedi.myapplication.data.MovieCatalogue
import com.dedi.myapplication.utils.DataDummy
import com.dedi.myapplication.utils.EspressoIdlingResource


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