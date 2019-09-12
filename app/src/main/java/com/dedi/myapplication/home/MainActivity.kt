package com.dedi.myapplication.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dedi.myapplication.R
import com.dedi.myapplication.adapter.ViewPagerAdapter
import com.dedi.myapplication.movie.MovieFragment
import com.dedi.myapplication.tvshow.TvShowFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val adapter = ViewPagerAdapter(supportFragmentManager).apply {
            addFragment(MovieFragment(), "Movies")
            addFragment(TvShowFragment(), "Tv Shows")
        }
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}
