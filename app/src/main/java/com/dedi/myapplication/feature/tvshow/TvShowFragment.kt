package com.dedi.myapplication.feature.tvshow


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dedi.myapplication.R
import com.dedi.myapplication.ViewModelFactory
import com.dedi.myapplication.adapter.TvShowAdapter
import com.dedi.myapplication.repository.ApiRepository


class TvShowFragment : Fragment() {

    private var rvCourse: RecyclerView? = null
    private var progressBar: ProgressBar? = null
    lateinit var viewModel: TvShowViewModel
    private var academyAdapter: TvShowAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = "Tv Shows"
        if (activity != null) {
            //untuk handle jika repository lebih dari 1
            viewModel = obtainViewModel(activity as FragmentActivity)

            observeViewModelRequest(viewModel)
            academyAdapter = TvShowAdapter(activity!!)

            rvCourse?.layoutManager = LinearLayoutManager(context)
            rvCourse?.setHasFixedSize(true)
            rvCourse?.adapter = academyAdapter
        }
    }

    private fun observeViewModelRequest(viewModel: TvShowViewModel) {
        // Update the list when the data changes
        viewModel.getTvShow().observe(this, Observer {data ->
//            progressBar.visibility =View.GONE
            if (data != null){
                academyAdapter?.setListTvShow(data.results)
                academyAdapter?.notifyDataSetChanged()
            }

        })
    }


    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCourse = view.findViewById<View>(R.id.rv_tv_show) as RecyclerView?
        progressBar = view.findViewById<View>(R.id.progress_bar) as ProgressBar?
    }

    private fun obtainViewModel(activity: FragmentActivity): TvShowViewModel {
        // Use a Factory to inject dependencies into the ViewModel
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(TvShowViewModel::class.java)
    }

}
