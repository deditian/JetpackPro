package com.dedi.myapplication.feature.favorite.FavoriteMovie

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dedi.myapplication.data.FavModel
import com.dedi.myapplication.repository.ApiRepository


class FavoriteMovieViewModel(val apiRepository: ApiRepository) :
    ViewModel() {


    fun getFav(): LiveData<PagedList<FavModel>> {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20).build()

        return LivePagedListBuilder(apiRepository.getFavorite(), pagedListConfig).run { build() }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory(private val application: Application, private val apiRepository: ApiRepository) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return FavoriteMovieViewModel(apiRepository) as T
        }
    }
}