package com.mobile.cryptocurrencies.app

import android.app.Application
import com.mobile.cryptocurrencies.app.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

class CryptoApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@CryptoApplication)
        }
    }
}