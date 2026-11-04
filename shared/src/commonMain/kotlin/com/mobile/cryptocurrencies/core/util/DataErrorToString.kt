package com.mobile.cryptocurrencies.core.util

import com.mobile.cryptocurrencies.core.domain.DataError
import cryptocurrencies.shared.generated.resources.Res
import cryptocurrencies.shared.generated.resources.error_disk_full
import cryptocurrencies.shared.generated.resources.error_insufficient_balance
import cryptocurrencies.shared.generated.resources.error_no_internet
import cryptocurrencies.shared.generated.resources.error_request_timeout
import cryptocurrencies.shared.generated.resources.error_serialization
import cryptocurrencies.shared.generated.resources.error_too_many_requests
import cryptocurrencies.shared.generated.resources.error_unknown
import org.jetbrains.compose.resources.StringResource

fun DataError.toUiText(): StringResource {
    val stringRes = when(this) {
        DataError.Local.DISK_FULL -> Res.string.error_disk_full
        DataError.Local.UNKNOWN -> Res.string.error_unknown
        DataError.Remote.REQUEST_TIMEOUT -> Res.string.error_request_timeout
        DataError.Remote.TOO_MANY_REQUESTS -> Res.string.error_too_many_requests
        DataError.Remote.NO_INTERNET -> Res.string.error_no_internet
        DataError.Remote.SERVER -> Res.string.error_unknown
        DataError.Remote.SERIALIZATION -> Res.string.error_serialization
        DataError.Remote.UNKNOWN -> Res.string.error_unknown
        DataError.Local.INSUFFICIENT_FUNDS -> Res.string.error_insufficient_balance
    }
    return stringRes
}