package com.mobiledevcampus.notemark.auth.domain

import com.mobiledevcampus.notemark.core.domain.util.DataError
import com.mobiledevcampus.notemark.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun login(username: String, email: String, password: String): EmptyResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}