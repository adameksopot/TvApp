package com.example.tvapp.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvapp.domain.TvMazeRepository
import com.example.tvapp.domain.model.TvShow
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


@HiltViewModel(assistedFactory = DetailsViewModel.Factory::class)
class DetailsViewModel @AssistedInject constructor(
    @Assisted val movie: String,
    private val api: TvMazeRepository,
) : ViewModel() {

    private val _moviesFlow = MutableSharedFlow<TvShow?>()
    val movieSharedFlow = _moviesFlow.asSharedFlow()

    @AssistedFactory
    interface Factory {
        fun create(runtimeArg: String): DetailsViewModel
    }

    init {
        viewModelScope.launch {
            val response = api.searchSingleShow(movie)
            _moviesFlow.emit(response)
        }
    }
}
