package com.dedi.movies.feature.favorite.FavoriteMovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dedi.movies.data.FavModel
import com.dedi.movies.repository.LocalCallback


class FavoriteMovieViewModel (val localCallback: LocalCallback):ViewModel(){

    fun getFavMovies(status:String): LiveData<PagedList<FavModel>> {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20).build()

        return LivePagedListBuilder(localCallback.getAllMovie(status), pagedListConfig).build()
    }

}