package com.mobiledevcampus.notemark.auth.presentation

import android.app.Activity
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.mobiledevcampus.notemark.core.presentation.design_system.Inter
import com.mobiledevcampus.notemark.core.presentation.design_system.SpaceGrotesk
import com.mobiledevcampus.notemark.core.presentation.design_system.Typography
import com.mobiledevcampus.notemark.core.presentation.design_system.components.NoteMarkTextField
import com.mobiledevcampus.notemark.core.presentation.design_system.OnPrimary
import com.mobiledevcampus.notemark.core.presentation.design_system.OnSurface
import com.mobiledevcampus.notemark.core.presentation.design_system.Primary
import kotlinx.serialization.builtins.serializer
import java.time.format.TextStyle

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
    val isButtonEnabled = email.isNotBlank() && password.isNotBlank()

    val window = (LocalActivity.current as? Activity)?.window
    SideEffect {
        WindowCompat.setDecorFitsSystemWindows(window!!, false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary)
    ) {
        Box (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding())
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(OnPrimary)
        ) {
            Column(
                modifier = modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = "Log In",
                    fontFamily = SpaceGrotesk,
                    style = Typography.titleLarge,
                    color = OnSurface
                )

                Text(
                    text = "Capture your thoughts and ideas.",
                    fontFamily = Inter,
                    style = Typography.bodySmall,
                    color = OnSurface
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
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(
                    modifier = Modifier.padding(8.dp)
                )

                Button(
                    onClick = onLoginClicked,
                    enabled = isButtonEnabled,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Primary,
                        contentColor = OnPrimary
                    )
                ) {
                    Text(
                        text = "Log In",
                        fontFamily = Inter,
                        style = Typography.bodyMedium
                    )
                }

                Spacer(
                    modifier = Modifier.padding(8.dp)
                )

                ClickableText(
                    text = AnnotatedString("Don't have an account?"),
                    onClick = { offset ->
                        val fullText = "Don't have an account? Sign up"
                        val startIndex = fullText.indexOf("Sign up")
                        val endIndex = startIndex + "Sign up".length

                        if (offset in startIndex until endIndex) {
//                    navController.navigate("registration")
                        }
                    },
                    style = androidx.compose.ui.text.TextStyle(
                        fontFamily = SpaceGrotesk,
                        fontStyle = Typography.bodySmall.fontStyle,
                        color = Primary
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                )
            }
        }
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