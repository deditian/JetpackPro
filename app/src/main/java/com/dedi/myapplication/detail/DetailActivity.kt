package com.dedi.myapplication.detail

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.dedi.myapplication.R
import com.dedi.myapplication.data.DetailModel
import com.dedi.myapplication.data.FavModel
import com.dedi.myapplication.utils.imageLoad
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import org.koin.android.ext.android.inject


class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by inject()
    var pilih : Boolean = false
    val TAG = "DetailActivity"
    private val list_data by lazy {
        intent.getParcelableExtra<DetailModel>("list_data")
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setFavorite(pilih)
        viewModel.getFavMovies(list_data.id).observe(this, Observer {
            Log.i(TAG, "isi dari getFavMovies $it")
            if (it.isNotEmpty()) {
                    setFavorite(true)
                    pilih =false
            }else{
                setFavorite(false)
                pilih = true
            }
        })

        list_data.let {
            txtTitleDetail.text = it.title
            txt_overview.text = it.overview
            img_Poster_Detail.imageLoad(it.Image)
        }



        floatingActionButton.setOnClickListener {
           actionclick()
        }
    }

    private fun actionclick( ) {
        var data = list_data.status
        if (pilih){
            if (data == "movie"){
            Log.i(TAG, "atas")
            viewModel.saveFav(FavModel(
                list_data.id,list_data.title,list_data.Image,list_data.overview,"movie"
            ))}else{
                viewModel.saveFav(FavModel(
                    list_data.id,list_data.title,list_data.Image,list_data.overview,"tv_show"))
            }
            setFavorite(true)
            Toasty.success(this, "Save", Toasty.LENGTH_SHORT).show()
        }else{
            if (data == "movie"){
                Log.i(TAG, "bawah")
                viewModel.deleteFav(FavModel(
                    list_data.id,list_data.title,list_data.Image,list_data.overview,"movie"
                ))
            }else{
                viewModel.deleteFav(FavModel(
                    list_data.id,list_data.title,list_data.Image,list_data.overview,"tv_show"
                ))
            }
            setFavorite(false)
            Toasty.success(this, "Delete", Toasty.LENGTH_SHORT).show()
        }
    }

    private fun setFavorite(boolean: Boolean) {
        if (boolean) {
            floatingActionButton.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_black_24dp))

        } else {
            floatingActionButton.setImageDrawable(resources.getDrawable(R.drawable.ic_unfavorite_border_black_24dp))
        }
    }



}
