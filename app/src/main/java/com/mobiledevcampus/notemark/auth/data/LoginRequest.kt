package com.mobiledevcampus.notemark.auth.data

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val username: String,
    val email: String,
    val password: String
)