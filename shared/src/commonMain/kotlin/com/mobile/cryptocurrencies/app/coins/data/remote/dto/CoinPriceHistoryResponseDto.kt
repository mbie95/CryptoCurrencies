package com.mobile.cryptocurrencies.app.coins.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinPriceHistoryResponseDto(
    val data: com.mobile.cryptocurrencies.app.coins.data.remote.dto.CoinPriceHistoryDto
)

@Serializable
data class CoinPriceHistoryDto(
    val history: List<com.mobile.cryptocurrencies.app.coins.data.remote.dto.CoinPriceDto>
)

@Serializable
data class CoinPriceDto(
    val price: Double?,
    val timestamp: Long
)