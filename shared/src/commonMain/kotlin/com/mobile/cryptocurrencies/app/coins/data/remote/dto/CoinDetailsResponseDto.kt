package com.mobile.cryptocurrencies.app.coins.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinDetailsResponseDto(
    val data: com.mobile.cryptocurrencies.app.coins.data.remote.dto.CoinResponseDto,
)

@Serializable
data class CoinResponseDto(
    val coin: com.mobile.cryptocurrencies.app.coins.data.remote.dto.CoinItemDto,
)