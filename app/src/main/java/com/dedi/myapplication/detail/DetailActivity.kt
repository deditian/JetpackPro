package com.dedi.myapplication.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dedi.myapplication.R
import com.dedi.myapplication.data.MovieCatalogue
import com.dedi.myapplication.utils.imageLoad
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*


class DetailActivity : AppCompatActivity() {

    private val result by lazy {
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
