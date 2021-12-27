package com.example.makeupbeauty.ui.Screens

//import com.example.makeupbeauty.component.models.RecommendItem

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.example.makeupbeauty.component.models.ConcernItem
import com.example.makeupbeauty.R
import com.example.makeupbeauty.CommunityPost.PostActivity
import com.example.makeupbeauty.data.notesData
import com.example.makeupbeauty.viewModel.PostViewModel
import com.google.accompanist.coil.rememberCoilPainter
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
@Composable
fun ConcernItem(item: notesData, modifier: Modifier = Modifier) {
//    val typography = MaterialTheme.typography
    val isFavourite = remember { mutableStateOf(item.isliked) }
    val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
    val context = LocalContext.current;
//    if(postViewModel.isFavorited != 3)
//    {
//        isFavourite.value = postV
//        postViewModel.isFavorited = 3
//    }

    Card(modifier = Modifier
        .clickable {
            postViewModel.changeConcern(item.id)
            context.startActivity(PostActivity.newIntent(context))
        }
        .padding(4.dp))
    {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
//            .testTag("${item.id}")
        ) {
            Row() {
                LoadImage(
                    url = item.avator,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(45.dp),
                    null)

                Text(text = item.author, modifier = Modifier.padding(8.dp))
            }

            Spacer(Modifier.height(16.dp))

            val imageModifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
                .clip(shape = MaterialTheme.shapes.medium)

            LoadImage(
                url = item.imagelist[0],
                modifier = imageModifier,
                ContentScale.Crop
            )

            Spacer(Modifier.height(16.dp))

            Box(modifier = Modifier.align(alignment = Alignment.End)) {
                Row() {
                    Icon(
                        imageVector = if(isFavourite.value.value==0) Icons.Outlined.FavoriteBorder else Icons.Outlined.Favorite,
                        contentDescription = "like",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(4.dp)
                            .clickable {
                                postViewModel.clicklike(item.id)
                                       }
                            ,
                        tint = if(isFavourite.value.value==0) Color.Unspecified else Color.Red)
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
            Text(text = item.title)
        }
    }

}

@InternalCoroutinesApi
@Composable
fun toPost() {
    val navController = rememberNavController()
    navController.navigate("PostActivity")
}


@Composable
fun LoadImage(url: String, modifier: Modifier, contentScale: ContentScale?) {
    val painter = rememberCoilPainter(Uri.parse(url))
    if (contentScale != null) {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = modifier,
            contentScale = contentScale
        )
    } else {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = modifier
        )
    }
}