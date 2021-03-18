package com.dedi.movies.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dedi.movies.R
import com.dedi.movies.databinding.ActivityMainBinding
import com.dedi.movies.feature.favorite.FavoriteFragment
import com.dedi.movies.feature.movie.MovieFragment
import com.dedi.movies.feature.tvshow.TvShowFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            val fragment = MovieFragment()
            supportFragmentManager.beginTransaction().replace(binding.container.id, fragment, fragment.javaClass.simpleName)
                .commit()
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.navigation_movie -> {
                val fragment = MovieFragment()
                supportFragmentManager.beginTransaction().replace(binding.container.id, fragment, fragment.javaClass.simpleName)
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_tv_show -> {
                val fragment = TvShowFragment()
                supportFragmentManager.beginTransaction().replace(binding.container.id, fragment, fragment.javaClass.simpleName)
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorite -> {
                val fragment = FavoriteFragment()
                supportFragmentManager.beginTransaction().replace(binding.container.id, fragment, fragment.javaClass.simpleName)
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
