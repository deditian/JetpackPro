package com.dedi.myapplication.movie


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dedi.myapplication.R
import com.dedi.myapplication.adapter.MoviesAdapter
import com.dedi.myapplication.data.MovieCatalogue
import com.dedi.myapplication.repository.MovieRepository
import com.dedi.myapplication.utils.DataDummy

class MovieFragment : Fragment() {

    private var rvCourse: RecyclerView? = null
    private var academyAdapter: MoviesAdapter? = null
    private var viewModel: MoviesViewModel? = null
    private var modelList: MutableLiveData<ArrayList<MovieCatalogue>>? = null


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
            val factory = MoviesViewModel.Factory(activity!!.application, MovieRepository())
            //end

            viewModel = ViewModelProviders.of(this, factory).get(MoviesViewModel::class.java)
            modelList = viewModel?.getMovies()

            academyAdapter = MoviesAdapter(activity!!)
            academyAdapter?.setListMovies(DataDummy.generateMovies())
            Log.i("isinya", "apa tuh : " + DataDummy.generateMovies())
            rvCourse?.layoutManager = LinearLayoutManager(context)
            rvCourse?.setHasFixedSize(true)
            rvCourse?.adapter = academyAdapter
        }
    }


    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCourse = view.findViewById<View>(R.id.rv_movies) as RecyclerView?
    }


}
