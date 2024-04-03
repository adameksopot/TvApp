package com.example.tvapp.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvapp.domain.TvMazeRepository
import com.example.tvapp.domain.model.TvShow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val api: TvMazeRepository,
) : ViewModel() {

    private val _moviesStateFlow = MutableStateFlow<List<TvShow>>(value = emptyList())
    val moviesStateFlow = _moviesStateFlow.asStateFlow()

    fun searchMovies(query: String) {
        viewModelScope.launch {
            val response = api.searchForShows(query)
            _moviesStateFlow.value = response
        }
    }
}
