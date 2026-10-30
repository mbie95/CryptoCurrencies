package com.mobile.cryptocurrencies

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform