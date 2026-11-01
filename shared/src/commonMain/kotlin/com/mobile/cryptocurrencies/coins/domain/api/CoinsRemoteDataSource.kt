package com.mobile.cryptocurrencies.coins.domain.api

import com.mobile.cryptocurrencies.coins.data.remote.dto.CoinDetailsResponseDto
import com.mobile.cryptocurrencies.coins.data.remote.dto.CoinPriceHistoryResponseDto
import com.mobile.cryptocurrencies.coins.data.remote.dto.CoinsResponseDto
import com.mobile.cryptocurrencies.core.domain.DataError
import com.mobile.cryptocurrencies.core.domain.Result

interface CoinsRemoteDataSource {
    suspend fun getListOfCoins(): Result<CoinsResponseDto, DataError.Remote>
    suspend fun getPriceHistory(coinId: String): Result<CoinPriceHistoryResponseDto, DataError.Remote>
    suspend fun getCoinById(coinId: String): Result<CoinDetailsResponseDto, DataError.Remote>
}