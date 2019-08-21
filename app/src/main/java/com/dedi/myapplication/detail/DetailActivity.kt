package com.dedi.myapplication.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.dedi.myapplication.R
import com.dedi.myapplication.data.MovieCatalogue
import com.dedi.myapplication.tvshow.TvShowViewModel
import com.dedi.myapplication.utils.DataDummy
import com.dedi.myapplication.utils.imageLoad

import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.toolbar
import kotlinx.android.synthetic.main.content_detail.*
import kotlinx.android.synthetic.main.item_content.*
import kotlinx.android.synthetic.main.item_content.view.*
import java.nio.file.Files.size




class DetailActivity : AppCompatActivity() {

    private val  result by lazy {
        intent.getParcelableExtra<MovieCatalogue>("movies")
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        txtTitleDetail.text = result.title
        txt_overview.text = result.overview
        img_Poster_Detail.imageLoad(result.imagePath.toString())
    }

}
