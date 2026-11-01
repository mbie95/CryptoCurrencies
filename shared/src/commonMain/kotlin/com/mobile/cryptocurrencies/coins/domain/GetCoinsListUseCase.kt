package com.mobile.cryptocurrencies.coins.domain

import com.mobile.cryptocurrencies.coins.data.mapper.toCoinModel
import com.mobile.cryptocurrencies.coins.data.model.CoinModel
import com.mobile.cryptocurrencies.coins.domain.api.CoinsRemoteDataSource
import com.mobile.cryptocurrencies.core.domain.DataError
import com.mobile.cryptocurrencies.core.domain.Result
import com.mobile.cryptocurrencies.core.domain.map

class GetCoinsListUseCase(
    private val client: CoinsRemoteDataSource,
) {

    suspend fun execute(): Result<List<CoinModel>, DataError.Remote> {
        return client.getListOfCoins().map { dto ->
            dto.data.coins.map { it.toCoinModel() }
        }
    }
}