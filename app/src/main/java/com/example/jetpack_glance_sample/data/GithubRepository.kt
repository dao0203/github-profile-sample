package com.example.jetpack_glance_sample.data

import com.example.jetpack_glance_sample.model.Contribution

interface GithubRepository {
    suspend fun getContribution(username: String): Contribution
}
