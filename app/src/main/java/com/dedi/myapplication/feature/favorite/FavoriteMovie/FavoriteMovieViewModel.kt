package com.dedi.myapplication.feature.favorite.FavoriteMovie

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import com.dedi.myapplication.data.FavModel
import com.dedi.myapplication.repository.ApiRepository
import androidx.paging.LivePagedListBuilder
import com.dedi.myapplication.room.CreateDatabase


class FavoriteMovieViewModel (application: Application,apiRepository: ApiRepository):ViewModel(){


    val apiRepository:ApiRepository? = null

    fun getFav(): LiveData<PagedList<FavModel>> {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20).build()

        return LivePagedListBuilder(ApiRepository.getIntance().getFavorite(), pagedListConfig).build()
    }

    class Factory(private val application: Application, private val apiRepository: ApiRepository) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return FavoriteMovieViewModel(
                application,
                apiRepository
            ) as T
        }
    }
}