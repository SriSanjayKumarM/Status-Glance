package com.demo.statusglance

import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.demo.statusglance.bottombar.BottomBar
import com.demo.statusglance.mystatus.StatusImageRow
import com.demo.statusglance.mystatus.StatustextRow
import com.demo.statusglance.topbar.TopBar
import com.demo.statusglance.ui.theme.StatusGlanceTheme

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

    val context = LocalContext.current // Getting the current context for Toast

    val buttonIcons =
        listOf(
            R.drawable.qr_code,
            R.drawable.camera,
            R.drawable.search,
            R.drawable.dots
        ) // List of icons to be displayed as buttons

    val buttonClickActions =
        listOf(
            { Toast.makeText(context, "QR Code Clicked", Toast.LENGTH_SHORT).show() },
            { Toast.makeText(context, "Camera Clicked", Toast.LENGTH_SHORT).show() },
            { Toast.makeText(context, "Search Clicked", Toast.LENGTH_SHORT).show() },
            { Toast.makeText(context, "Menu Clicked", Toast.LENGTH_SHORT).show() }
        ) // List of top bar icons actions

    val bottomButtons =
        listOf(
            R.drawable.chats,
            R.drawable.updates,
            R.drawable.community,
            R.drawable.call,
        ) // List of Bottom icons to be displayed

    val bottomButtonActions =
        listOf(
            { Toast.makeText(context, "Chat with your friends", Toast.LENGTH_SHORT).show() },
            { Toast.makeText(context, "You are on this page", Toast.LENGTH_SHORT).show() },
            { Toast.makeText(context, "Join Communities", Toast.LENGTH_SHORT).show() },
            { Toast.makeText(context, "Calls are not allowed", Toast.LENGTH_SHORT).show() }
        ) // List of bottom bar icons actions

    Scaffold(

        topBar = {
            TopBar(
                title = stringResource(R.string.title),
                buttonIcons = buttonIcons, // Calling TopBar function from TopBar.kt
                buttonClickActions = buttonClickActions // Passing the click actions to TopBar
            )
        },

        bottomBar = { // Add this line to include the BottomBar
            BottomBar(
                bottomButtons = bottomButtons,
                bottomButtonActions = bottomButtonActions
            )
        }

    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                StatustextRow()
                Spacer(modifier = Modifier.height(24.dp)) // Space between rows
                StatusImageRow()
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                StatustextRow()
                Spacer(modifier = Modifier.height(24.dp)) // Space between rows
                StatusImageRow()
            }
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
