package com.mobile.cryptocurrencies.app.di

import com.mobile.cryptocurrencies.coins.domain.GetCoinDetailsUseCase
import com.mobile.cryptocurrencies.coins.domain.GetCoinsListUseCase
import com.mobile.cryptocurrencies.coins.domain.api.CoinsRemoteDataSource
import com.mobile.cryptocurrencies.coins.domain.api.KtorCoinsRemoteDataSource
import com.mobile.cryptocurrencies.coins.presentation.CoinsListViewModel
import com.mobile.cryptocurrencies.core.network.HttpClientFactory
import io.ktor.client.HttpClient
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            sharedModule,
            platformModule,
        )
    }


expect val platformModule: Module

val sharedModule = module {
    // core
    single<HttpClient> { HttpClientFactory.create(get()) }

    // coins list
    viewModel { CoinsListViewModel(get()) }
    singleOf(::GetCoinsListUseCase)
    singleOf(::KtorCoinsRemoteDataSource).bind<CoinsRemoteDataSource>()
    singleOf(::GetCoinDetailsUseCase)
}