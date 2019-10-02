package com.dedi.myapplication.feature.movie

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dedi.myapplication.data.MovieCatalogue
import com.dedi.myapplication.repository.MovieRepository
import com.dedi.myapplication.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class MoviesViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val movieRepository = mock(MovieRepository::class.java)
    private val application = mock(Application::class.java)

    @Mock
    lateinit var observer: Observer<ArrayList<MovieCatalogue>>

    @Mock
    private lateinit var viewmodel: MoviesViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewmodel = MoviesViewModel(application, movieRepository)
    }


    @Test
    fun getMovies() {
        val expected = generateDummy()

        Mockito.`when`(movieRepository.getAllMovie()).thenReturn(expected)
        viewmodel.getMovies().observeForever(observer)
        verify(observer).onChanged(expected.value)

        assertNotNull(viewmodel.getMovies().value)
        assertNotNull(expected.value)
        assertEquals(expected.value, viewmodel.getMovies().value)

    }

    fun generateDummy(): MutableLiveData<ArrayList<MovieCatalogue>> {
        val data = MutableLiveData<ArrayList<MovieCatalogue>>()
        data.postValue(DataDummy.generateMovies())
        return data
    }
}

