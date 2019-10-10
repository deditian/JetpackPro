package com.dedi.myapplication.feature.tvshow


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
import kotlinx.android.synthetic.main.fragment_tv_show.*
import org.koin.android.ext.android.inject


class TvShowFragment : Fragment() {

    private var rvCourse: RecyclerView? = null
    private val viewModel: TvShowViewModel by inject()
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
            progress_bar?.visibility =View.GONE
            if (data != null){
                academyAdapter?.setListTvShow(data.results)
                academyAdapter?.notifyDataSetChanged()
            }else{

            }

        })
    }


    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCourse = view.findViewById<View>(R.id.rv_tv_show) as RecyclerView?
    }


}
