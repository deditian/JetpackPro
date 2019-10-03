package com.dedi.myapplication.detail

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dedi.myapplication.R
import com.dedi.myapplication.ViewModelFactory
import com.dedi.myapplication.data.DetailModel
import com.dedi.myapplication.data.FavModel
import com.dedi.myapplication.feature.tvshow.TvShowViewModel
import com.dedi.myapplication.repository.ApiRepository
import com.dedi.myapplication.utils.imageLoad
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*


class DetailActivity : AppCompatActivity() {

    val TAG = "DetailActivity"
    private val result by lazy {
            intent.getParcelableExtra<DetailModel>("movies")
    }

    lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        detailViewModel = obtainViewModel(this)

        txtTitleDetail.text = result.title
        txt_overview.text = result.overview
        img_Poster_Detail.imageLoad(result.Image)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menufavorite, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.menu_favorite -> observeViewModelRequest(detailViewModel,FavModel(result.id,result.title,result.Image,result.overview))

        }
        return super.onOptionsItemSelected(item)
    }





    private fun observeViewModelRequest(detailViewModel: DetailViewModel,favModel: FavModel) {
        detailViewModel.saveFav(favModel).observe(this, Observer { data ->
            if (data != null) {
                Log.i(TAG,"datanya = $data")
                Toasty.success(applicationContext, "Save Success", Toast.LENGTH_SHORT).show()
            }else{
                Toasty.error(applicationContext, "Failed Save", Toast.LENGTH_SHORT).show()
            }
            }
        )

    }

    private fun obtainViewModel(activity: AppCompatActivity): DetailViewModel {
        // Use a Factory to inject dependencies into the ViewModel
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(DetailViewModel::class.java)
    }
}
