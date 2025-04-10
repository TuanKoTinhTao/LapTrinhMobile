package com.example.flowlogin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.flowlogin.ui.theme.FlowLoginTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            FlowLoginTheme {
                val navController = rememberNavController()
                AppNavigation(navController = navController, context = this)
            }
        }
    }
}