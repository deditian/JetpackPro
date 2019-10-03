package com.dedi.myapplication.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dedi.myapplication.api.ApiService
import com.dedi.myapplication.data.FavModel
import com.dedi.myapplication.data.MovieRespone
import com.dedi.myapplication.data.TvShowRespone
import com.dedi.myapplication.room.FavDao
import com.dedi.myapplication.utils.AppExecutors
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiRepository(val dao: FavDao, val appExecutors: AppExecutors) {

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

    companion object{
        private var launchRepository: ApiRepository? = null
        @Synchronized
        @JvmStatic
        fun getInstance(dao: FavDao, appExecutors: AppExecutors): ApiRepository {
            if (launchRepository == null){
                launchRepository = ApiRepository(dao, appExecutors)
            }
            return launchRepository as ApiRepository
        }
    }


    fun reqMovie(userId: String): LiveData<MovieRespone> {
        val data = MutableLiveData<MovieRespone>()
        apiService?.requestMovieApi(userId)?.enqueue(object : Callback<MovieRespone> {
            override fun onResponse(call: Call<MovieRespone>, response: Response<MovieRespone>) {
                data.value=response.body()
                Log.i(TAG, "code_responese ${response.code()}")
            }

            override fun onFailure(call: Call<MovieRespone>, t: Throwable) {
                // TODO better error handling in part #2 ...
                data.value=null
                Log.i(TAG, "code_responese null"+ t.printStackTrace())
            }
        })

        return data
    }

    fun reqTvShow(userId: String): LiveData<TvShowRespone> {
        val data = MutableLiveData<TvShowRespone>()
        apiService?.requestTvShowApi(userId)?.enqueue(object : Callback<TvShowRespone> {
            override fun onResponse(call: Call<TvShowRespone>, response: Response<TvShowRespone>) {
                if (response.code() == 200 || response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<TvShowRespone>, t: Throwable) {
                data.value=null
            }
        })
        return data
    }


    fun saveFavorite(favModel: FavModel): LiveData<FavModel>{
        val saveData = MutableLiveData<FavModel>()
        appExecutors.mainThread().execute {
            dao.insert(favModel)
            saveData.value=favModel
        }
        return saveData
    }

    fun getFavorite(): DataSource.Factory<Int, FavModel> {
        return dao.getAll()
    }
}