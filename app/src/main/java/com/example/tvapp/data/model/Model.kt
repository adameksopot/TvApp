package com.example.tvapp.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.time.LocalDate

data class TvMazeResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("genres") val genres: List<String>?,
    @SerializedName("summary") val summary: String,
    @SerializedName("schedule") val schedule: TvMazeResponseSchedule?,
    @SerializedName("image") val imageUrls: TvMazeResponseImageUrls?,
    @SerializedName("network") val countryName: TvMazeCountryResponse?,
    @SerializedName("premiered") val releaseDate: String?,
    )

data class TvMazeResponseImageUrls(
    @SerializedName("medium") val medium: String?,
    @SerializedName("original") val original: String?,
)

data class TvMazeResponseSchedule(
    @SerializedName("time") val time: String?,
    @SerializedName("days") val days: List<String>?,
)

data class TvMazeCountryResponse(
    @SerializedName("country") val countryName: TvMazeSingleCountryResponse?,
)

data class TvMazeShowResponse(
    @SerializedName("show") val show: TvMazeResponse,
)

data class TvMazeSingleCountryResponse(
    @SerializedName("name") val name: String?,
)
