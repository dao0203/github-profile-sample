package com.example.jetpack_glance_sample.domain.di

import com.example.jetpack_glance_sample.domain.GetContributionsForThePastThreeMonthUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetContributionsForThePastThreeMonthUseCase(get()) }
}
