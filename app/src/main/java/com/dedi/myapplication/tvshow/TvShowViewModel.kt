package com.dedi.myapplication.tvshow

import androidx.lifecycle.ViewModel
import com.dedi.myapplication.data.MovieCatalogue
import com.dedi.myapplication.utils.DataDummy


class TvShowViewModel : ViewModel() {
    fun getTvShow(): List<MovieCatalogue> {
        return DataDummy.generateTvShows()
    }
}