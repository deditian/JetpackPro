package com.dedi.myapplication.tvshow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.dedi.myapplication.data.MovieCatalogue

import com.dedi.myapplication.repository.TvShowRepository


class TvShowViewModel constructor(val tvShowRepository: TvShowRepository.Companion) : ViewModel() {
    fun getTvShow(): MutableLiveData<ArrayList<MovieCatalogue>> {
        return TvShowRepository?.getIntance().getAllTvShow()
    }

    class Factory : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TvShowViewModel(TvShowRepository) as T
        }
    }
}