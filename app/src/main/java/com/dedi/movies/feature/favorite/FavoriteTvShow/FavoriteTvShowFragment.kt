package com.dedi.movies.feature.favorite.FavoriteTvShow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dedi.movies.R
import com.dedi.movies.databinding.FragmentMovieBinding
import com.dedi.movies.databinding.FragmentTvShowBinding
import org.koin.android.ext.android.inject

class FavoriteTvShowFragment : Fragment() {

    val TAG ="FavoriteMovieFragment"
    private var academyAdapter: FavoriteTvShowAdapter? = null
    val viewModel:FavoriteTvShowViewModel by inject()

    private var _binding: FragmentTvShowBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {

//            fav_progressBar.visibility =View.VISIBLE
            observeViewModelRequest()

            academyAdapter = FavoriteTvShowAdapter()

            binding.rvTvShow.layoutManager =  GridLayoutManager(context,2)
            binding.rvTvShow.setHasFixedSize(true)
            binding.rvTvShow.adapter = academyAdapter
        }

    }

    private fun observeViewModelRequest() {
        // Update the list when the data changes
        viewModel.getFavTvShow("tv_show").observe(this, Observer {data ->
//            fav_progressBar.visibility =View.GONE
            if (data != null){
                academyAdapter?.submitList(data)
                academyAdapter?.notifyDataSetChanged()
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}