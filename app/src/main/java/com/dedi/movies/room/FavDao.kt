package com.dedi.movies.room

import androidx.paging.DataSource
import androidx.room.*

import com.dedi.movies.data.FavModel

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

}