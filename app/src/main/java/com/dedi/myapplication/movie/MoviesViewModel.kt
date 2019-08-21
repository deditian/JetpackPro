package com.dedi.myapplication.movie

import androidx.lifecycle.ViewModel
import com.dedi.myapplication.data.MovieCatalogue
import com.dedi.myapplication.utils.DataDummy

class MoviesViewModel : ViewModel() {
    fun getMovies(): List<MovieCatalogue> {
        return DataDummy.generateMovies()
    }
}