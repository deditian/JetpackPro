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
import com.dedi.movies.databinding.FragmentMovieBinding
import com.dedi.movies.databinding.ItemContentBinding
import com.dedi.movies.detail.DetailActivity
import com.dedi.movies.utils.imageLoad
import kotlinx.android.synthetic.main.item_content.view.*

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private val mMovies = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val  binding = ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mMovies.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(mMovies[position])
    }

    fun setListMovies(listCourses: List<Movie>?) {
        if (listCourses == null) return
        this.mMovies.clear()
        this.mMovies.addAll(listCourses)
    }

    inner class MoviesViewHolder(private val itemBinding: ItemContentBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(results: Movie) = itemView.run {
            itemBinding.txtTitle.text = results.original_title
            itemBinding.imgPoster.imageLoad(results.poster_path)
            itemBinding.cvItemCourse.setOnClickListener {
                val mIntent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("list_data",
                        DetailModel(results.id,results.original_title,results.poster_path,results.overview,"movie"))
                }
                context.startActivity(mIntent)
            }
        }
    }

}

