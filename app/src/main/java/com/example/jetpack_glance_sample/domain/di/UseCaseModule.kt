package com.example.jetpack_glance_sample.domain.di

import com.example.jetpack_glance_sample.domain.GetContributionsForThePastTwoMonthsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetContributionsForThePastTwoMonthsUseCase(get()) }
}
