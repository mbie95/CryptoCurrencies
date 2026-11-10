package com.mobile.cryptocurrencies.app.coins.domain

import com.mobile.cryptocurrencies.app.coins.data.mapper.toPriceModel
import com.mobile.cryptocurrencies.app.coins.data.model.PriceModel
import com.mobile.cryptocurrencies.app.core.domain.DataError
import com.mobile.cryptocurrencies.app.core.domain.Result
import com.mobile.cryptocurrencies.app.core.domain.map
import kotlin.collections.map

class GetCoinPriceHistoryUseCase(
    private val client: com.mobile.cryptocurrencies.app.coins.domain.api.CoinsRemoteDataSource,
) {

    suspend fun execute(coinId: String): Result<List<PriceModel>, DataError.Remote> {
        return client.getPriceHistory(coinId).map { dto ->
            dto.data.history.map { it.toPriceModel() }
        }
    }
}