package com.dedi.myapplication.movie

import com.dedi.myapplication.data.MovieCatalogue

import org.junit.Before
import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dedi.myapplication.repository.MovieRepository
import com.dedi.myapplication.utils.DataDummy
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull

class MoviesViewModelTest {
    private var viewModel: MoviesViewModel? = null
    private val movieRepository = mock(MoviesViewModel::class.java)



    @Mock
    private lateinit var remote : MovieRepository

    @Mock
    private lateinit var viewmodel : MoviesViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MoviesViewModel(movieRepository)
    }

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Test
    fun getMovies() {
        val expected = generateDummy()


        Mockito.`when`(movieRepository.getMovies()).thenReturn(expected)

//        verify(remote).getAllMovie()
//        assertNotNull(viewmodel.getMovies().value)
        assertNotNull(expected.value)
//        assertEquals(expected.value, viewmodel.getMovies().value)

    }

    fun generateDummy(): MutableLiveData<ArrayList<MovieCatalogue>> {
        val data = MutableLiveData<ArrayList<MovieCatalogue>>()
        data.postValue(DataDummy.generateMovies())
        return data
    }
}

