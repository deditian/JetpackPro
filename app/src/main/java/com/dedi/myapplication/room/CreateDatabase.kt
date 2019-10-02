package com.dedi.myapplication.room

import android.app.Application
import androidx.room.Room

class CreateDatabase: Application() {
    override fun onCreate() {
        super.onCreate()
        database= Room.databaseBuilder(this, FavDatabase::class.java, "favorites.db").allowMainThreadQueries().build()
    }
    companion object {
        var database:  FavDatabase? = null
    }
}