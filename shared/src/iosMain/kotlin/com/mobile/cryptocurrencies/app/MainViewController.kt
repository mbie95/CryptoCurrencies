package com.mobile.cryptocurrencies.app

import androidx.compose.ui.window.ComposeUIViewController
import com.mobile.cryptocurrencies.App
import com.mobile.cryptocurrencies.app.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }