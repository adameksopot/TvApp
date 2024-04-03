package com.example.tvapp.data

import com.example.tvapp.data.model.TvMazeResponse
import com.example.tvapp.data.model.TvMazeShowResponse
import com.example.tvapp.domain.model.TvMazeImageUrls
import com.example.tvapp.domain.model.TvMazeSchedule
import com.example.tvapp.domain.model.TvShow
import java.time.LocalDate
import javax.inject.Inject

class TvShowMapper @Inject constructor() {
    fun map(tvMazeShowResponse: TvMazeShowResponse): TvShow {
        val tvMazeResponse = tvMazeShowResponse.show
        return TvShow(
            id = tvMazeResponse.id,
            name = tvMazeResponse.name,
            genres = tvMazeResponse.genres,
            summary = tvMazeResponse.summary,
            schedule = TvMazeSchedule(
                time = tvMazeResponse.schedule?.time,
                days = tvMazeResponse.schedule?.days
            ),
            imageUrls = TvMazeImageUrls(
                medium = tvMazeResponse.imageUrls?.medium,
                original = tvMazeResponse.imageUrls?.original
            ),
            countryName = tvMazeResponse.countryName?.countryName?.name,
            releaseDate = tvMazeResponse.releaseDate?.let {
                LocalDate.parse(it)
            }
        )
    }

    fun mapSingleShow(tvMazeResponse: TvMazeResponse): TvShow =
        TvShow(
            id = tvMazeResponse.id,
            name = tvMazeResponse.name,
            genres = tvMazeResponse.genres,
            summary = tvMazeResponse.summary,
            schedule = TvMazeSchedule(
                time = tvMazeResponse.schedule?.time,
                days = tvMazeResponse.schedule?.days
            ),
            imageUrls = TvMazeImageUrls(
                medium = tvMazeResponse.imageUrls?.medium,
                original = tvMazeResponse.imageUrls?.original
            ),
            countryName = tvMazeResponse.countryName?.countryName?.name,
            releaseDate = tvMazeResponse.releaseDate?.let {
                LocalDate.parse(it)
            }
        )
}