package com.example.jetpack_glance_sample.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.layout.size
import com.example.jetpack_glance_sample.domain.GetContributionsForThePastTwoMonthsUseCase
import com.example.jetpack_glance_sample.model.Contribution
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GithubContributionsWidget : GlanceAppWidget(), KoinComponent {

    private val getContributionsForThePastTwoMonthsUseCase:
            GetContributionsForThePastTwoMonthsUseCase by inject()

    companion object {
        private const val TAG = "GithubContributionsWidget"
    }

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
        val weeks = contributions.chunked(7)
        Box(
            modifier = GlanceModifier.fillMaxSize().background(Color(0xFFFFFFFF))
        ) {
            Row(
                GlanceModifier.padding(8.dp)
            ) {
                weeks.forEach { weekContributions ->
                    Column(GlanceModifier.padding(2.dp)) {
                        weekContributions.forEach { dayContribution ->
                            val backgroundColor = when (dayContribution.count) {
                                0 -> 0x10000000
                                in 1..10 -> 0x3300FF00
                                in 11..20 -> 0x6600FF00
                                else -> 0x9900FF00
                            }
                            Spacer(
                                GlanceModifier
                                    .size(16.dp)
                                    .background(Color(backgroundColor))
                                    .cornerRadius(4.dp)
                            )
                        }
                    }
                }
//                    val contribution = contributions[item]
//
//                    val backgroundColor = when (contribution.count) {
//                        0 -> 0x10000000
//                        in 1..10 -> 0x3300FF00
//                        in 11..20 -> 0x6600FF00
//                        else -> 0x9900FF00
//                    }
//
//                    Box(
//                        modifier = GlanceModifier
//                            .fillMaxSize()
//                            .background(Color(backgroundColor))
//                            .cornerRadius(4.dp)
//                    ) {
//                        Text(text = " ")
//                    }
            }
        }
    }
}
