package com.example.jetpack_glance_sample.domain.di

import com.example.jetpack_glance_sample.domain.GetContributionsForThePastMonthUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetContributionsForThePastMonthUseCase(get()) }
}
