package com.dedi.movies.repository

import androidx.paging.DataSource
import com.dedi.movies.data.FavModel
import com.dedi.movies.room.FavDao

class LocalRepository(private val favDao: FavDao): LocalCallback {
    override fun getAllMovie(status: String): DataSource.Factory<Int, FavModel> {
        return favDao.getAllMovie(status)
    }

    override fun getAllTvShow(status: String): DataSource.Factory<Int, FavModel> {
        return favDao.getAllTvShow(status)
    }

    override fun getIdFavTvShow(id: Int): DataSource.Factory<Int, FavModel> {
        return favDao.getById(id)
    }

    override fun delete(favModel: FavModel) {
       return favDao.delete(favModel)
    }

    override fun getIdFavModel(id: Int): DataSource.Factory<Int, FavModel> {
        return favDao.getById(id)
    }

    override fun insert(favModel: FavModel) {
       return favDao.insert(favModel)
    }
}