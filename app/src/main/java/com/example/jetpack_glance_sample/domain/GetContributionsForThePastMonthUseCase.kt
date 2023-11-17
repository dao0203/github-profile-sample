package com.example.jetpack_glance_sample.domain

import com.example.jetpack_glance_sample.data.GithubRepository
import com.example.jetpack_glance_sample.model.Contribution
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.datetime.Clock
import kotlin.time.Duration.Companion.days

class GetContributionsForThePastMonthUseCase(
    private val githubRepository: GithubRepository
) {

    companion object {
        private const val TAG = "GetContributionsForThePastMonthUseCase"
        private const val BETWEEN_DAYS = 31
    }

    operator fun invoke(username: String): Flow<List<Contribution>> = flow {
        val today = Clock.System.now()
        val from = today.minus(BETWEEN_DAYS.days)

        githubRepository.getContributions(
            username = username,
            from = from.toString(),
            to = today.toString()
        )
            .catch { throw it }
            .collect(::emit)

    }
}
