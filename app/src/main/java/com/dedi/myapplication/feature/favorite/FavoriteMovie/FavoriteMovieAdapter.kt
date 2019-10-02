package com.dedi.myapplication.feature.favorite.FavoriteMovie

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dedi.myapplication.R
import com.dedi.myapplication.data.DetailModel
import com.dedi.myapplication.data.FavModel
import com.dedi.myapplication.data.entity.Movie
import com.dedi.myapplication.detail.DetailActivity
import com.dedi.myapplication.utils.imageLoad
import kotlinx.android.synthetic.main.item_content.view.*


class FavoriteMovieAdapter(activity: FragmentActivity) : PagedListAdapter<FavModel, FavoriteMovieAdapter.FavMoviesViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FavModel>() {
            // Concert details may have changed if reloaded from the database,
            // but ID is fixed.
            override fun areItemsTheSame(oldFav: FavModel, newFav: FavModel): Boolean {
                return oldFav.titlefav == newFav.titlefav
            }
            override fun areContentsTheSame(oldFav: FavModel, newFav: FavModel): Boolean {
                return oldFav == newFav
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavMoviesViewHolder {
        return FavMoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false))
    }


    override fun onBindViewHolder(holder: FavMoviesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class FavMoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(results: FavModel?) = itemView.run {
            txt_title.text = results?.titlefav
            img_poster.imageLoad(results?.imagefav!!)
//            cv_item_course.setOnClickListener {
//                val mIntent = Intent(context, DetailActivity::class.java).apply {
//                    putExtra("movies",
//                        DetailModel(results.id,results.original_title,results.poster_path,results.overview)
//                    )
//                }
//                context.startActivity(mIntent)
//            }
        }
    }

}