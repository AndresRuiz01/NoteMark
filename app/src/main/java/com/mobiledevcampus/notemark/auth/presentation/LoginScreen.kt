package com.mobiledevcampus.notemark.auth.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobiledevcampus.notemark.core.presentation.design_system.Inter
import com.mobiledevcampus.notemark.core.presentation.design_system.NoteMarkTheme
import com.mobiledevcampus.notemark.core.presentation.design_system.SpaceGrotesk
import com.mobiledevcampus.notemark.core.presentation.design_system.Typography
import com.mobiledevcampus.notemark.core.presentation.design_system.components.NoteMarkTextField
import com.mobiledevcampus.notemark.core.presentation.design_system.titleXLarge

@Composable
fun LoginScreen(
    email: String,
    password: String,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    isLoading: Boolean = false,
    errorMessage: String? = null,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Log In",
            fontFamily = SpaceGrotesk,
            style = Typography.titleLarge
        )

        Text(
            text = "Capture your thoughts and ideas.",
            fontFamily = Inter,
            style = Typography.bodySmall
        )

        Spacer(
            modifier = Modifier.padding(16.dp)
        )

        NoteMarkTextField(
            title = "Email",
            hintText = "Enter your email",
            text = email,
            onTextChanged = onEmailChanged,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.padding(8.dp)
        )

        NoteMarkTextField(
            title = "Password",
            hintText = "Enter your password",
            text = password,
            onTextChanged = onPasswordChanged,
            isPassword = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.padding(8.dp)
        )

        Button(
            onClick = onLoginClicked,
            enabled = !isLoading,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Log In",
                fontFamily = Inter,
                style = Typography.bodyLarge
            )
        }

        Spacer(
            modifier = Modifier.padding(8.dp)
        )

        ClickableText(
            text = AnnotatedString("Don't have an account? Sign up"),
            onClick = { offset ->
                val fullText = "Don't have an account? Sign up"
                val startIndex = fullText.indexOf("Sign up")
                val endIndex = startIndex + "Sign up".length

                if (offset in startIndex until endIndex) {
//                    navController.navigate("registration")
                }
            },
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        email = "",
        password = "",
        onEmailChanged = {},
        onPasswordChanged = {},
        onLoginClicked = {}
    )
}