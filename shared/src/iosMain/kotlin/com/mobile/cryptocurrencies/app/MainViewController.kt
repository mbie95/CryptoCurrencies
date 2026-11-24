package com.mobile.cryptocurrencies.app

import androidx.compose.ui.window.ComposeUIViewController
import com.mobile.cryptocurrencies.App
import com.mobile.cryptocurrencies.app.di.initKoin
import org.koin.mp.KoinPlatformTools

fun MainViewController() = ComposeUIViewController(
    configure = {
        if (KoinPlatformTools.defaultContext().getOrNull() == null) {
            initKoin()
        }
    }
) { App() }
