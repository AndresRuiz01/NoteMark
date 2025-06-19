package com.mobiledevcampus.notemark.core.data.networking

import kotlinx.serialization.Serializable

@Serializable
data class AccessTokenRequest(
    val refreshToken: String,
)