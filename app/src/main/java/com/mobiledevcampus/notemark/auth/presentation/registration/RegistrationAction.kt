package com.mobiledevcampus.notemark.auth.presentation.registration

sealed interface RegistrationAction {
    data class OnUsernameChanged(val username: String) : RegistrationAction
    data class OnEmailChanged(val email: String) : RegistrationAction
    data class OnPasswordChanged(val password: String) : RegistrationAction
    data class OnRepeatPasswordChanged(val repeatPassword: String) : RegistrationAction
}