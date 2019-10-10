package com.dedi.myapplication.feature.movie


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dedi.myapplication.R
import kotlinx.android.synthetic.main.fragment_movie.*
import org.koin.android.ext.android.inject



class MovieFragment : Fragment() {
    val TAG ="MovieFragment"
    private var rvCourse: RecyclerView? = null
    private var academyAdapter: MoviesAdapter? = null
    private val viewModel: MoviesViewModel by inject()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = "Movies"
        if (activity != null) {
            progressBar.visibility =View.VISIBLE
            observeViewModelRequest()
            academyAdapter = MoviesAdapter(activity!!)

            rvCourse?.layoutManager = LinearLayoutManager(context)
            rvCourse?.setHasFixedSize(true)
            rvCourse?.adapter = academyAdapter
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

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCourse = view.findViewById<View>(R.id.rv_movies) as RecyclerView?
    }


}
