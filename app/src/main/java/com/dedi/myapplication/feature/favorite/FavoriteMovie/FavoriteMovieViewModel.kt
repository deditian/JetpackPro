package com.dedi.myapplication.feature.favorite.FavoriteMovie

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dedi.myapplication.data.FavModel
import com.dedi.myapplication.repository.LocalCallback
import com.dedi.myapplication.repository.LocalRepository



class FavoriteMovieViewModel (val localCallback: LocalCallback):ViewModel(){

    fun getFavMovies(status:String): LiveData<PagedList<FavModel>> {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20).build()

        return LivePagedListBuilder(localCallback.getAllMovie(status), pagedListConfig).build()
    }

}