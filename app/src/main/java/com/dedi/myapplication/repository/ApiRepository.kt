package com.dedi.myapplication.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dedi.myapplication.api.ApiService
import com.dedi.myapplication.data.FavModel
import com.dedi.myapplication.data.MovieRespone
import com.dedi.myapplication.data.TvShowRespone
import com.dedi.myapplication.utils.EspressoIdlingResource.decrement
import com.dedi.myapplication.utils.EspressoIdlingResource.increment


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRepository : ApiCallback{
    val TAG = "ApiRepository"
    private val HTTP_API_SETUP_WIZART_URL = "https://api.themoviedb.org/3/"
    private var apiService: ApiService? = null

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(HTTP_API_SETUP_WIZART_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    override fun getMovies(uid: String): LiveData<MovieRespone> {
        increment()
        val data = MutableLiveData<MovieRespone>()
        apiService?.requestMovieApi(uid)?.enqueue(object : Callback<MovieRespone> {
            override fun onResponse(call: Call<MovieRespone>, response: Response<MovieRespone>) {
                if (response.code() == 200 || response.isSuccessful) {
                    data.value = response.body()
                    Log.i(TAG, "code_responese"+response.code())
                    decrement()
                }
            }

            override fun onFailure(call: Call<MovieRespone>, t: Throwable) {
                data.value=null
                Log.i(TAG, "code_responese null"+ t.printStackTrace())
            }
        })

        return data

    }

    override fun getTvShows(uid: String): LiveData<TvShowRespone> {
        increment()
        val data = MutableLiveData<TvShowRespone>()
        apiService?.requestTvShowApi(uid)?.enqueue(object : Callback<TvShowRespone> {
            override fun onResponse(call: Call<TvShowRespone>, response: Response<TvShowRespone>) {
                if (response.code() == 200 || response.isSuccessful) {
                    data.value = response.body()
                    decrement()
                }
            }
            override fun onFailure(call: Call<TvShowRespone>, t: Throwable) {
                data.value=null
            }
        })
        return data
    }



//
//    companion object{
//        private var launchRepository: ApiRepository? = null
//        @Synchronized
//        @JvmStatic
//        fun getIntance() : ApiRepository{
//            if (launchRepository == null){
//                launchRepository = ApiRepository()
//            }
//            return  launchRepository!!
//        }
//    }
//
//
//    fun reqMovie(userId: String): LiveData<MovieRespone> {
//
//    }
//
//    fun reqTvShow(userId: String): LiveData<TvShowRespone> {
//
//    }


//    fun saveFavorite(favModel: List<FavModel>): LiveData<List<FavModel>>{
//        val saveData=MutableLiveData<List<FavModel>>()
//
//        val simpan =
//        saveData.value=favModel
//        Log.i(TAG,"datanya save"+simpan)
//        return saveData
//    }

//    fun getFavorite(): MoviesCallback.Factory<Int, FavModel>? {
//        val asd = database!!.favDao().getAll()
//        return asd
//    }

}