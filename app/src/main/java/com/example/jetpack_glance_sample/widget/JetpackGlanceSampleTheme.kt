package com.example.jetpack_glance_sample.widget

import androidx.compose.runtime.Composable
import androidx.glance.GlanceTheme

@Composable
fun JetpackGlanceSampleTheme(content: @Composable () -> Unit) {
    GlanceTheme {
        content()
    }
}
