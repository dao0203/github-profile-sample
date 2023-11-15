package com.example.jetpack_glance_sample.data

import com.apollographql.apollo3.ApolloClient
import com.example.GetContributionsQuery
import com.example.jetpack_glance_sample.model.Contribution
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class GithubRepositoryImpl(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val apolloClient: ApolloClient
) : GithubRepository {
    override suspend fun getContributions(username: String): List<Contribution> {
        return withContext(defaultDispatcher) {
            //今日の日付と1ヶ月前の日付を取得
            val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
            val from = today.month.minus(1)
            val response = apolloClient.query(
                GetContributionsQuery(
                    username = username,
                    from = from.toString(),
                    to = today.toString()
                )
            ).execute()
            val contributions =
                response.data?.user?.contributionsCollection?.contributionCalendar?.weeks?.flatMap { it.contributionDays }
                    ?.map {
                        Contribution(
                            date = Instant.parse(it.date.toString())
                                .toLocalDateTime(TimeZone.currentSystemDefault()),
                            count = it.contributionCount
                        )
                    }

            contributions ?: emptyList()

        }
    }
}

