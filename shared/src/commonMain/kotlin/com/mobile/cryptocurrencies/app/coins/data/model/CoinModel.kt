package com.mobile.cryptocurrencies.app.coins.data.model

data class CoinModel(
    val coin: com.mobile.cryptocurrencies.app.coins.data.model.Coin,
    val price: Double,
    val change: Double,
)