package com.mobiledevcampus.notemark.auth.presentation.registration

import android.util.Patterns

data class RegistrationState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val repeatPassword: String = ""
) {
    val hasShortUsernameError: Boolean = username.isNotEmpty() && username.length < 3
    val hasLongUsernameError: Boolean = username.length > 20
    val hasValidEmail: Boolean = !Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.isNotEmpty()
    val hasValidPassword: Boolean = false
    val hasValidRepeatPassword: Boolean = password.isNotEmpty() && repeatPassword.isNotEmpty() && password != repeatPassword
    val isCreateAccountActive: Boolean = !hasShortUsernameError && !hasLongUsernameError && hasValidEmail && hasValidPassword && hasValidRepeatPassword
}