package com.dedi.movies.feature.favorite.FavoriteTvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dedi.movies.data.FavModel
import com.dedi.movies.repository.LocalCallback


class FavoriteTvShowViewModel (private val localCallback: LocalCallback): ViewModel(){

    fun getFavTvShow(status:String): LiveData<PagedList<FavModel>> {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20).build()

        return LivePagedListBuilder(localCallback.getAllTvShow(status), pagedListConfig).build()
    }

}