package com.dedi.myapplication.detail

import androidx.lifecycle.LiveData

import androidx.lifecycle.ViewModel

import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dedi.myapplication.data.FavModel
import com.dedi.myapplication.repository.LocalCallback

class DetailViewModel (val localCallback: LocalCallback) : ViewModel(){


    fun saveFav(favModel: FavModel) {
        localCallback.insert(favModel)
    }

    fun deleteFav(favModel: FavModel){
        localCallback.delete(favModel)
    }


    fun getFavMovies(id : Int): LiveData<PagedList<FavModel>> {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20).build()
        return LivePagedListBuilder(localCallback.getIdFavModel(id), pagedListConfig).build()
    }





}