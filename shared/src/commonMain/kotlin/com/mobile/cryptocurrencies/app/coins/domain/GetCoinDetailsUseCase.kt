package com.mobile.cryptocurrencies.app.coins.domain

import com.mobile.cryptocurrencies.app.coins.data.mapper.toCoinModel
import com.mobile.cryptocurrencies.app.coins.data.model.CoinModel
import com.mobile.cryptocurrencies.app.core.domain.DataError
import com.mobile.cryptocurrencies.app.core.domain.Result
import com.mobile.cryptocurrencies.app.core.domain.map

class GetCoinDetailsUseCase(
    private val client: com.mobile.cryptocurrencies.app.coins.domain.api.CoinsRemoteDataSource,
) {

    suspend fun execute(coinId: String): Result<CoinModel, DataError.Remote> {
        return client.getCoinById(coinId).map { dto ->
            dto.data.coin.toCoinModel()
        }
    }
}