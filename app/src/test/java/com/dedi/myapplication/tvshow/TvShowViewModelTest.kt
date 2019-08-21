package com.dedi.myapplication.tvshow

import com.dedi.myapplication.data.MovieCatalogue
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest{
    private var testMovie: TvShowViewModel? = null
    private var movie: MovieCatalogue? = null

    @Before
    fun setUp() {
        testMovie = TvShowViewModel()
        movie = MovieCatalogue(
            "t01",
            "Arrow",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "tvshowsimage/poster_arrow.jpg"
        )
    }

    @After
    fun tearDown() {
    }

    @Test
    fun movieTest() {
        assertEquals(movie?.courseId, testMovie?.getTvShow()?.get(0)?.courseId)
        assertEquals(movie?.title, testMovie?.getTvShow()?.get(0)?.title)
        assertEquals(movie?.overview, testMovie?.getTvShow()?.get(0)?.overview)
        assertEquals(movie?.imagePath, testMovie?.getTvShow()?.get(0)?.imagePath)
    }
}