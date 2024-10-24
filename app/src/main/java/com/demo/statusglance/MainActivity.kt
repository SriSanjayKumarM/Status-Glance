package com.demo.statusglance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.demo.statusglance.ui.theme.StatusGlanceTheme
import com.demo.statusglance.topbar.TopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable decor fitting to ensure system windows are respected
        WindowCompat.setDecorFitsSystemWindows(window, true) // Add this line

        enableEdgeToEdge()
        setContent {
            StatusGlanceTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF121212)),
                    contentColor = Color.White
                ) {
                    StatusApp()
                }
            }
        }
    }
}

@Composable
fun StatusApp(modifier: Modifier = Modifier) {
    val buttonIcons =
        listOf(
        R.drawable.qr_code,
        R.drawable.camera,
        R.drawable.search,
        R.drawable.dots
    ) // List of icons to be displayed as buttons

    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(R.string.title),
                buttonIcons = buttonIcons // Calling TopBar function from TopBar.kt
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StatusGlanceTheme {
        StatusApp()
    }
}
