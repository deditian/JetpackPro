package com.dedi.myapplication.di

import android.app.Application

import com.dedi.myapplication.repository.ApiRepository
import com.dedi.myapplication.room.FavDatabase
import com.dedi.myapplication.utils.AppExecutors

object Injection {
    fun provideRepository(application: Application): ApiRepository {

        val database = FavDatabase.getInstance(application)
        val appExecutors = AppExecutors()
        return ApiRepository.getInstance(database.favDao(), appExecutors)
    }
}