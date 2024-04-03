package com.example.tvapp.data

import com.example.tvapp.domain.TvMazeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(repository: TvMazeRepositoryImpl): TvMazeRepository

}