package com.demo.statusglance.recentupdates

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.statusglance.R

@Composable
fun RecentUpdatesTextRow(){
    // Row for the "Recent Updates" text
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "Recent Updates",
            style = androidx.compose.ui.text.TextStyle(fontSize = 16.sp),
            modifier = Modifier.padding(start = 16.dp),
        )
    }
}
/*
@Composable
fun RecentUpdatesImageRow() {

    // Row for the IconButton
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp),
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
                painter = painterResource(R.drawable.status),
                contentDescription = "Recent Status",
                modifier = Modifier
                    .size(75.dp)
                    .align(Alignment.Center), // Center the profile image within the Box
            )
        }

        RecentUpdates()
    }
}


@Composable
fun RecentUpdates() {
    val context = LocalContext.current

    IconButton(
        onClick = {
            Toast.makeText(context, "View this status", Toast.LENGTH_SHORT).show()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .size(80.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "My Status",
                style = TextStyle(fontSize = 24.sp),
            )
            Text(
                text = "Tap to add status update",
                style = TextStyle(fontSize = 16.sp),
            )
        }

    }
}
*/
