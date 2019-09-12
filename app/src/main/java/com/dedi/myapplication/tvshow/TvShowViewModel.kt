package com.dedi.myapplication.tvshow

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.dedi.myapplication.data.MovieCatalogue

import com.dedi.myapplication.repository.TvShowRepository


class TvShowViewModel constructor(application: Application, movieRepository: TvShowRepository) : ViewModel() {
    fun getTvShow(): MutableLiveData<ArrayList<MovieCatalogue>> {
        return TvShowRepository?.getIntance().getAllTvShow()
    }

    class Factory(private val application: Application, private val movieRepository: TvShowRepository) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TvShowViewModel(application, movieRepository) as T
        }
    }
}