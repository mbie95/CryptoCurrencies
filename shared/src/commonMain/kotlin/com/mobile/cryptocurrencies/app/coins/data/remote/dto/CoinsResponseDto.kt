package com.mobile.cryptocurrencies.app.coins.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinsResponseDto(
    val data: com.mobile.cryptocurrencies.app.coins.data.remote.dto.CoinsListDto
)

@Serializable
data class CoinsListDto(
    val coins: List<com.mobile.cryptocurrencies.app.coins.data.remote.dto.CoinItemDto>
)

@Serializable
data class CoinItemDto(
    val uuid: String,
    val symbol: String,
    val name: String,
    val iconUrl: String,
    val price: Double,
    val rank: Int,
    val change: Double,
)