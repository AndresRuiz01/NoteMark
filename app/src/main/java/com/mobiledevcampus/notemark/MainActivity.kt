package com.mobiledevcampus.notemark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.mobiledevcampus.notemark.core.presentation.design_system.NoteMarkTheme
import com.mobiledevcampus.notemark.core.presentation.design_system.Typography
import com.mobiledevcampus.notemark.core.presentation.design_system.components.NoteMarkTextField
import com.mobiledevcampus.notemark.core.presentation.design_system.titleXLarge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            NoteMarkTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    var username by remember { mutableStateOf("") }
                    val hasUsernameError by remember { derivedStateOf { username.length < 3  && username.isNotEmpty() } }
                    var password by remember { mutableStateOf("") }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                            .padding(innerPadding)
                            .padding(vertical = 32.dp, horizontal = 16.dp)
                    ) {
                        NoteMarkTextField(
                            text = username,
                            onTextChanged = { username = it },
                            placeholder = "John.doe",
                            title = "Username",
                            activeText = "Use between 3 and 20 characters for your username",
                            errorText = "Username must be at least 3 characters",
                            hasError = hasUsernameError,
                        )
                        NoteMarkTextField(
                            text = password,
                            onTextChanged = { password = it },
                            placeholder = "Password",
                            title = "Password",
                            activeText = "Use 8+ characters with a number or symbol for better security",
                            errorText = "Password must be at least 8 characters and include a number or symbol",
                            hasError = true,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteMarkTheme {
        Greeting("Android")
    }
}