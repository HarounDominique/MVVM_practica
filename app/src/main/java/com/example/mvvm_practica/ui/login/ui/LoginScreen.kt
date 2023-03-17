package com.example.mvvm_practica.ui.login.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvm_practica.R

@Composable
fun loginScreen(viewModelo: LoginViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        login(Modifier.align(Alignment.Center), viewModelo)
    }
}

@Composable
fun login(modifier: Modifier, viewModelo: LoginViewModel) {

    val email: String by viewModelo.email.observeAsState(initial = "")
    val password: String by viewModelo.password.observeAsState(initial = "")
    val logiEnabled: Boolean by viewModelo.loginEnabled.observeAsState(initial = false)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        headerImage(
            Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.padding(16.dp))
        emailField(email) { viewModelo.onLoginChanged(it, password) }
        Spacer(modifier = Modifier.padding(16.dp))
        passwordField(password) { viewModelo.onLoginChanged(password, it) }
        Spacer(modifier = Modifier.padding(16.dp))
        forgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.padding(16.dp))
        loginButton(logiEnabled) { viewModelo.onLoginSelected() }
    }
}


@Composable
fun loginButton(logiEnabled: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected() },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp), colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF293575),
            disabledBackgroundColor = Color(0xFF585E80),
            contentColor = Color.White,
            disabledContentColor = Color.White
        ), enabled = logiEnabled
    ) {
        Text(text = "Iniciar sesión")
    }
}

@Composable
fun forgotPassword(modifier: Modifier) {
    Text(
        text = "¿Olvidaste tu constraseña?",
        modifier = modifier.clickable { },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun passwordField(password: String, onTextFieldChange: (String) -> Unit) {
    TextField(
        value = password, onValueChange = { onTextFieldChange(it) },
        placeholder = { Text(text = "Contraseña") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF293575),
            backgroundColor = Color(0xFFB4ACC0)
        )
    )
}

@Composable
fun emailField(email: String, onTextFieldChange: (String) -> Unit) {
    TextField(
        value = email, onValueChange = { onTextFieldChange(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF293575),
            backgroundColor = Color(0xFFB4ACC0)
        )
    )
}


@Composable
fun headerImage(align: Modifier) {
    androidx.compose.foundation.Image(
        painter = painterResource(id = R.drawable.ac),
        contentDescription = "Header"
    )
}
