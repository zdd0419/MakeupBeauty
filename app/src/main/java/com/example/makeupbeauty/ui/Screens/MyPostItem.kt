package com.example.makeupbeauty.ui.Screens

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star

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
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androidisland.vita.VitaOwner
import com.example.makeupbeauty.CommunityPost.PostActivity

import com.example.makeupbeauty.R
import com.example.makeupbeauty.data.notesData
import com.example.makeupbeauty.data.productData
import com.example.makeupbeauty.viewModel.PostViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import com.androidisland.vita.vita
import com.example.makeupbeauty.ui.CommunityPost.MyPostActivity
import com.example.makeupbeauty.viewModel.PublicProfileViewModel

//@InternalCoroutinesApi
//@Composable
//fun turnActivity() {
//    val context = LocalContext.current;
//    val postViewModel: PostViewModel = viewModel()
//    var intent: Intent = Intent(context, PostActivity::class.java)
//    //intent.putExtra("viewModel", postViewModel)
//    startActivity(context, intent, null)
//}


@InternalCoroutinesApi
@Composable
fun MyPostItem(item: notesData, modifier: Modifier = Modifier, onClick:()->Unit = {}) {
    val checkedState = remember { mutableStateOf(false) }
    val context = LocalContext.current;
    val publicProfileViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PublicProfileViewModel>()
//    val typography = MaterialTheme.typography
    Card(modifier = Modifier
        .clickable {
            publicProfileViewModel.changeRecommend(item.id - 1)
            //Log.e("debug", postViewModel.option.toString())
            context.startActivity(MyPostActivity.newIntent(context))
        }
        .padding(4.dp))
    {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = modifier.padding(16.dp)
//            .testTag("${item.id}")
            ) {
                val imageModifier = Modifier
                    .clip(shape = MaterialTheme.shapes.medium)
                    .height(100.dp)
                    .width(100.dp)

                LoadImage(
                    url = item.imagelist[0],
                    modifier = imageModifier,
                    contentScale = ContentScale.Crop)
            }

            Column() {
                Spacer(modifier = Modifier.height(10.dp))

                Row() {
                    Text(
                        text = item.title,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(8.dp))
                }

                Spacer(modifier = Modifier.height(25.dp))

                Row(modifier = Modifier
                    .padding(8.dp)
                    .height(25.dp)) {
                    LoadImage(
                        url = item.avator,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(30.dp),
                        contentScale = null)

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = item.author,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically))

                    Spacer(modifier = Modifier.width(140.dp))

                    Box() {
                        IconToggleButton(
                            checked = (checkedState.value),
                            onCheckedChange = {
                                checkedState.value = !checkedState.value
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Favorite",
                                tint = if (checkedState.value) {
                                    Color.Red
                                } else {
                                    Color.Gray
                                },
                            )
                        }
                    }

                }
            }
        }

    }
}