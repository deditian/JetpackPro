package com.dedi.myapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dedi.myapplication.data.FavModel

@Database(entities = arrayOf(FavModel::class), version = 1)
abstract class FavDatabase: RoomDatabase() {
    abstract fun favDao(): FavDao
}