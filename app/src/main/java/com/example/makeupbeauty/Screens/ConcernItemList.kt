package com.example.makeupbeauty.Screens

//import com.example.makeupbeauty.component.models.RecommendItem

import android.content.Intent
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.makeupbeauty.CommunityPost.PostContent
import com.example.makeupbeauty.MainActivity
import com.example.makeupbeauty.component.models.ConcernItem
import com.example.makeupbeauty.R
import com.example.makeupbeauty.CommunityPost.PostActivity
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
@Composable
fun ConcernItem(item: ConcernItem, modifier: Modifier = Modifier) {
//    val typography = MaterialTheme.typography
    val context = LocalContext.current;
    Card(modifier = Modifier
        .clickable { context.startActivity(PostActivity.newIntent(context)) }
        .padding(4.dp))
    {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
//            .testTag("${item.id}")
        ) {
            Row() {
                Image(
                    painter = painterResource(id = item.avatarId),
                    contentDescription = "avatar",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(45.dp))

                Text(text = item.name, modifier = Modifier.padding(8.dp))
            }

            Spacer(Modifier.height(16.dp))

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

            Box(modifier = Modifier.align(alignment = Alignment.End)) {
                Row() {
                    Icon(
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = "like",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(4.dp),
                        tint = Color.Unspecified)
                    Icon(
                        painter = painterResource(id = R.drawable.collect),
                        contentDescription = "collect",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(4.dp),
                        tint = Color.Unspecified)
                    Icon(
                        painter = painterResource(id = R.drawable.comment),
                        contentDescription = "comment",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(4.dp),
                        tint = Color.Unspecified)

                }
            }


            Spacer(Modifier.height(16.dp))
            Text(text = item.source)
        }
    }

}

@InternalCoroutinesApi
@Composable
fun toPost() {
    val navController = rememberNavController()
    navController.navigate("PostActivity")
}