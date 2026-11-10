package com.mobile.cryptocurrencies.app.coins.domain.api

import com.mobile.cryptocurrencies.app.coins.data.remote.dto.CoinDetailsResponseDto
import com.mobile.cryptocurrencies.app.coins.data.remote.dto.CoinPriceHistoryResponseDto
import com.mobile.cryptocurrencies.app.coins.data.remote.dto.CoinsResponseDto
import com.mobile.cryptocurrencies.app.core.domain.DataError
import com.mobile.cryptocurrencies.app.core.domain.Result

interface CoinsRemoteDataSource {
    suspend fun getListOfCoins(): Result<CoinsResponseDto, DataError.Remote>
    suspend fun getPriceHistory(coinId: String): Result<CoinPriceHistoryResponseDto, DataError.Remote>
    suspend fun getCoinById(coinId: String): Result<CoinDetailsResponseDto, DataError.Remote>
}