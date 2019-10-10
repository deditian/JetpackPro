package com.dedi.myapplication.di

import androidx.room.Room
import com.dedi.myapplication.repository.LocalCallback
import com.dedi.myapplication.detail.DetailViewModel
import com.dedi.myapplication.feature.favorite.FavoriteMovie.FavoriteMovieViewModel
import com.dedi.myapplication.feature.favorite.FavoriteTvShow.FavoriteTvShowViewModel
import com.dedi.myapplication.feature.movie.MoviesViewModel
import com.dedi.myapplication.feature.tvshow.TvShowViewModel
import com.dedi.myapplication.repository.ApiCallback
import com.dedi.myapplication.repository.ApiRepository
import com.dedi.myapplication.repository.LocalRepository
import com.dedi.myapplication.room.MyDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext


object DependencyModules {

    val appModules = applicationContext {

        bean { LocalRepository(get()) as LocalCallback }
        bean { ApiRepository() as ApiCallback }

        factory { DetailViewModel(get()) }

        factory { MoviesViewModel(get())}

        factory { TvShowViewModel(get()) }

        factory { FavoriteMovieViewModel(get()) }
        factory { FavoriteTvShowViewModel(get()) }

        bean { get<MyDatabase>().favDao() }

        bean {
            Room.databaseBuilder(androidApplication(), MyDatabase::class.java, "Favorites-db").allowMainThreadQueries()
                .build()
        }
    }
}