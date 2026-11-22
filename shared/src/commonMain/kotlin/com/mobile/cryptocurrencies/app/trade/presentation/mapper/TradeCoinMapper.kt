package com.mobile.cryptocurrencies.app.trade.presentation.mapper

import com.mobile.cryptocurrencies.app.coins.data.model.Coin
import com.mobile.cryptocurrencies.app.trade.presentation.common.UiTradeCoinItem

fun UiTradeCoinItem.toCoin() = Coin(
    id = id,
    name = name,
    symbol = symbol,
    iconUrl = iconUrl,
)