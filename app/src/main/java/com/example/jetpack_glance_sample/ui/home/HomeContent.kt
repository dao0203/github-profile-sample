package com.example.jetpack_glance_sample.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeContent(
    uiState: HomeViewModel.HomeUiState
) {

    when {
        uiState.isLoading -> {
            Text(text = "Loading...")
        }

        uiState.error != null -> {
            Text(text = uiState.error.message ?: "Unknown error")
        }

        else -> {
            LazyHorizontalGrid(
                rows = GridCells
                    .Fixed(7),
                modifier = Modifier
                    .height(128.dp)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(
                    uiState.contributions.size,
                    key = { index -> uiState.contributions[index].date.toString() },

                    ) { item ->
                    //githubのContributionのように、数が多ければ多いほど、色が濃くなるようにする
                    //0は灰色, 1 ~ 10 は 少し緑 11 ~ 20は普通の緑, 21 ~ は濃い緑
                    val contribution = uiState.contributions[item]
                    //背景色を設定する
                    val backgroundColor = when (contribution.count) {
                        //少しだけ灰色
                        0 -> 0x10000000
                        in 1..10 -> 0x3300FF00
                        in 11..20 -> 0x6600FF00
                        else -> 0x9900FF00
                    }

                    //正方形のセルを作成する
                    Box(
                        modifier = Modifier
                            .background(Color(backgroundColor), RoundedCornerShape(4.dp))
                            .aspectRatio(1f)
                    )

                }
            }
        }

    }

}