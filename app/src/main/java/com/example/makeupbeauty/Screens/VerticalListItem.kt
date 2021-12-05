package com.example.makeupbeauty.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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

        Image(
            painter = painterResource(item.imageId),
            modifier = imageModifier,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = item.title,
//            style = typography.titleLarge
        )
        Text(
            text = item.subtitle,
//            style = typography.bodyMedium
        )

        Text(
            text = item.source,
//            style = typography.titleSmall
        )
    }
}

