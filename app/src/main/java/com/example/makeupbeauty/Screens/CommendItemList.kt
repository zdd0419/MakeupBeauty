package com.example.makeupbeauty.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.makeupbeauty.CommunityPost.PostActivity
import com.example.makeupbeauty.component.models.ConcernItem

import com.example.makeupbeauty.R
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
@Composable
fun CommendItem(item: ConcernItem, modifier: Modifier = Modifier, onClick:()->Unit = {}) {
    val context = LocalContext.current;
//    val typography = MaterialTheme.typography
    Card(modifier = Modifier
        .clickable { context.startActivity(PostActivity.newIntent(context)) }
        .padding(4.dp))
    {
        Column(
            modifier = modifier
                .fillMaxWidth()
                //.padding(16.dp)
//            .testTag("${item.id}")
        ) {
            val imageModifier = Modifier
                //.height(250.dp)
                .fillMaxWidth()
                .clip(shape = MaterialTheme.shapes.medium)

            Image(
                painter = painterResource(item.imageId),
                modifier = imageModifier,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            //Spacer(Modifier.height(16.dp))
            Text(
                text = item.source,
                modifier = Modifier
                    .padding(8.dp))

            Row(modifier = Modifier
                .padding(8.dp)
                .height(25.dp)) {
                Image(
                    painter = painterResource(id = item.avatarId),
                    contentDescription = "avatar",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(25.dp))

                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = item.name,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically))

                Box(modifier = Modifier.fillMaxWidth()) {
                    Icon(
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = "like",
                        modifier = Modifier
                            .size(25.dp)
                            .padding(4.dp)
                            .align(alignment = Alignment.CenterEnd),
                        tint = Color.Unspecified)
                }

            }

        }
    }
}

