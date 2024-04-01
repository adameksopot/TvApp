package com.example.tvapp.domain

import com.example.tvapp.domain.model.TvShow


interface TvMazeRepository {
    suspend fun getApiResponse(query: String): List<TvShow>
}