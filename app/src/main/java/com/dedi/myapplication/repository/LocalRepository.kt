package com.dedi.myapplication.repository

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dedi.myapplication.data.DetailModel
import com.dedi.myapplication.data.FavModel
import com.dedi.myapplication.room.FavDao
import java.sql.ClientInfoStatus

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