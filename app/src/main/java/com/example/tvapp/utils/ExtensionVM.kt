package com.example.tvapp.utils

import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelStoreOwner
import com.example.tvapp.App

@MainThread
inline fun <reified VM : ViewModel> AppCompatActivity.daggerViewModels(): Lazy<VM> =
    ViewModelLazy(VM::class, { viewModelStore }, { App.component.factory })


@MainThread
inline fun <reified VM : ViewModel> Fragment.daggerViewModels(
    noinline ownerProducer: () -> ViewModelStoreOwner = { this }
) = createViewModelLazy(
    VM::class,
    { ownerProducer().viewModelStore },
    factoryProducer = { App.component.factory }
)
