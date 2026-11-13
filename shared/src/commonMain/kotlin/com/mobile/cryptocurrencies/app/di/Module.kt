package com.mobile.cryptocurrencies.app.di

import androidx.room.RoomDatabase
import com.mobile.cryptocurrencies.app.coins.domain.GetCoinDetailsUseCase
import com.mobile.cryptocurrencies.app.coins.domain.GetCoinPriceHistoryUseCase
import com.mobile.cryptocurrencies.app.coins.domain.GetCoinsListUseCase
import com.mobile.cryptocurrencies.app.coins.domain.api.KtorCoinsRemoteDataSource
import com.mobile.cryptocurrencies.app.core.database.portfolio.PortfolioDatabase
import com.mobile.cryptocurrencies.app.core.database.portfolio.getPortfolioDatabase
import com.mobile.cryptocurrencies.app.core.network.HttpClientFactory
import com.mobile.cryptocurrencies.app.portfolio.domain.PortfolioRepository
import com.mobile.cryptocurrencies.app.portfolio.domain.PortfolioRepositoryImpl
import com.mobile.cryptocurrencies.app.portfolio.presentation.PortfolioViewModel
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

    // portfolio
    single {
        getPortfolioDatabase(get<RoomDatabase.Builder<PortfolioDatabase>>())
    }
    singleOf(::PortfolioRepositoryImpl).bind<PortfolioRepository>()
    single { get<PortfolioDatabase>().portfolioDao() }
    single { get<PortfolioDatabase>().userBalanceDao() }
    viewModel { PortfolioViewModel(get()) }

    // coins list
    viewModel {
        _root_ide_package_.com.mobile.cryptocurrencies.app.coins.presentation.CoinsListViewModel(
            get(),
            get()
        )
    }
    singleOf(::GetCoinsListUseCase)
    singleOf(::KtorCoinsRemoteDataSource).bind<com.mobile.cryptocurrencies.app.coins.domain.api.CoinsRemoteDataSource>()
    singleOf(::GetCoinDetailsUseCase)
    singleOf(::GetCoinPriceHistoryUseCase)
}