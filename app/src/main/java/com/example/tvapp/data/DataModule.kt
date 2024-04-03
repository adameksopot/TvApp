package com.example.tvapp.data
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideTvMazeApi(): TvMazeApi = Retrofit.Builder()
        .baseUrl(TvMazeApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TvMazeApi::class.java)
}