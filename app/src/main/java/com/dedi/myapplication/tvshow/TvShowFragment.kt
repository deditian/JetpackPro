package com.dedi.myapplication.tvshow


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.Nullable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.dedi.myapplication.R
import com.dedi.myapplication.adapter.MoviesAdapter
import com.dedi.myapplication.adapter.TvShowAdapter
import com.dedi.myapplication.data.MovieCatalogue
import com.dedi.myapplication.movie.MoviesViewModel
import com.dedi.myapplication.utils.DataDummy

class TvShowFragment : Fragment() {

    private var rvCourse: RecyclerView? = null
    private var progressBar: ProgressBar? = null
    private var academyAdapter: TvShowAdapter? = null

    private var viewModel: TvShowViewModel? = null
    private var modelList: MutableLiveData<ArrayList<MovieCatalogue>>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            //untuk handle jika repository lebih dari 1
            val factory = TvShowViewModel.Factory()
            //end
            viewModel = ViewModelProviders.of(this,factory).get(TvShowViewModel::class.java)
            modelList = viewModel?.getTvShow()

            academyAdapter = TvShowAdapter(activity!!)
            academyAdapter?.setListTvShow(DataDummy.generateTvShows())
            Log.i("isinya", "apa tuh : " + DataDummy.generateTvShows())
            rvCourse?.layoutManager = LinearLayoutManager(context)
            rvCourse?.setHasFixedSize(true)
            rvCourse?.adapter = academyAdapter
        }
    }


    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCourse = view.findViewById<View>(R.id.rv_tv_show) as RecyclerView?
        progressBar = view.findViewById<View>(R.id.progress_bar) as ProgressBar?
    }


}
