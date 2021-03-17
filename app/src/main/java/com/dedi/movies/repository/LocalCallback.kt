package com.dedi.movies.repository


import androidx.paging.DataSource
import com.dedi.movies.data.FavModel

interface LocalCallback {
    fun insert(favModel: FavModel)
    fun getAllMovie(status : String)  : DataSource.Factory<Int, FavModel>
    fun getAllTvShow(status: String)  : DataSource.Factory<Int, FavModel>
    fun getIdFavModel(id:Int): DataSource.Factory<Int, FavModel>
    fun getIdFavTvShow(id:Int): DataSource.Factory<Int, FavModel>
    fun delete(favModel: FavModel)
}