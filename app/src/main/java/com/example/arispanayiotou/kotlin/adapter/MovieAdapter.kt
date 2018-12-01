package com.example.arispanayiotou.kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.arispanayiotou.kotlin.R
import com.example.arispanayiotou.kotlin.models.MovieModel
import com.example.arispanayiotou.kotlin.utilities.loadImageViewWithGlide
import kotlinx.android.synthetic.main.grid_cell.view.*

/**
 * Created by arispanayiotou on 29/11/2018
 */
class MovieAdapter(val movieObject: MutableList<MovieModel>) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_cell, parent, false)

        return MovieHolder(v)
    }

    override fun getItemCount(): Int {
        return movieObject.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movieObject)
    }


    class MovieHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(movieObject: MutableList<MovieModel>) {

            itemView.moviePoster.loadImageViewWithGlide(movieObject[adapterPosition].multimedia?.src!!)
            itemView.movieTitle.text = movieObject[adapterPosition].displayTitle
            itemView.moviePlot.text = movieObject[0].summaryShort
        }

    }


}