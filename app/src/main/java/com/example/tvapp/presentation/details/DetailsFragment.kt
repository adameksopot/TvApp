package com.example.tvapp.presentation.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.tvapp.R

class DetailsFragment : Fragment(R.layout.details_fragment) {

    private val args by navArgs<DetailsFragmentArgs>()
    private lateinit var image: AppCompatImageView
    private lateinit var title: TextView
    private lateinit var showPlaytime: TextView
    private lateinit var summary: TextView

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image = view.findViewById(R.id.MoviePosterCardView)
        title = view.findViewById(R.id.MovieTitleTextView)
        showPlaytime = view.findViewById(R.id.PlayTimeTextView)
        summary = view.findViewById(R.id.SummaryTextView)

        title.text = args.tvshow.name
        showPlaytime.text =
            "${args.tvshow.schedule?.time}  ${args.tvshow.schedule?.days?.joinToString()}"
        summary.text =
            args.tvshow.summary?.let {
                HtmlCompat.fromHtml(
                    it,
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            }
        Glide.with(this@DetailsFragment)
            .load(args.tvshow.imageUrls?.original)
            .onlyRetrieveFromCache(true)
            .into(image)
    }
}