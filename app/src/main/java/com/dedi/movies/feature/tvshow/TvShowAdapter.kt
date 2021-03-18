package com.dedi.movies.feature.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dedi.movies.data.DetailModel
import com.dedi.movies.data.entity.TvShow
import com.dedi.movies.databinding.ItemContentBinding

import com.dedi.movies.detail.DetailActivity
import com.dedi.movies.utils.imageLoad

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private val mTvShowAdapter = ArrayList<TvShow>()
    var poster = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val  binding = ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mTvShowAdapter.size
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(mTvShowAdapter[position])
    }

    fun setListTvShow(listCourses: List<TvShow>?) {
        if (listCourses == null) return
        this.mTvShowAdapter.clear()
        this.mTvShowAdapter.addAll(listCourses)
    }


    inner class TvShowViewHolder(private val itemBinding: ItemContentBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(results: TvShow?) = itemView.run {
            if (results?.poster_path == null){
                poster = results?.backdrop_path.toString()
                itemBinding.imgPoster.imageLoad(poster)
            } else {
                poster = results.poster_path
                itemBinding.imgPoster.imageLoad(poster)
            }

            itemBinding.txtTitle.text = results?.original_name
            setOnClickListener {
                val mIntent = Intent(context, DetailActivity::class.java).apply {
                    if (results != null) {
                        putExtra("list_data",
                            DetailModel(results.id,results.original_name,poster,results.overview,"tv_show")
                        )
                    }
                }
                context.startActivity(mIntent)
            }
        }
    }

}