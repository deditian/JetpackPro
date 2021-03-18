package com.dedi.movies.feature.favorite.FavoriteMovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import com.dedi.movies.databinding.FragmentMovieBinding
import org.koin.android.ext.android.inject

class FavoriteMovieFragment : Fragment() {
    val TAG ="FavoriteMovieFragment"
    private var academyAdapter: FavoriteMovieAdapter? = null
    val viewModel:FavoriteMovieViewModel by inject()

    private var _binding: FragmentMovieBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {

            binding.progressBar.visibility = View.VISIBLE
            observeViewModelRequest()

            academyAdapter = FavoriteMovieAdapter()

            binding.rvMovies.layoutManager = LinearLayoutManager(context)
            binding.rvMovies.setHasFixedSize(true)
            binding.rvMovies.adapter = academyAdapter
        }

    }

    private fun observeViewModelRequest() {
        // Update the list when the data changes
        viewModel.getFavMovies("movie").observe(this, Observer {data ->
            binding.progressBar.visibility = View.GONE
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