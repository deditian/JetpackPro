package com.dedi.myapplication.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*

import com.dedi.myapplication.data.FavModel

@Dao
interface FavDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favModel: FavModel)

    @Query("SELECT * from favorite_table WHERE statusfav IN (:status) ORDER BY titlefav ASC")
    fun getAllMovie(status: String): DataSource.Factory<Int, FavModel>

    @Query("SELECT * from favorite_table WHERE statusfav IN (:status) ORDER BY titlefav ASC")
    fun getAllTvShow(status : String): DataSource.Factory<Int, FavModel>

    @Query("SELECT * FROM favorite_table WHERE idfav IN (:id)")
    fun getById(id: Int): DataSource.Factory<Int, FavModel>

    @Delete
    fun delete(favModel: FavModel)

    @Update
    fun update(favModel: FavModel)

    @Query("DELETE FROM favorite_table")
    fun deleteAll()

}