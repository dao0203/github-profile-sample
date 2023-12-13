package com.example.jetpack_glance_sample.ui.theme

import androidx.compose.ui.graphics.Color

object GithubContributionColor {
    val zero = Color(0x10000000)
    val oneToTen = Color(0x3300FF00)
    val elevenToTwenty = Color(0x6600FF00)
    val twentyOneToThirty = Color(0x9900FF00)
    val moreThanThirty = Color(0xCC00FF00)
}

fun getGithubContributionColor(count: Int): Color {
    return when (count) {
        0 -> GithubContributionColor.zero
        in 1..10 -> GithubContributionColor.oneToTen
        in 11..20 -> GithubContributionColor.elevenToTwenty
        in 21..30 -> GithubContributionColor.twentyOneToThirty
        else -> GithubContributionColor.moreThanThirty
    }
}