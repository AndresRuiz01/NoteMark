package com.mobiledevcampus.notemark.auth.presentation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update


class RegistrationViewModel : ViewModel() {

    private val _state = MutableStateFlow(RegistrationState())
    val state = _state
        .asStateFlow()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = RegistrationState()
        )


    fun onAction(action: RegistrationAction) {
        when(action) {
            is RegistrationAction.OnUsernameChanged -> {
                _state.update {
                    it.copy(
                        username = action.username
                    )
                }
            }
            is RegistrationAction.OnEmailChanged -> {
                _state.update {
                    it.copy(
                        email = action.email
                    )
                }
            }
            is RegistrationAction.OnPasswordChanged -> {
                _state.update {
                    it.copy(
                        password = action.password
                    )
                }
            }
            is RegistrationAction.OnRepeatPasswordChanged -> {
                _state.update {
                    it.copy(
                        repeatPassword = action.repeatPassword
                    )
                }
            }
        }
    }

}