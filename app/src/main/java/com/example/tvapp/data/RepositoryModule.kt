package com.example.tvapp.data

import com.example.tvapp.domain.TvMazeRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(repository: TvMazeRepositoryImpl): TvMazeRepository

}