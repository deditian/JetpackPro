package com.dedi.movies.room

import androidx.room.Database
import androidx.room.RoomDatabase

import com.dedi.movies.data.FavModel

@Database(entities = [FavModel::class], version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract fun favDao(): FavDao
}