package com.example.makeupbeauty.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.ui.theme.black
import com.example.makeupbeauty.ui.theme.eveningGlory

import com.example.makeupbeauty.ui.theme.orange


@Composable
fun TopAppBarWithBack(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(3.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {

            IconButton(onClick = { onBackClick() }) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = ""
                )
            }

        val isFavourite = remember { mutableStateOf(true) }
        IconToggleButton(
            checked = isFavourite.value,
            onCheckedChange = { isFavourite.value = !isFavourite.value }
        ) {
            if (isFavourite.value) {
                Icon(
//                imageVector = Icons.Filled.Favorite,
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = null,
//                    modifier = modifier,
                    tint = orange
                )
            } else {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
//                    modifier = modifier
                )
            }
        }

        }
}


@Composable
fun TopBarWithBack(title: String, onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onBackClick() }) {
            Icon(
                modifier = Modifier.size(32.dp, 32.dp),
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "",
                tint = black
            )
        }

        Text(
            text = title,
            color = eveningGlory,
            modifier = Modifier.padding(start = 16.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
        )

        IconButton(onClick = {  }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "",
                tint = black
            )
        }

    }

}