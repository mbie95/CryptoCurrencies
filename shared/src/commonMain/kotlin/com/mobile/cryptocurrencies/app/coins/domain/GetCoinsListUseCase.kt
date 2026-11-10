package com.mobile.cryptocurrencies.app.coins.domain

import com.mobile.cryptocurrencies.app.coins.data.mapper.toCoinModel
import com.mobile.cryptocurrencies.app.coins.data.model.CoinModel
import com.mobile.cryptocurrencies.app.core.domain.DataError
import com.mobile.cryptocurrencies.app.core.domain.Result
import com.mobile.cryptocurrencies.app.core.domain.map
import kotlin.collections.map

class GetCoinsListUseCase(
    private val client: com.mobile.cryptocurrencies.app.coins.domain.api.CoinsRemoteDataSource,
) {

    suspend fun execute(): Result<List<CoinModel>, DataError.Remote> {
        return client.getListOfCoins().map { dto ->
            dto.data.coins.map { it.toCoinModel() }
        }
    }
}