package com.example.makeupbeauty.Topbars

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChatTopBar(title: String, onBack: (() -> Unit)? = null) {
    Box(modifier = Modifier
        .background(Color.White)
        .fillMaxWidth()
    ){
        Row(
            Modifier.height(48.dp)
        ) {
            if (onBack != null){
                Icon(
                    Icons.Default.Menu,
                    contentDescription = "",
                    Modifier
                        .clickable ( onClick = onBack )
                        .align(Alignment.CenterVertically)
                        .size(36.dp)
                        .padding(8.dp),
                    tint = Color.Gray
                )
            }

            Spacer(modifier = Modifier.weight(1f))
//            val viewModel : WeViewModel = WeViewModel()
        }

        Text(
            text = title,
            Modifier.align(Alignment.Center),
            Color.Black
        )
    }

}