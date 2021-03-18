package com.dedi.movies.feature.favorite


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dedi.movies.R
import com.dedi.movies.databinding.FragmentFavoriteBinding
import com.dedi.movies.databinding.FragmentTvShowBinding
import com.dedi.movies.home.ViewPagerAdapter
import com.dedi.movies.feature.favorite.FavoriteMovie.FavoriteMovieFragment
import com.dedi.movies.feature.favorite.FavoriteTvShow.FavoriteTvShowFragment
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = "Favorite"
        val adapter = ViewPagerAdapter(childFragmentManager).apply {
            addFragment(FavoriteMovieFragment(), "Movies")
            addFragment(FavoriteTvShowFragment(), "Tv Shows")
        }
        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(viewPager)
    }


}
