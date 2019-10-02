package com.dedi.myapplication.feature.tvshow


import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dedi.myapplication.data.MovieCatalogue
import com.dedi.myapplication.repository.TvShowRepository
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


class TvShowViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val tvShowRepository = mock(TvShowRepository::class.java)
    private val application = mock(Application::class.java)

    @Mock
    lateinit var observer: Observer<ArrayList<MovieCatalogue>>

    @Mock
    private lateinit var viewmodel: TvShowViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewmodel = TvShowViewModel(application, tvShowRepository)
    }


    @Test
    fun getTvShows() {
        val expected = generateDummy()

        Mockito.`when`(tvShowRepository.getAllTvShow()).thenReturn(expected)
        viewmodel.getTvShow().observeForever(observer)
        verify(observer).onChanged(expected.value)

        assertNotNull(viewmodel.getTvShow().value)
        assertNotNull(expected.value)
        assertEquals(expected.value, viewmodel.getTvShow().value)

    }

    fun generateDummy(): MutableLiveData<ArrayList<MovieCatalogue>> {
        val data = MutableLiveData<ArrayList<MovieCatalogue>>()
        data.postValue(DataDummy.generateTvShows())
        return data
    }
}