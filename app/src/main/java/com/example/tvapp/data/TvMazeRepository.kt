package com.example.tvapp.data

import com.example.tvapp.domain.TvMazeRepository
import com.example.tvapp.domain.model.TvShow
import javax.inject.Inject

class TvMazeRepositoryImpl @Inject constructor(
    private val api: TvMazeApi,
    private val mapper: TvShowMapper,
) : TvMazeRepository {

    override suspend fun searchForShows(query: String): List<TvShow> {
        return try {
            api.searchMovies(query).map { mapper.map(it) }
        } catch (e: Throwable) {
            emptyList()
        }
    }

    override suspend fun searchSingleShow(query: String): TvShow? {
        return try {
            mapper.mapSingleShow(api.searchMovie(query))
        } catch (e: Throwable) {
            null
        }
    }
}
