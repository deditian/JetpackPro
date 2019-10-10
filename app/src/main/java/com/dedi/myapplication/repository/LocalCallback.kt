package com.dedi.myapplication.repository

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dedi.myapplication.data.DetailModel
import com.dedi.myapplication.data.FavModel

interface LocalCallback {
    fun insert(favModel: FavModel)
    fun getAllMovie(status : String)  : DataSource.Factory<Int, FavModel>
    fun getAllTvShow(status: String)  : DataSource.Factory<Int, FavModel>
    fun getIdFavModel(id:Int): DataSource.Factory<Int, FavModel>
    fun getIdFavTvShow(id:Int): DataSource.Factory<Int, FavModel>
    fun delete(favModel: FavModel)
}