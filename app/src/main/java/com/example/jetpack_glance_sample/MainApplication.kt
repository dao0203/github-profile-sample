package com.example.jetpack_glance_sample

import android.app.Application
import com.example.jetpack_glance_sample.data.di.networkModule
import com.example.jetpack_glance_sample.data.di.repositoryModule
import com.example.jetpack_glance_sample.domain.di.useCaseModule
import com.example.jetpack_glance_sample.ui.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(networkModule, repositoryModule, useCaseModule, viewModelModule)
        }
    }
}
