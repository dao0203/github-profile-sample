package com.example.jetpack_glance_sample.data.di

import com.example.jetpack_glance_sample.data.GithubRepository
import com.example.jetpack_glance_sample.data.GithubRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<GithubRepository> { GithubRepositoryImpl(apolloClient = get()) }
}