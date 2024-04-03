package com.example.tvapp.domain

import com.example.tvapp.domain.model.TvShow


interface TvMazeRepository {
    suspend fun searchForShows(query: String): List<TvShow>
    suspend fun searchSingleShow(query: String): TvShow?
}