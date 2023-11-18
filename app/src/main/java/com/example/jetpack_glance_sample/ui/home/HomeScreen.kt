package com.example.jetpack_glance_sample.ui.home

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = getViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    HomeContent(uiState.value)
}
