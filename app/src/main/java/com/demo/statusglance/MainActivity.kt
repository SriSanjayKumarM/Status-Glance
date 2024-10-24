package com.demo.statusglance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.demo.statusglance.ui.theme.StatusGlanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable decor fitting to ensure system windows are respected
        WindowCompat.setDecorFitsSystemWindows(window, true) // Add this line

        // You can keep this if you want to allow edge-to-edge content
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
    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(R.string.title),
                drawableQR = R.drawable.qr_code,
                drawableCamera = R.drawable.camera,
                drawableSearch = R.drawable.search,
                drawableDots = R.drawable.dots,
            )
        }
    ) { innerPadding ->
        // Content of the app goes here
        // Use innerPadding to avoid overlap with the top bar
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    drawableQR: Int,
    drawableCamera: Int,
    drawableSearch: Int,
    drawableDots: Int,
    ) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = title,
                    style = androidx.compose.ui.text.TextStyle(fontSize = 24.sp),
                    modifier = Modifier.weight(1f)
                )

                IconButton(
                    onClick = {},
                    modifier = Modifier.size(36.dp),
                ){
                    Image(
                        painter = painterResource(drawableQR),
                        contentDescription = "QR Code",
                        modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(36.dp),
                ){
                    Image(
                        painter = painterResource(drawableCamera),
                        contentDescription = "Camera",
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.width(4.dp))
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(36.dp),
                ){
                    Image(
                        painter = painterResource(drawableSearch),
                        contentDescription = "Search",
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.width(4.dp))
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(36.dp),
                ){
                    Image(
                        painter = painterResource(drawableDots),
                        contentDescription = "Menu",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    )
    Spacer(modifier = Modifier.height(500.dp))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StatusGlanceTheme {
        StatusApp()
    }
}
