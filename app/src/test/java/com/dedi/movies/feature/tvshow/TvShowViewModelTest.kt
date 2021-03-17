package com.dedi.movies.feature.tvshow


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dedi.movies.BuildConfig
import com.dedi.movies.data.JsonDummyMovies
import com.dedi.movies.data.TvShowRespone
import com.dedi.movies.repository.ApiCallback
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class TvShowViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var apiCallback : ApiCallback

    @Mock
    lateinit var observer: Observer<TvShowRespone>

    @Mock
    private lateinit var viewmodel: TvShowViewModel
    val data = JsonDummyMovies()
    val gson = GsonBuilder().create()
    var foinderlist = object : TypeToken<TvShowRespone>() {}.type
    val tvshow : TvShowRespone = gson.fromJson(data.jdummymovie, foinderlist)

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewmodel = TvShowViewModel(apiCallback)
    }

    @Test
    fun getTvShows() {
        val expected = generateDummy()

        Mockito.`when`(apiCallback.getTvShows(BuildConfig.API_KEY)).thenReturn(expected)
        viewmodel.getTvShow().observeForever(observer)
        verify(observer).onChanged(expected.value)

        assertNotNull(viewmodel.getTvShow().value)
        assertNotNull(expected.value)
        assertEquals(expected.value, viewmodel.getTvShow().value)

    }

    fun generateDummy(): MutableLiveData<TvShowRespone> {
        val data = MutableLiveData<TvShowRespone>()
        data.postValue(tvshow)
        return data
    }
}