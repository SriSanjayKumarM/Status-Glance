package com.demo.statusglance.mystatus

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color // Correct import
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.statusglance.R

@Composable
fun StatusTextRow() {
    // Row for the "Status" text
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        val textColor = if (isSystemInDarkTheme()) Color.White else Color.Black
        Text(
            text = "Status",
            style = TextStyle(fontSize = 24.sp),
            color = textColor,
            modifier = Modifier.padding(start = 24.dp)
        )
    }
}

@Composable
fun StatusImageRow() {
    // Row for the IconButton
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .size(75.dp)  // Size of the profile picture box
                .background(
                    MaterialTheme.colorScheme.surface,
                    shape = CircleShape
                ) // Using CircleShape for circular background
        ) {
            Image(
                painter = painterResource(R.drawable.captainamericadp),
                contentDescription = "My Status",
                modifier = Modifier
                    .size(75.dp)
                    .align(Alignment.Center), // Center the profile image within the Box
            )
            Image(
                painter = painterResource(R.drawable.plus),
                contentDescription = "Add Status",
                modifier = Modifier
                    .size(25.dp)
                    .align(Alignment.BottomEnd) // Position for the plus image at the bottom end
            )
        }
        AddStatus()
    }
}

@Composable
fun AddStatus() {
    val context = LocalContext.current
    val textColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    // Box for the clickable area
    Box(
        modifier = Modifier
            .fillMaxWidth() // Fill the width
            .padding(16.dp) // Padding around the Box
            .clickable {
                Toast.makeText(context, "Add your status!", Toast.LENGTH_SHORT).show()
            }
    ) {
        // Column for the status texts
        Column(
            modifier = Modifier.padding(16.dp), // Padding inside the Box for the texts
            verticalArrangement = Arrangement.Center, // Center the text vertically
            horizontalAlignment = Alignment.Start // Align text to the start
        ) {
            Text(
                text = "My Status",
                color = textColor,
                style = TextStyle(fontSize = 20.sp)
            )
            Text(
                text = "Tap to add status update",
                color = textColor,
                style = TextStyle(fontSize = 14.sp)
            )
        }
    }
}
