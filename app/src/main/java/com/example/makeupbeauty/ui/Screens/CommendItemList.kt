package com.example.makeupbeauty.ui.Screens

import android.content.Intent
import android.util.Log
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androidisland.vita.VitaOwner
import com.example.makeupbeauty.CommunityPost.PostActivity
import com.example.makeupbeauty.component.models.ConcernItem

import com.example.makeupbeauty.R
import com.example.makeupbeauty.data.notesData
import com.example.makeupbeauty.data.productData
import com.example.makeupbeauty.viewModel.PostViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import com.androidisland.vita.vita

@InternalCoroutinesApi
@Composable
fun turnActivity() {
    val context = LocalContext.current;
    val postViewModel: PostViewModel = viewModel()
    var intent: Intent = Intent(context, PostActivity::class.java)
    //intent.putExtra("viewModel", postViewModel)
    startActivity(context, intent, null)
}


@InternalCoroutinesApi
@Composable
fun CommendItem(item: notesData, modifier: Modifier = Modifier, onClick:()->Unit = {}) {
    val context = LocalContext.current;
    val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
//    val typography = MaterialTheme.typography
    Card(modifier = Modifier
        .clickable {
            postViewModel.changeRecommend(item.id-1)
            //Log.e("debug", postViewModel.option.toString())
            context.startActivity(PostActivity.newIntent(context)) }
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
                .heightIn(100.dp, 200.dp)

            LoadImage(
                url = item.imagelist[0],
                modifier = imageModifier,
                contentScale = ContentScale.Crop)


            //Spacer(Modifier.height(16.dp))
            Text(
                text = item.title,
                modifier = Modifier
                    .padding(8.dp))

            Row(modifier = Modifier
                .padding(8.dp)
                .height(25.dp)) {

                LoadImage(
                    url = item.avator,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(25.dp),
                    contentScale = null)


                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = item.author,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically))

                Box(modifier = Modifier.fillMaxWidth()) {
                    Icon(
                        imageVector = if(item.isliked==0) Icons.Outlined.FavoriteBorder else Icons.Outlined.Favorite,
                        contentDescription = "like",
                        modifier = Modifier
                            .size(25.dp)
                            .padding(4.dp)
                            .align(alignment = Alignment.CenterEnd)
                            .clickable { postViewModel.clicklike(item.id) }
                        ,
                        tint = Color.Unspecified)
//                    Icon(
//                        painter = painterResource(id = R.drawable.like),
//                        contentDescription = "like",
//                        modifier = Modifier
//                            .size(25.dp)
//                            .padding(4.dp)
//                            .align(alignment = Alignment.CenterEnd),
//                        tint = Color.Unspecified)
                }

            }

        }
    }
}



