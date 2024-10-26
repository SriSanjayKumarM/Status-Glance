package com.demo.statusglance.bottombar

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.demo.statusglance.R

@Composable
fun BottomBar(
    bottomButtons: List <Int>,
    bottomButtonActions: List <() -> Unit>,
){
    val iconColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    val highlightColor = Color(0xFF9CCC65)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        // Map over the list of button icons and create IconButtons
        bottomButtons.forEachIndexed() { index, iconRes ->
            IconButton(
                onClick = bottomButtonActions[index],
                modifier = Modifier.size(100.dp),
            ) {
                val tintColor = if (index == 1) highlightColor else iconColor
                Box() {
                    Image(
                        painter = painterResource(iconRes),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp),
                        colorFilter = ColorFilter.tint(tintColor)
                    )
                    if (index == 0) {
                        Image(
                            painter = painterResource(R.drawable.newmsg),
                            contentDescription = "New Messages",
                            modifier = Modifier
                                .size(25.dp)
                                .align(Alignment.TopEnd)
                                .padding(end = 8.dp, top = 3.dp) // Adjust for proper positioning
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(4.dp)) // Adding space between buttons
        }
    }

}