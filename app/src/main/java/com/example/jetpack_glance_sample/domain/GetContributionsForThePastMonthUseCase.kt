package com.example.jetpack_glance_sample.domain

import com.example.jetpack_glance_sample.data.GithubRepository
import com.example.jetpack_glance_sample.model.Contribution
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class GetContributionsForThePastMonthUseCase(
    private val githubRepository: GithubRepository
) {
    operator fun invoke(username: String): Flow<List<Contribution>> = flow {
        val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val from = today.month.minus(1)

        githubRepository.getContributions(
            username = username,
            from = from.toString(),
            to = today.toString()
        )
    }
}
