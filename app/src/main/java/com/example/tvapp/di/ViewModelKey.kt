package com.example.tvapp.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)
