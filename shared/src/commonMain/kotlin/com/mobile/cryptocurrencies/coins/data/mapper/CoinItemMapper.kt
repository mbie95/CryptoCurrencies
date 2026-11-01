package com.mobile.cryptocurrencies.coins.data.mapper

import com.mobile.cryptocurrencies.coins.data.remote.dto.CoinItemDto
import com.mobile.cryptocurrencies.coins.data.model.Coin
import com.mobile.cryptocurrencies.coins.data.model.CoinModel
import com.mobile.cryptocurrencies.coins.data.model.PriceModel
import com.mobile.cryptocurrencies.coins.data.remote.dto.CoinPriceDto

fun CoinItemDto.toCoinModel() = CoinModel(
    coin = Coin(
        id = uuid,
        name = name,
        symbol = symbol,
        iconUrl = iconUrl,
    ),
    price = price,
    change = change,
)

fun CoinPriceDto.toPriceModel() = PriceModel(
    price = price ?: 0.0,
    timestamp = timestamp,
)