package com.dedi.movies.feature.tvshow


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
import kotlinx.android.synthetic.main.fragment_tv_show.*
import kotlinx.android.synthetic.main.fragment_tv_show.view.*
import org.koin.android.ext.android.inject


class TvShowFragment : Fragment() {

    private val viewModel: TvShowViewModel by inject()
    private var academyAdapter: TvShowAdapter? = null

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
        activity?.title = "Tv Shows"
        if (activity != null) {
            //untuk handle jika repository lebih dari 1

            observeViewModelRequest(viewModel)
            academyAdapter = TvShowAdapter()

            binding.rvTvShow.layoutManager = GridLayoutManager(context,2)
            binding.rvTvShow.setHasFixedSize(true)
            binding.rvTvShow.adapter = academyAdapter
        }
    }

    private fun observeViewModelRequest(viewModel: TvShowViewModel) {
        // Update the list when the data changes
        viewModel.getTvShow().observe(this, Observer {data ->
            binding.progressBar.visibility = View.GONE
            if (data != null){
                academyAdapter?.setListTvShow(data.results)
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
