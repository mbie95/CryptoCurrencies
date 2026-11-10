package com.mobile.cryptocurrencies.app.core.database.portfolio

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mobile.cryptocurrencies.app.portfolio.data.local.PortfolioCoinEntity
import com.mobile.cryptocurrencies.app.portfolio.data.local.PortfolioDao
import com.mobile.cryptocurrencies.app.portfolio.data.local.UserBalanceDao
import com.mobile.cryptocurrencies.app.portfolio.data.local.UserBalanceEntity

@Database(entities = [PortfolioCoinEntity::class, UserBalanceEntity::class], version = 2)
abstract class PortfolioDatabase: RoomDatabase() {
    abstract fun portfolioDao(): PortfolioDao
    abstract fun userBalanceDao(): UserBalanceDao
}