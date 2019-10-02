package com.dedi.myapplication.api


import androidx.lifecycle.LiveData
import com.dedi.myapplication.data.MovieRespone
import com.dedi.myapplication.data.TvShowRespone
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    fun requestMovieApi(
        @Query("api_key") api_key: String
    ): Call<MovieRespone>

    @GET("tv/popular")
    fun requestTvShowApi(
        @Query("api_key") api_key: String
    ): Call<TvShowRespone>

}
