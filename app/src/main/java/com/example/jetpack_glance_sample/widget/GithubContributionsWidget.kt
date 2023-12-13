package com.example.jetpack_glance_sample.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.appWidgetBackground
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.layout.size
import com.example.jetpack_glance_sample.domain.GetContributionsForThePastTwoMonthsUseCase
import com.example.jetpack_glance_sample.model.Contribution
import com.example.jetpack_glance_sample.ui.theme.getGithubContributionColor
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GithubContributionsWidget : GlanceAppWidget(), KoinComponent {

    private val getContributionsForThePastTwoMonthsUseCase:
        GetContributionsForThePastTwoMonthsUseCase by inject()

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            val contributions by getContributionsForThePastTwoMonthsUseCase("dao0203")
                .collectAsState(listOf())

            JetpackGlanceSampleTheme {
                GithubContributionsWidgetContent(contributions = contributions)
            }
        }
    }

    @Composable
    private fun GithubContributionsWidgetContent(
        contributions: List<Contribution>
    ) {
        // 1つの要素が1週間分のContributionを表す
        // weeks = [[Contribution, Contribution, ...], [Contribution, Contribution, ...], ...]
        val weeks = remember(contributions) { contributions.chunked(7) }
        GlanceTheme {
            Box(
                modifier = GlanceModifier
                    .fillMaxSize()
                    .appWidgetBackground()
                    .background(GlanceTheme.colors.background),
                contentAlignment = Alignment.Center
            ) {
                Row {
                    weeks.forEach { weekContributions ->
                        Column(GlanceModifier.padding(1.dp)) {
                            weekContributions.forEach { contribution ->
                                Spacer(
                                    modifier = GlanceModifier
                                        .size(12.dp)
                                        .padding(1.dp)
                                        .cornerRadius(4.dp)
                                        .background(getGithubContributionColor(contribution.count))
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
