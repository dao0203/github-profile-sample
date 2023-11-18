package com.example.jetpack_glance_sample.data.di

import com.apollographql.apollo3.ApolloClient
import com.example.jetpack_glance_sample.BuildConfig
import org.koin.dsl.module

val networkModule = module {
    single {
        ApolloClient.Builder()
            .serverUrl("https://api.github.com/graphql")
            .addHttpHeader(
                "Authorization",
                "Bearer ${BuildConfig.GITHUB_ACCESS_TOKEN}"
            )
            .build()
    }
}
