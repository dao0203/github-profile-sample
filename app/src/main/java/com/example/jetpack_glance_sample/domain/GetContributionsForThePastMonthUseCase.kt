package com.example.jetpack_glance_sample.domain

import com.example.jetpack_glance_sample.data.GithubRepository
import com.example.jetpack_glance_sample.model.Contribution
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class GetContributionsForThePastMonthUseCase(
    private val githubRepository: GithubRepository
) {
    suspend operator fun invoke(username: String): List<Contribution> {
        val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val from = today.month.minus(1)
        return githubRepository.getContributions(
            username = username,
            from = from.toString(),
            to = today.toString()
        )
    }
}