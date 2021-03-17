package com.dedi.movies.feature.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.dedi.movies.R
import com.dedi.movies.data.DetailModel

import com.dedi.movies.data.entity.Movie
import com.dedi.movies.detail.DetailActivity
import com.dedi.movies.utils.imageLoad
import kotlinx.android.synthetic.main.item_content.view.*

class MoviesAdapter(activity: FragmentActivity) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private val mCourses = ArrayList<Movie>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false))
    }

    override fun getItemCount(): Int {
        return mCourses.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(mCourses[position])
    }

    fun setListMovies(listCourses: List<Movie>) {
        if (listCourses == null) return
        this.mCourses.clear()
        this.mCourses.addAll(listCourses)
    }

    inner class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(results: Movie) = itemView.run {
            txt_title.text = results.original_title
            img_poster.imageLoad(results.poster_path)
            cv_item_course.setOnClickListener {
                val mIntent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("list_data",
                        DetailModel(results.id,results.original_title,results.poster_path,results.overview,"movie"))
                }
                context.startActivity(mIntent)
            }
        }
    }

}

