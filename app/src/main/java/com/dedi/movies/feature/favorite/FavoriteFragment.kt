package com.dedi.movies.feature.favorite


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dedi.movies.R
import com.dedi.movies.home.ViewPagerAdapter
import com.dedi.movies.feature.favorite.FavoriteMovie.FavoriteMovieFragment
import com.dedi.movies.feature.favorite.FavoriteTvShow.FavoriteTvShowFragment
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = "Favorite"
        val adapter = ViewPagerAdapter(childFragmentManager).apply {
            addFragment(FavoriteMovieFragment(), "Movies")
            addFragment(FavoriteTvShowFragment(), "Tv Shows")
        }
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }


}
