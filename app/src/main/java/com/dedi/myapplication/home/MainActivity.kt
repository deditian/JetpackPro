package com.dedi.myapplication.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.dedi.myapplication.R
import com.dedi.myapplication.adapter.ViewPagerAdapter
import com.dedi.myapplication.movie.MovieFragment
import com.dedi.myapplication.tvshow.TvShowFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(MovieFragment(), "Movies")
        adapter.addFragment(TvShowFragment(), "Tv Shows")

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}
