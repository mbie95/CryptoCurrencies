package com.mobile.cryptocurrencies.coins.domain

import com.mobile.cryptocurrencies.coins.data.mapper.toPriceModel
import com.mobile.cryptocurrencies.coins.data.model.PriceModel
import com.mobile.cryptocurrencies.coins.domain.api.CoinsRemoteDataSource
import com.mobile.cryptocurrencies.core.domain.DataError
import com.mobile.cryptocurrencies.core.domain.Result
import com.mobile.cryptocurrencies.core.domain.map

class GetCoinPriceHistoryUseCase(
    private val client: CoinsRemoteDataSource,
) {

    suspend fun execute(coinId: String): Result<List<PriceModel>, DataError.Remote> {
        return client.getPriceHistory(coinId).map { dto ->
            dto.data.history.map { it.toPriceModel() }
        }
    }
}