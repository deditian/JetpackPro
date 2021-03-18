package com.dedi.movies.feature.favorite.FavoriteMovie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dedi.movies.data.DetailModel
import com.dedi.movies.data.FavModel
import com.dedi.movies.databinding.ItemContentBinding
import com.dedi.movies.detail.DetailActivity
import com.dedi.movies.utils.imageLoad


class FavoriteMovieAdapter : PagedListAdapter<FavModel, FavoriteMovieAdapter.FavMoviesViewHolder>(DIFF_CALLBACK) {

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
        val binding = ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavMoviesViewHolder(binding)
    }


    override fun onBindViewHolder(holder: FavMoviesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class FavMoviesViewHolder(private val itemBinding: ItemContentBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(results: FavModel?) = itemView.run {
            itemBinding.txtTitle.text = results?.titlefav
            itemBinding.imgPoster.imageLoad(results?.imagefav!!)
            setOnClickListener {
                val mIntent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("list_data",
                        DetailModel(results.idfav,results.titlefav,results.imagefav,results.overviewfav,"movie")
                    )
                }
                context.startActivity(mIntent)
            }
        }
    }

}