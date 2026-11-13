package com.mobile.cryptocurrencies.app.portfolio.data

import com.mobile.cryptocurrencies.app.coins.data.model.Coin

data class PortfolioCoinModel(
    val coin: Coin,
    val performancePercent: Double,
    val averagePurchasePrice: Double,
    val ownedAmountInUnit: Double,
    val ownedAmountInFiat: Double,
)