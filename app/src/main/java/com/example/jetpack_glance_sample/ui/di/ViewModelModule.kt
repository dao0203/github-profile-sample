package com.example.jetpack_glance_sample.ui.di

import com.example.jetpack_glance_sample.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}
