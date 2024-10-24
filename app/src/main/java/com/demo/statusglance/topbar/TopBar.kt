package com.demo.statusglance.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    buttonIcons: List<Int> // List of drawable resources for the buttons
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    style = androidx.compose.ui.text.TextStyle(fontSize = 24.sp),
                    modifier = Modifier.weight(1f)
                )

                // Map over the list of button icons and create IconButtons
                buttonIcons.forEach { iconRes ->
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(36.dp),
                    ) {
                        Image(
                            painter = painterResource(iconRes),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp)) // Adding space between buttons
                }
            }
        }
    )
}
