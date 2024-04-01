package com.example.tvapp.data
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideTvMazeApi(): TvMazeApi = Retrofit.Builder()
        .baseUrl(TvMazeApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TvMazeApi::class.java)
}