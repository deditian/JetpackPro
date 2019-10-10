package com.dedi.myapplication.feature.movie

import android.app.Application
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dedi.myapplication.BuildConfig
import com.dedi.myapplication.data.JsonDummyMovies

import com.dedi.myapplication.data.MovieRespone
import com.dedi.myapplication.data.entity.Movie
import com.dedi.myapplication.repository.ApiCallback
import com.dedi.myapplication.repository.ApiRepository

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
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

    @Mock
    lateinit var apiCallback : ApiCallback

    @Mock
    lateinit var observer: Observer<MovieRespone>

    @Mock
    private lateinit var viewmodel: MoviesViewModel
    val data = JsonDummyMovies()
    val gson = GsonBuilder().create()
    var foinderlist = object : TypeToken<MovieRespone>() {}.type
    val movie : MovieRespone = gson.fromJson(data.jdummymovie, foinderlist)

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewmodel = MoviesViewModel(apiCallback)
    }


    @Test
    fun getMovies() {
        val expected = generateDummy()

        Mockito.`when`(apiCallback.getMovies(BuildConfig.API_KEY)).thenReturn(expected)
        viewmodel.getMovies().observeForever(observer)
        verify(observer).onChanged(expected.value)

        assertNotNull(viewmodel.getMovies().value)
        assertNotNull(expected.value)
        assertEquals(expected.value, viewmodel.getMovies().value)

    }

    fun generateDummy(): MutableLiveData<MovieRespone> {
        val data = MutableLiveData<MovieRespone>()
        data.postValue(movie)
        return data
    }
}

