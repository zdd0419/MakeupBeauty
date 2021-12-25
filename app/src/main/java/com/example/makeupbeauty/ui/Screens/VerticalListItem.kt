package com.example.makeupbeauty.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.makeupbeauty.component.models.Item


@Composable
fun VerticalListItem(item: Item, modifier: Modifier = Modifier) {
//    val typography = MaterialTheme.typography
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
//            .testTag("${item.id}")
    ) {

        val imageModifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.medium)

//        Image(
//            painter = rememberImagePainter(),
////            modifier = imageModifier,
////            contentDescription = null,
////            contentScale = ContentScale.Crop
//        )
        Image(
            modifier = imageModifier,
            painter = rememberImagePainter(item.imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.height(16.dp))
        Text(
            text = item.title,
            fontSize = 20.sp
//            style = typography.titleLarge
        )
        Text(
            text = item.subtitle,
            color = Color.Gray
//            style = typography.bodyMedium
        )

//        Text(
//            text = item.source,
////            style = typography.titleSmall
//        )
    }
}

