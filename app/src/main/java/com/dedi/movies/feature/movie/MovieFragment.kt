package com.dedi.movies.feature.movie


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dedi.movies.R
import com.dedi.movies.databinding.FragmentMovieBinding
import kotlinx.android.synthetic.main.fragment_movie.*
import org.koin.android.ext.android.inject



class MovieFragment : Fragment() {
    val TAG ="MovieFragment"
    private var academyAdapter: MoviesAdapter? = null
    private val viewModel: MoviesViewModel by inject()

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
        activity?.title = "Movies"
        if (activity != null) {
            progressBar.visibility =View.VISIBLE
            observeViewModelRequest()
            academyAdapter = MoviesAdapter()

            binding.rvMovies.layoutManager = LinearLayoutManager(context)
            binding.rvMovies.setHasFixedSize(true)
            binding.rvMovies.adapter = academyAdapter
        }
    }

    private fun observeViewModelRequest() {
        // Update the list when the data changes
        viewModel.getMovies().observe(this, Observer {data ->
            progressBar.visibility =View.GONE
            if (data != null){
                academyAdapter?.setListMovies(data.results)
                academyAdapter?.notifyDataSetChanged()
            }else{

            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
