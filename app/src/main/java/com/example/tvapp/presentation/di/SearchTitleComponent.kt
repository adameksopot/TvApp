package com.example.tvapp.presentation.di

import com.example.tvapp.di.AppComponent
import com.example.tvapp.presentation.search.SearchTitleFragment
import dagger.Component
import javax.inject.Scope


@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class SearchTitleScope

@SearchTitleScope
@Component(dependencies = [AppComponent::class])
interface SearchTitleComponent {
    fun inject(fragment: SearchTitleFragment)
}
