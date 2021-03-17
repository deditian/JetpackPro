package com.dedi.movies.feature.favorite.FavoriteMovie

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
import kotlinx.android.synthetic.main.fav_movie_fragment.*
import org.koin.android.ext.android.inject

class FavoriteMovieFragment : Fragment() {
    val TAG ="FavoriteMovieFragment"
    private var rvCourse: RecyclerView? = null
    private var academyAdapter: FavoriteMovieAdapter? = null
    val viewModel:FavoriteMovieViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fav_movie_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {

            fav_progressBar.visibility =View.VISIBLE
            observeViewModelRequest()

            academyAdapter = FavoriteMovieAdapter(activity!!)

            rvCourse?.layoutManager = LinearLayoutManager(context)
            rvCourse?.setHasFixedSize(true)
            rvCourse?.adapter = academyAdapter
        }

    }

    private fun observeViewModelRequest() {
        // Update the list when the data changes
        viewModel.getFavMovies("movie").observe(this, Observer {data ->
            fav_progressBar.visibility =View.GONE
            if (data != null){
                academyAdapter?.submitList(data)
                academyAdapter?.notifyDataSetChanged()
            }

        })
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCourse = view.findViewById<View>(R.id.rv_fav_movies) as RecyclerView?
    }


}