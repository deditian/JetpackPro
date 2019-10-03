package com.dedi.myapplication.feature.favorite.FavoriteMovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dedi.myapplication.R
import com.dedi.myapplication.ViewModelFactory
import com.dedi.myapplication.feature.movie.MoviesViewModel
import com.dedi.myapplication.repository.ApiRepository
import kotlinx.android.synthetic.main.fragment_movie.*

class FavoriteMovieFragment : Fragment() {
    val TAG ="FavoriteMovieFragment"
    private var rvCourse: RecyclerView? = null
    private var academyAdapter: FavoriteMovieAdapter? = null
    lateinit var viewModel: FavoriteMovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            //untuk handle jika repository lebih dari 1
            viewModel = obtainViewModel(activity as FragmentActivity)
            //end
            progressBar.visibility =View.VISIBLE

            observeViewModelRequest(viewModel)
            academyAdapter = FavoriteMovieAdapter(activity!!)

            rvCourse?.layoutManager = LinearLayoutManager(context)
            rvCourse?.setHasFixedSize(true)
            rvCourse?.adapter = academyAdapter
        }

    }

    private fun observeViewModelRequest(viewModel: FavoriteMovieViewModel) {
        // Update the list when the data changes
        viewModel.getFav().observe(this, Observer {data ->
            progressBar.visibility =View.GONE
            if (data != null){
                academyAdapter?.submitList(data)
                academyAdapter?.notifyDataSetChanged()
            }

        })
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCourse = view.findViewById<View>(R.id.rv_movies) as RecyclerView?
    }

    private fun obtainViewModel(activity: FragmentActivity): FavoriteMovieViewModel {
        // Use a Factory to inject dependencies into the ViewModel
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(FavoriteMovieViewModel::class.java)
    }



}