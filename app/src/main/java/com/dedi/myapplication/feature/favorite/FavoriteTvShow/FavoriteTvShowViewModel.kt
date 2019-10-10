package com.dedi.myapplication.feature.favorite.FavoriteTvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dedi.myapplication.data.FavModel
import com.dedi.myapplication.repository.LocalCallback


class FavoriteTvShowViewModel (val localCallback: LocalCallback): ViewModel(){

    fun getFavTvShow(status:String): LiveData<PagedList<FavModel>> {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20).build()

        return LivePagedListBuilder(localCallback.getAllTvShow(status), pagedListConfig).build()
    }

}