package com.example.tvapp

import android.app.Application
import com.example.tvapp.di.AppComponent
import com.example.tvapp.di.DaggerAppComponent


class App : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
      component = DaggerAppComponent.create()
    }

 fun getAppComponent(): AppComponent = component
}
