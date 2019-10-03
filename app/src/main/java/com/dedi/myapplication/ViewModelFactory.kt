package com.dedi.myapplication

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import com.dedi.myapplication.di.Injection
import androidx.lifecycle.ViewModelProvider
import com.dedi.myapplication.detail.DetailViewModel
import com.dedi.myapplication.feature.favorite.FavoriteMovie.FavoriteMovieViewModel
import com.dedi.myapplication.feature.movie.MoviesViewModel
import com.dedi.myapplication.feature.tvshow.TvShowViewModel
import com.dedi.myapplication.repository.ApiRepository


@Suppress("UNCHECKED_CAST")
class ViewModelFactory private constructor(private val mApiRepository: ApiRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(TvShowViewModel::class.java)) {

            return TvShowViewModel(mApiRepository) as T
        } else if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {

            return MoviesViewModel(mApiRepository) as T
        } else if (modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java)) {

            return FavoriteMovieViewModel(mApiRepository) as T
        }else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {

            return DetailViewModel(mApiRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application): ViewModelFactory? {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = ViewModelFactory(Injection.provideRepository(application))
                    }
                }
            }
            return INSTANCE
        }
    }

}