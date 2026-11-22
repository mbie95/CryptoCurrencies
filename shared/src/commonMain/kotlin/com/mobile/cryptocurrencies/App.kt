package com.mobile.cryptocurrencies

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.mobile.cryptocurrencies.app.coins.presentation.CoinsListScreen
import com.mobile.cryptocurrencies.app.core.navigation.Buy
import com.mobile.cryptocurrencies.app.core.navigation.Coins
import com.mobile.cryptocurrencies.app.core.navigation.Portfolio
import com.mobile.cryptocurrencies.app.core.navigation.Sell
import com.mobile.cryptocurrencies.app.portfolio.presentation.PortfolioScreen
import com.mobile.cryptocurrencies.app.theme.AppTheme
import com.mobile.cryptocurrencies.app.trade.presentation.buy.BuyScreen
import com.mobile.cryptocurrencies.app.trade.presentation.sell.SellScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController: NavHostController = rememberNavController()
    AppTheme {
        Scaffold { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Portfolio,
                    modifier = Modifier.fillMaxSize()
                ) {
                    composable<Portfolio> {
                        PortfolioScreen(
                            onCoinItemClicked = { coinId ->
                                navController.navigate(Sell(coinId))
                            },
                            onDiscoverCoinsClicked = {
                                navController.navigate(Coins)
                            }
                        )
                    }

                    composable<Coins> {
                        CoinsListScreen { coinId ->
                            navController.navigate(Buy(coinId))
                        }
                    }

                    composable<Buy> { navBackStackEntry ->
                        val coinId: String = navBackStackEntry.toRoute<Buy>().coinId
                        BuyScreen(
                            coinId = coinId,
                            navigateToPortfolio = {
                                navController.navigate(Portfolio) {
                                    popUpTo(Portfolio) { inclusive = true }
                                }
                            }
                        )
                    }

                    composable<Sell> { navBackStackEntry ->
                        val coinId: String = navBackStackEntry.toRoute<Sell>().coinId
                        SellScreen(
                            coinId = coinId,
                            navigateToPortfolio = {
                                navController.navigate(Portfolio) {
                                    popUpTo(Portfolio) { inclusive = true }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}