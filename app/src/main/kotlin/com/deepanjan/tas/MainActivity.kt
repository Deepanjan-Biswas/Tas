package com.deepanjan.tas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkMode
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.deepanjan.tas.ui.theme.TasTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TasApp()
        }
    }
}

@Composable
fun TasApp() {
    val context = LocalContext.current
    val isDarkMode = isSystemInDarkMode()

    val colorScheme = when {
        android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S -> {
            if (isDarkMode) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }
        else -> {
            // Fallback to default theme
            MaterialTheme.colorScheme
        }
    }

    TasTheme(
        colorScheme = colorScheme,
        darkTheme = isDarkMode
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // Navigation will be added here
        }
    }
}
