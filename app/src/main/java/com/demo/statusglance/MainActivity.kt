    package com.demo.statusglance

    import android.os.Bundle
    import android.widget.Toast
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.foundation.isSystemInDarkTheme
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.foundation.lazy.items
    import androidx.compose.foundation.shape.CircleShape
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.graphics.ColorFilter
    import androidx.compose.ui.platform.LocalContext
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.res.stringResource
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.core.view.WindowCompat
    import com.demo.statusglance.bottombar.BottomBar
    import com.demo.statusglance.datasource.DataSource
    import com.demo.statusglance.model.Names
    import com.demo.statusglance.mystatus.StatusImageRow
    import com.demo.statusglance.mystatus.StatusTextRow
    import com.demo.statusglance.recentupdates.RecentUpdatesTextRow
    import com.demo.statusglance.topbar.TopBar
    import com.demo.statusglance.ui.theme.StatusGlanceTheme

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            // Enable decor fitting
            WindowCompat.setDecorFitsSystemWindows(window, true)
            enableEdgeToEdge()

            setContent {
                StatusGlanceTheme {
                    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                        StatusApp()
                    }
                }
            }
        }
    }

    @Composable
    fun StatusApp(modifier: Modifier = Modifier) {
        val context = LocalContext.current
        val namesList = DataSource().loadNames()

        // Top bar icons and actions
        val buttonIcons = listOf(
            R.drawable.qr_code,
            R.drawable.camera,
            R.drawable.search,
            R.drawable.dots
        )

        val buttonClickActions = listOf(
            { Toast.makeText(context, "Scan QR Code", Toast.LENGTH_SHORT).show() },
            { Toast.makeText(context, "Open settings and allow camera to take photos", Toast.LENGTH_SHORT).show() },
            { Toast.makeText(context, "Search bar", Toast.LENGTH_SHORT).show() },
            { Toast.makeText(context, "Menu drop down feature is not available", Toast.LENGTH_SHORT).show() }
        )

        // Bottom bar icons and actions
        val bottomButtons = listOf(
            R.drawable.chats,
            R.drawable.updates,
            R.drawable.community,
            R.drawable.call
        )

        val bottomButtonActions = listOf(
            { Toast.makeText(context, "99 messages from 7 chats", Toast.LENGTH_SHORT).show() },
            { Toast.makeText(context, "You are on this page", Toast.LENGTH_SHORT).show() },
            { Toast.makeText(context, "Join new communities", Toast.LENGTH_SHORT).show() },
            { Toast.makeText(context, "Calls are not allowed ", Toast.LENGTH_SHORT).show() }
        )

        // Scaffold to organize layout
        Scaffold(
            topBar = {
                TopBar(
                    title = stringResource(R.string.title),
                    buttonIcons = buttonIcons,
                    buttonClickActions = buttonClickActions
                )
            },
            bottomBar = {
                BottomBar(
                    bottomButtons = bottomButtons,
                    bottomButtonActions = bottomButtonActions
                )
            }
        )
        { innerPadding ->
            NameList(
                nameList = namesList,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }

    @Composable
    fun NameList(nameList: List<Names>, modifier: Modifier = Modifier) {
        val backgroundColor = if (isSystemInDarkTheme()) Color.Black else Color.White

        LazyColumn(
            modifier = modifier // Use the passed modifier
                .fillMaxSize()
                .background(backgroundColor)
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                StatusTextRow()
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                StatusImageRow()
                Spacer(modifier = Modifier.height(24.dp))
            }
            item {
                RecentUpdatesTextRow()
                Spacer(modifier = Modifier.height(24.dp))
            }

            // Use the provided nameList directly
            items(nameList) { name ->
                RecentUpdateItem(
                    names = name,
                    modifier = Modifier.padding(8.dp) // Use padding here
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }


    @Composable
    fun RecentUpdateItem(names: Names, modifier: Modifier = Modifier) {
        val backgroundColor = if (isSystemInDarkTheme()) Color.DarkGray else Color.White
        val iconColor = if (isSystemInDarkTheme()) Color.White else Color.Black
        val textColor = if (isSystemInDarkTheme()) Color.White else Color.Gray
        val imageColor = if (isSystemInDarkTheme()) Color.Gray else Color.Black

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = names.imageResourceId),
                contentDescription = stringResource(id = names.stringResourceId),
                modifier = Modifier
                    .size(50.dp),
                colorFilter = ColorFilter.tint(imageColor)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(id = names.stringResourceId),
                    color = iconColor, // Dynamic text color
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(id = names.timeResourceId),
                    color = textColor // Dynamic text color
                )
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
