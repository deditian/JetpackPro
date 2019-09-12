package com.dedi.myapplication.movie

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dedi.myapplication.data.MovieCatalogue
import com.dedi.myapplication.repository.MovieRepository


class MoviesViewModel(applicationr: Application, movieRepository: MovieRepository) : ViewModel() {


    fun getMovies(): MutableLiveData<ArrayList<MovieCatalogue>> {
        return MovieRepository?.getIntance().getAllMovie()
    }

    class Factory(private val application: Application, private val movieRepository: MovieRepository) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MoviesViewModel(application, movieRepository) as T
        }
    }
}