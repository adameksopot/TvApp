package com.example.tvapp.presentation.search

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.tvapp.R
import com.example.tvapp.domain.model.TvShow
import com.example.tvapp.utils.showIfAtLeastOneNotEmpty
import com.example.tvapp.utils.showIfNotEmpty


class TvMazeShowResponseAdapter(private val onMovieClick: (TvShow) -> Unit) :
    RecyclerView.Adapter<TvMazeShowResponseViewHolder>() {
    private var movies = mutableListOf<TvShow>()

    fun setMoviesList(movies: List<TvShow>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TvMazeShowResponseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tvmaze, parent, false)
        return TvMazeShowResponseViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: TvMazeShowResponseViewHolder,
        position: Int,
    ) {
        val movie = movies[position]
        holder.movieTitle.text = movie.name

        Glide.with(holder.itemView.context).load(movie.imageUrls?.original)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.moviePoster)

        holder.itemView.setOnClickListener {
            onMovieClick(movie)
        }
    }

    override fun getItemCount(): Int = movies.size
}
const val SPACER: String = " "
