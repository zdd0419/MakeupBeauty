package com.example.makeupbeauty.CommunityPost

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.example.makeupbeauty.viewModel.PostViewModel


@Composable
fun PostBottomBar(like:Int, collect: Int, comment: Int) {
    val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
    var newComment = ""
    val item = postViewModel.getPost()
    Log.e("bottombar",item.id.toString())
    val isFavourite = remember { mutableStateOf(item.isliked) }
    val isCollected = remember { mutableStateOf(item.iscollected) }

    BottomAppBar (
        backgroundColor = Color.White
    ){
        TextField(
            value = commentText.value,
            onValueChange = { commentText.value = it },
            placeholder = {
                Text(text = "说点什么...", color = Color(0xFF666666), fontSize = 12.sp)
            },
            modifier = Modifier
                .height(height = 45.dp)
                .width(150.dp),
            shape = CircleShape,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFFDDDDDD),
                cursorColor = Color.Black,
                disabledLabelColor = Color(0xFFDDDDDD),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )

        )

        //点赞
        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = {
            isFavourite.value = 1-isFavourite.value
            postViewModel.clicklike(item.id)
            postViewModel.isFavorited = isFavourite.value
            Log.e("fav", postViewModel.isFavorited.toString()) })
        {
            Icon(
                if(isFavourite.value == 0) Icons.Filled.FavoriteBorder else Icons.Filled.Favorite,
                contentDescription = null,
                tint =if(isFavourite.value == 0)Color.Unspecified else Color.Red,
                modifier = Modifier.clickable {

                }
            )
        }
        Text(text = like.toString())

        //收藏
        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = {
            isCollected.value = 1-isCollected.value
            postViewModel.clickcollect(item.id)

        }) {
            Icon(
                if(isCollected.value == 0) Icons.Filled.StarOutline else Icons.Filled.Star,
                contentDescription = null,
                tint = if(isCollected.value == 0) Color.Unspecified else Color(0xfffbb957)
            )
        }
        Text(text = collect.toString())

        //评论
        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = { }) {
            Icon(Icons.Filled.ChatBubbleOutline, contentDescription = null)
        }
        Text(text = comment.toString())
    }
}