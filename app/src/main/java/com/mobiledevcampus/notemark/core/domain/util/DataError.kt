package com.mobiledevcampus.notemark.core.domain.util

sealed interface DataError: Error {
    enum class Network: DataError {
        UNAUTHORIZED,
        METHOD_NOT_ALLOWED,
        CONFLICT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        SERVER_ERROR,
        SERIALIZATION,
        UNKNOWN
    }

    enum class Local: DataError {
        DISK_FULL
    }
}