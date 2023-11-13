package com.example.jetpack_glance_sample.data

import com.example.jetpack_glance_sample.model.Contribution
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class GithubRepositoryImpl(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : GithubRepository {
    override suspend fun getContribution(username: String): Contribution {
        TODO("Not yet implemented")
    }
}
