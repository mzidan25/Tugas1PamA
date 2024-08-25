package com.example.tugaspertamazidan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.runtime.remember
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness3
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugaspertamazidan.ui.theme.LightCustomBlack
import com.example.tugaspertamazidan.ui.theme.TugasPertamaZidanTheme

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
            Greeting(
                name = "Muhammad Zidan",
                modifier = Modifier.padding(innerPadding),
                isDarkTheme = isDarkTheme,
                onToggleTheme = { isDarkTheme = !isDarkTheme }
            )
        }
    }
}


@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "$name - 225150407111039",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Pengembangan Aplikasi Mobile Kelas A",
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            CircularThemeToggleButton(isDarkTheme = isDarkTheme, onToggleTheme = onToggleTheme)
        }
    }
}

@Composable
fun CircularThemeToggleButton(isDarkTheme: Boolean, onToggleTheme: () -> Unit) {
    var isPressed by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 1.4f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMediumLow
        )
    )

    val backgroundColor = if (isDarkTheme) LightCustomBlack else Color(0xFFFFA726)

    Box(
        modifier = Modifier
            .size(80.dp)
            .scale(scale)
            .background(backgroundColor, shape = CircleShape)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        tryAwaitRelease()
                        isPressed = false
                        onToggleTheme()
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = if (isDarkTheme) Icons.Filled.Brightness3 else Icons.Filled.WbSunny,
            contentDescription = "Toggle Theme",
            tint = Color.White,
            modifier = Modifier.size(48.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TugasPertamaZidanTheme {
        MyApp()
    }
}
