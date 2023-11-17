package com.example.jetpack_glance_sample.model

import kotlinx.datetime.LocalDate

data class Contribution(
    val date: LocalDate,
    val count: Int,
)
