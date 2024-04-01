package com.example.tvapp.di


import com.example.tvapp.data.DataModule
import com.example.tvapp.data.RepositoryModule
import dagger.Component

import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        DataModule::class,
        RepositoryModule::class,
    ]
)
interface AppComponent {

    val factory: ViewModelFactory
}
