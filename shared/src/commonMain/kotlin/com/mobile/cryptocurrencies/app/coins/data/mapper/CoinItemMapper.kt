package com.mobile.cryptocurrencies.app.coins.data.mapper

import com.mobile.cryptocurrencies.app.coins.data.remote.dto.CoinItemDto
import com.mobile.cryptocurrencies.app.coins.data.model.Coin
import com.mobile.cryptocurrencies.app.coins.data.model.CoinModel
import com.mobile.cryptocurrencies.app.coins.data.model.PriceModel
import com.mobile.cryptocurrencies.app.coins.data.remote.dto.CoinPriceDto

fun com.mobile.cryptocurrencies.app.coins.data.remote.dto.CoinItemDto.toCoinModel() =
    _root_ide_package_.com.mobile.cryptocurrencies.app.coins.data.model.CoinModel(
        coin = _root_ide_package_.com.mobile.cryptocurrencies.app.coins.data.model.Coin(
            id = uuid,
            name = name,
            symbol = symbol,
            iconUrl = iconUrl,
        ),
        price = price,
        change = change,
    )

fun com.mobile.cryptocurrencies.app.coins.data.remote.dto.CoinPriceDto.toPriceModel() =
    _root_ide_package_.com.mobile.cryptocurrencies.app.coins.data.model.PriceModel(
        price = price ?: 0.0,
        timestamp = timestamp,
    )