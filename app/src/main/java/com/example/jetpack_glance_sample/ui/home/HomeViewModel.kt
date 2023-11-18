package com.example.jetpack_glance_sample.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack_glance_sample.domain.GetContributionsForThePastThreeMonthUseCase
import com.example.jetpack_glance_sample.model.Contribution
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    getContributionsForThePastMonthUseCase: GetContributionsForThePastThreeMonthUseCase
) : ViewModel() {

    val uiState: StateFlow<HomeUiState> = getContributionsForThePastMonthUseCase("dao0203").map {
        HomeUiState(isLoading = false, contributions = it)
    }
        .catch { emit(HomeUiState(isLoading = false, error = it)) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HomeUiState()
        )

    data class HomeUiState(
        val isLoading: Boolean = true,
        val contributions: List<Contribution> = emptyList(),
        val error: Throwable? = null
    )
}
