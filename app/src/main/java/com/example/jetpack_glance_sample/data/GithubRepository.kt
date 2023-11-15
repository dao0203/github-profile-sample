package com.example.jetpack_glance_sample.data

import com.example.jetpack_glance_sample.model.Contribution

interface GithubRepository {
    suspend fun getContributions(
        username: String,
        from: String,
        to: String
    ): List<Contribution>
}
