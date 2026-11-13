package com.mobile.cryptocurrencies

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mobile.cryptocurrencies.app.coins.presentation.CoinsListScreen
import com.mobile.cryptocurrencies.app.portfolio.presentation.PortfolioScreen
import com.mobile.cryptocurrencies.app.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    AppTheme {
        Scaffold { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                PortfolioScreen(
                    onCoinItemClicked = {},
                    onDiscoverCoinsClicked = {}
                )
            }
        }
    }
}