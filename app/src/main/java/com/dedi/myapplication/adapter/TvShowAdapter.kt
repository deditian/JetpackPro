package com.dedi.myapplication.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.dedi.myapplication.R
import com.dedi.myapplication.data.DetailModel
import com.dedi.myapplication.data.entity.TvShow

import com.dedi.myapplication.detail.DetailActivity
import com.dedi.myapplication.utils.imageLoad
import kotlinx.android.synthetic.main.item_content.view.*

class TvShowAdapter(activity: FragmentActivity) : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private val mCourses = ArrayList<TvShow>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false))
    }

    override fun getItemCount(): Int {
        return mCourses.size
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(mCourses[position])
    }

    fun setListTvShow(listCourses: List<TvShow>) {
        if (listCourses == null) return
        this.mCourses.clear()
        this.mCourses.addAll(listCourses)
    }


    inner class TvShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(results: TvShow) = itemView.run {
            img_poster.imageLoad(results.poster_path)
            txt_title.text = results.original_name
            setOnClickListener {
                val mIntent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("movies",
                        DetailModel(results.id,results.original_name,results.poster_path,results.overview)
                    )
                }
                context.startActivity(mIntent)
            }
        }
    }

}