package com.mobile.cryptocurrencies.app.coins.presentation

import androidx.compose.runtime.Stable
import org.jetbrains.compose.resources.StringResource

@Stable
data class CoinsState(
    val error: StringResource? = null,
    val coins: List<com.mobile.cryptocurrencies.app.coins.presentation.UiCoinListItem> = emptyList(),
    val chartState: com.mobile.cryptocurrencies.app.coins.presentation.UiChartState? = null
)

@Stable
data class UiChartState(
    val sparkLine: List<Double> = emptyList(),
    val isLoading: Boolean = false,
    val coinName: String = ""
)