package com.example.flowlogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(onSignInClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.uth),
            contentDescription = null,
            modifier = Modifier.height(200.dp).width(200.dp)
        )
        Text("SmartTasks", style = MaterialTheme.typography.headlineMedium)
        Text("A simple and efficient to-do app")
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onSignInClicked) {
            Text("Sign in with Google")
        }
    }
}

