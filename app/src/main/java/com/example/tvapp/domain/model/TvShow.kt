package com.example.tvapp.domain.model

import java.io.Serializable
import java.time.LocalDate

data class TvShow(
    val id: Int,
    val name: String,
    val genres: List<String>?,
    val summary: String,
    val schedule: TvMazeSchedule?,
    val imageUrls: TvMazeImageUrls?,
    val countryName: String?,
    val releaseDate: LocalDate?
) : Serializable

data class TvMazeImageUrls(
    val medium: String?,
    val original: String?
) : Serializable

data class TvMazeSchedule(
    val time: String?,
    val days: List<String>?
) : Serializable
