package com.mobiledevcampus.notemark.core.presentation.design_system.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.*
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobiledevcampus.notemark.core.presentation.design_system.NoteMarkTheme


@Composable
fun NoteMarkTextField (
    title: String,
    hintText: String,
    text: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = onTextChanged,
        label = { Text(title) },
        placeholder = { Text(hintText) },
        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = if (isPassword) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions.Default,
        trailingIcon = {
            if (isPassword) {
                val icon = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = icon, contentDescription = "Toggle password visibility")
                }
            }
        },
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
    )
}

@Composable
fun NoteMarkTextField(
    text: String,
    onTextChanged: (String) -> Unit,
    title: String,
    placeholder: String,
    activeText: String,
    errorText: String,
    hasError: Boolean,
    focusRequester: FocusRequester = FocusRequester()
) {
    var isFocused by rememberSaveable { mutableStateOf(false) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(12.dp))
        ) {
            BasicTextField(
                value = text,
                onValueChange = onTextChanged,
                textStyle = MaterialTheme.typography.bodyLarge,
                singleLine = true,
                decorationBox = {
                    if (text.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    it()
                },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .onFocusChanged { state ->
                        isFocused = state.isFocused
                    }
                    .focusRequester(focusRequester)
            )
        }

        if (isFocused) {
            Text(
                text = activeText,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant ,
                modifier = Modifier.padding(start = 12.dp)
            )
        }

        if (hasError && !isFocused) {
            Text(
                text = errorText,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(start = 12.dp)
            )
        }
    }
}


@Preview
@Composable
private fun NoteMarkTextFieldPreview() {
    var text by remember { mutableStateOf("testing") }
    NoteMarkTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(vertical = 32.dp, horizontal = 16.dp)
        ) {
            NoteMarkTextField(
                text = text,
                onTextChanged = { text = it },
                placeholder = "John.doe",
                title = "Username",
                activeText = "Use between 3 and 20 characters for your username",
                errorText = "Username must be at least 3 characters",
                hasError = true,
            )
        }
    }
}