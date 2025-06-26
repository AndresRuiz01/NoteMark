package com.mobiledevcampus.notemark.auth.presentation.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mobiledevcampus.notemark.core.presentation.design_system.components.NoteMarkTextField


@Composable
fun RegistrationScreenRoot(
    modifier: Modifier = Modifier,
    viewModel: RegistrationViewModel = koinViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    RegistrationScreen(
        state = state,
        onAction = viewModel::onAction
    )

}


@Composable
fun RegistrationScreen(
    state: RegistrationState,
    onAction: (RegistrationAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(vertical = 32.dp, horizontal = 16.dp)
        ) {
            NoteMarkTextField(
                text = state.username,
                onTextChanged = { onAction(RegistrationAction.OnUsernameChanged(it)) },
                placeholder = "John.doe",
                title = "Username",
                activeText = "Use between 3 and 20 characters for your username",
                errorText = if (state.hasShortUsernameError) "Username must be at least 3 characters." else if (state.hasLongUsernameError) "Username can't be longer than 20 characters." else "",
                hasError = state.hasShortUsernameError || state.hasLongUsernameError,
            )
            NoteMarkTextField(
                text = state.email,
                onTextChanged = { onAction(RegistrationAction.OnEmailChanged(it)) },
                placeholder = "john.doe@example.com",
                title = "Email",
                activeText = "",
                errorText = "Invalid email provided",
                hasError = state.hasValidEmail,
            )
            NoteMarkTextField(
                text = state.password,
                onTextChanged = { onAction(RegistrationAction.OnPasswordChanged(it)) },
                placeholder = "Password",
                title = "Password",
                activeText = "Use 8+ characters with a number or symbol for better security",
                errorText = "Password must be at least 8 characters and include a number or symbol",
                hasError = state.hasValidPassword,
                isPassword = true,
            )
            NoteMarkTextField(
                text = state.repeatPassword,
                onTextChanged = { onAction(RegistrationAction.OnRepeatPasswordChanged(it)) },
                placeholder = "Password",
                title = "Repeat Password",
                activeText = "",
                errorText = "Passwords do not match",
                hasError = state.hasValidRepeatPassword,
                isPassword = true,
            )
        }
    }

}