package com.mobile.cryptocurrencies.app.coins.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import com.mobile.cryptocurrencies.app.core.domain.Result
import com.mobile.cryptocurrencies.app.core.util.formatFiat
import com.mobile.cryptocurrencies.app.core.util.formatPercentage
import com.mobile.cryptocurrencies.app.core.util.toUiText
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CoinsListViewModel(
    private val getCoinsListUseCase: com.mobile.cryptocurrencies.app.coins.domain.GetCoinsListUseCase,
    private val getCoinPriceHistoryUseCase: com.mobile.cryptocurrencies.app.coins.domain.GetCoinPriceHistoryUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(_root_ide_package_.com.mobile.cryptocurrencies.app.coins.presentation.CoinsState())
    val state = _state
        .onStart {
            getAllCoins()
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = _root_ide_package_.com.mobile.cryptocurrencies.app.coins.presentation.CoinsState()
        )


    private suspend fun getAllCoins() {
        when(val coinsResponse = getCoinsListUseCase.execute()) {
            is Result.Success -> {
                _state.update {
                    _root_ide_package_.com.mobile.cryptocurrencies.app.coins.presentation.CoinsState(
                        coins = coinsResponse.data.map { coinItem ->
                            _root_ide_package_.com.mobile.cryptocurrencies.app.coins.presentation.UiCoinListItem(
                                id = coinItem.coin.id,
                                name = coinItem.coin.name,
                                iconUrl = coinItem.coin.iconUrl,
                                symbol = coinItem.coin.symbol,
                                formattedPrice = formatFiat(coinItem.price),
                                formattedChange = formatPercentage(coinItem.change),
                                isPositive = coinItem.change >= 0,
                            )
                        }
                    )
                }
            }
            is Result.Error -> {
                _state.update {
                    it.copy(
                        coins = emptyList(),
                        error = coinsResponse.error.toUiText(),
                    )
                }
            }
        }
    }

    fun onCoinLongPressed(coinId: String) {
        _state.update {
            it.copy(
                chartState = _root_ide_package_.com.mobile.cryptocurrencies.app.coins.presentation.UiChartState(
                    sparkLine = emptyList(),
                    isLoading = true,
                )
            )
        }

        viewModelScope.launch {
            when(val priceHistory = getCoinPriceHistoryUseCase.execute(coinId)) {
                is Result.Success -> {
                    _state.update { currentState ->
                        currentState.copy(
                            chartState = _root_ide_package_.com.mobile.cryptocurrencies.app.coins.presentation.UiChartState(
                                sparkLine = priceHistory.data.sortedBy { it.timestamp }
                                    .map { it.price },
                                isLoading = false,
                                coinName = _state.value.coins.find { it.id == coinId }?.name.orEmpty(),
                            )
                        )
                    }
                }
                is Result.Error -> {
                    _state.update { currentState ->
                        currentState.copy(
                            chartState = _root_ide_package_.com.mobile.cryptocurrencies.app.coins.presentation.UiChartState(
                                sparkLine = emptyList(),
                                isLoading = false,
                                coinName = "",
                            )
                        )
                    }
                }
            }
        }
    }

    fun onDismissChart() {
        _state.update {
            it.copy(chartState = null)
        }
    }
}