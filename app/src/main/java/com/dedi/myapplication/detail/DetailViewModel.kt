package com.dedi.myapplication.detail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dedi.myapplication.BuildConfig
import com.dedi.myapplication.data.FavModel
import com.dedi.myapplication.data.MovieRespone
import com.dedi.myapplication.feature.movie.MoviesViewModel
import com.dedi.myapplication.repository.ApiRepository

class DetailViewModel(applicationr: Application, apiRepository: ApiRepository) :ViewModel(){

    fun saveFav(favModel: FavModel): LiveData<FavModel> {
        return ApiRepository?.getIntance().saveFavorite(favModel)
    }


    class Factory(private val application: Application, private val apiRepository: ApiRepository) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DetailViewModel(application, apiRepository) as T
        }
    }
}