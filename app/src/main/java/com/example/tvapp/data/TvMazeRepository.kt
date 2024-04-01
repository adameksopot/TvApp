package com.example.tvapp.data

import com.example.tvapp.domain.TvMazeRepository
import com.example.tvapp.domain.model.TvShow
import javax.inject.Inject

class TvMazeRepositoryImpl @Inject constructor(
    private val api: TvMazeApi,
    private val mapper: TvShowMapper,
) : TvMazeRepository {

    override suspend fun getApiResponse(query: String): List<TvShow> {
        val response = api.searchMovies(query)
        return response.map { mapper.map(it) }
    }
}
