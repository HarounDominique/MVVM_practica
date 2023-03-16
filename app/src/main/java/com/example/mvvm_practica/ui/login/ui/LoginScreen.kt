package com.example.mvvm_practica.ui.login.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvvm_practica.R

@Composable
fun loginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        login(Modifier.align(Alignment.Center))
    }
}

@Composable
fun login(modifier: Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        headerImage(
            Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.padding(16.dp))
        emailField()
    }
}

@Composable
fun emailField() {
    TextField(value = "", onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
    placeholder = {Text(text = "Email")})
}


@Composable
fun headerImage(align: Modifier) {
    androidx.compose.foundation.Image(
        painter = painterResource(id = R.drawable.ac),
        contentDescription = "Header"
    )
}
