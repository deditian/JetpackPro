package com.dedi.myapplication.movie

import com.dedi.myapplication.data.MovieCatalogue
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test



class MoviesViewModelTest{
    private var testMovie: MoviesViewModel? = null
    private var movie: MovieCatalogue? = null

    @Before
    fun setUp() {
        testMovie = MoviesViewModel()
        movie = MovieCatalogue(
            "m01",
            "A Star Is Born",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "moviesimage/poster_a_start_is_born.jpg"
        )
    }

    @After
    fun tearDown() {
    }

    @Test
    fun movieTest() {
        assertEquals(movie?.courseId, testMovie?.getMovies()?.get(0)?.courseId)
        assertEquals(movie?.title, testMovie?.getMovies()?.get(0)?.title)
        assertEquals(movie?.overview, testMovie?.getMovies()?.get(0)?.overview)
        assertEquals(movie?.imagePath, testMovie?.getMovies()?.get(0)?.imagePath)
    }
}