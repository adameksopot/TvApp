package com.example.tvapp.presentation.details


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.tvapp.R
import com.example.tvapp.domain.model.TvShow
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.withCreationCallback
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.details_fragment) {

    private val args by navArgs<DetailsFragmentArgs>()

    private val viewModel: DetailsViewModel by viewModels<DetailsViewModel>(
        extrasProducer = {
            defaultViewModelCreationExtras.withCreationCallback<DetailsViewModel.Factory> { factory ->
                factory.create(runtimeArg = args.movieTitle)
            }
        }
    )

    private lateinit var posterImageView: AppCompatImageView
    private lateinit var movieLenTextView: TextView
    private lateinit var allowedUnderAgeTextView: TextView
    private lateinit var yearOfMadeTextView: TextView
    private lateinit var countryTextView: TextView
    private lateinit var summaryTextView: TextView
    private lateinit var icon: AppCompatImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        posterImageView = requireView().findViewById(R.id.MoviePosterDetailsImageView)
        icon = requireView().findViewById(R.id.ButtonPlay)
        movieLenTextView = requireView().findViewById(R.id.MovieLengthTextView)
        allowedUnderAgeTextView = requireView().findViewById(R.id.MovieAllowedUnderAgeOfTextView)
        yearOfMadeTextView = requireView().findViewById(R.id.YearOfMadeTextView)
        countryTextView = requireView().findViewById(R.id.CountryTextView)
        summaryTextView = requireView().findViewById(R.id.SummaryTextView)


        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.movieSharedFlow.collectLatest {
                    setupView(it)
                }
            }
        }
    }
    
    private fun setupView(movie: TvShow?) {
        movie?.let {
            Glide.with(this).load(movie.imageUrls?.original).into(posterImageView)
            this@DetailsFragment.activity?.title = it.name
            movieLenTextView.text = "1H 44m"
            allowedUnderAgeTextView.text = "16+"
            yearOfMadeTextView.text = it.releaseDate?.year.toString()
            countryTextView.text = it.countryName
            summaryTextView.text = HtmlCompat.fromHtml(
                it.summary, HtmlCompat.FROM_HTML_MODE_LEGACY
            )

            icon.setColorFilter(resources.getColor(R.color.offwhite));

        }
    }
}