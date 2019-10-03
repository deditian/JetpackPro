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

class DetailViewModel( val apiRepository: ApiRepository) :ViewModel(){
    fun saveFav(favModel: FavModel): LiveData<FavModel> {
        return apiRepository.saveFavorite(favModel)
    }
}