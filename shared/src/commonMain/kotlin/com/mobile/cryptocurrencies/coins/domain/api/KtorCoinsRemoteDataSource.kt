package com.mobile.cryptocurrencies.coins.domain.api

import com.mobile.cryptocurrencies.coins.data.remote.dto.CoinDetailsResponseDto
import com.mobile.cryptocurrencies.coins.data.remote.dto.CoinPriceHistoryResponseDto
import com.mobile.cryptocurrencies.coins.data.remote.dto.CoinsResponseDto
import com.mobile.cryptocurrencies.core.domain.DataError
import com.mobile.cryptocurrencies.core.domain.Result
import com.mobile.cryptocurrencies.core.network.safeCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get

private const val BASE_URL = "https://api.coinranking.com/v2"

class KtorCoinsRemoteDataSource(
    private val httpClient: HttpClient
) : CoinsRemoteDataSource {

    override suspend fun getListOfCoins(): Result<CoinsResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get("$BASE_URL/coins")
        }
    }

    override suspend fun getPriceHistory(coinId: String): Result<CoinPriceHistoryResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get("$BASE_URL/coin/$coinId/history")
        }
    }

    override suspend fun getCoinById(coinId: String): Result<CoinDetailsResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get("$BASE_URL/coin/$coinId")
        }
    }
}