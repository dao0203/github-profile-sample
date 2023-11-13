package com.example.jetpack_glance_sample.model

import kotlinx.datetime.Instant

data class Contribution(
    val date: Instant,
    val count: Int,
)
