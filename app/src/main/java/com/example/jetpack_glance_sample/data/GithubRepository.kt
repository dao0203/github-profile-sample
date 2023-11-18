package com.example.jetpack_glance_sample.data

import com.example.jetpack_glance_sample.model.Contribution
import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    suspend fun getContributions(
        username: String,
        from: String,
        to: String
    ): Flow<List<Contribution>>
}
