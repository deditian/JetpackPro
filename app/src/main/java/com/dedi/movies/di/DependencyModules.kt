package com.dedi.movies.di

import androidx.room.Room
import com.dedi.movies.repository.LocalCallback
import com.dedi.movies.detail.DetailViewModel
import com.dedi.movies.feature.favorite.FavoriteMovie.FavoriteMovieViewModel
import com.dedi.movies.feature.favorite.FavoriteTvShow.FavoriteTvShowViewModel
import com.dedi.movies.feature.movie.MoviesViewModel
import com.dedi.movies.feature.tvshow.TvShowViewModel
import com.dedi.movies.repository.ApiCallback
import com.dedi.movies.repository.ApiRepository
import com.dedi.movies.repository.LocalRepository
import com.dedi.movies.room.MyDatabase
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