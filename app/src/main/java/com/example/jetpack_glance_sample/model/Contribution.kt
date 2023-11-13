package com.example.jetpack_glance_sample.model

import kotlinx.datetime.LocalDateTime

data class Contribution(
    val date: LocalDateTime,
    val count: Int,
)
