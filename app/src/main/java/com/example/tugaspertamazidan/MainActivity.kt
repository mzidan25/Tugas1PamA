package com.example.tugaspertamazidan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.tugaspertamazidan.ui.theme.TugasPertamaZidanTheme
import com.example.tugaspertamazidan.AppLayout


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var isDarkTheme by remember { mutableStateOf(false) }

    TugasPertamaZidanTheme(darkTheme = isDarkTheme) {
        val backgroundColor = MaterialTheme.colorScheme.background

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor),
            contentColor = MaterialTheme.colorScheme.onBackground
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                AppLayout(
                    name = "Muhammad Zidan",
                    isDarkTheme = isDarkTheme,
                    onToggleTheme = { isDarkTheme = !isDarkTheme }
                )
            }
        }

    }
}
