package com.example.jetpack_glance_sample.data.di

import com.apollographql.apollo3.ApolloClient
import org.koin.dsl.module

val networkModule = module {
    single {
        ApolloClient.Builder()
            .serverUrl("https://api.github.com/graphql")
            .addHttpHeader(
                "Authorization",
                "Bearer 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"
            )
            .build()
    }
}
