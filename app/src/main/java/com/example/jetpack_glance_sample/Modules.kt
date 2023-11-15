package com.example.jetpack_glance_sample

import com.apollographql.apollo3.ApolloClient
import com.example.jetpack_glance_sample.data.GithubRepository
import com.example.jetpack_glance_sample.data.GithubRepositoryImpl
import io.github.cdimascio.dotenv.dotenv
import org.koin.dsl.module

val appModule = module {
    single<GithubRepository> { GithubRepositoryImpl(get(), get()) }
    // apolloClientをDI
    single<ApolloClient> {
        ApolloClient.Builder()
            .serverUrl("https://api.github.com/graphql")
            .addHttpHeader("Authorization", "bearer ${dotenv()["GITHUB_TOKEN"]}")
            .build()
    }
}
