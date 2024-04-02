package com.example.tvapp.presentation.search

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tvapp.R

class TvMazeShowResponseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val movieTitle: TextView = itemView.findViewById(R.id.MovieTitleTextView)
    val moviePoster: ImageView = itemView.findViewById(R.id.MoviePosterImageView)

}
