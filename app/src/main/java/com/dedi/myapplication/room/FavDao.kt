package com.dedi.myapplication.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.room.OnConflictStrategy.FAIL
import com.dedi.myapplication.data.DetailModel
import com.dedi.myapplication.data.FavModel

@Dao
interface FavDao {
    @Insert(onConflict = FAIL)
    fun insert(user: FavModel)

    @Query("SELECT * from fav ORDER BY id ASC")
    fun getAll(): DataSource.Factory<Int, FavModel>

    @Delete
    fun delete(favModel: FavModel)

    @Update
    fun update(favModel: FavModel)

    @Query("DELETE FROM fav")
    fun deleteAll()

}