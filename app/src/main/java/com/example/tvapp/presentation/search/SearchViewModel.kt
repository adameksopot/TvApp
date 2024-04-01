package com.example.tvapp.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvapp.domain.TvMazeRepository
import com.example.tvapp.domain.model.TvShow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val api: TvMazeRepository,
) : ViewModel() {

    private val _moviesStateFlow = MutableStateFlow<List<TvShow>>(value = emptyList())
    val moviesStateFlow = _moviesStateFlow.asStateFlow()

    fun searchMovies(query: String) {
        viewModelScope.launch {
            val response = api.getApiResponse(query)
            _moviesStateFlow.value = response
        }
    }
}
