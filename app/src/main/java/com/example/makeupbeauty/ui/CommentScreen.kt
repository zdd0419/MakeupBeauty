package com.example.makeupbeauty.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.makeupbeauty.notes.ui.theme.MakeupBeautyTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*

import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.TopBarWithBack
import com.example.makeupbeauty.notes.data.Comment
import com.example.makeupbeauty.notes.data.Like_and_Attention
import com.example.makeupbeauty.notes.data.NotesDateProvoder
import com.example.makeupbeauty.notes.data.newAttention
import com.example.makeupbeauty.ui.theme.*


class CommentScreen : ComponentActivity() {
    companion object {
        fun newIntent(context: Context) =
            Intent(context, CommentScreen::class.java).apply { putExtra("CommentScreen", true) }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Comment_Screen()
                }
            }
        }
    }
}


@Preview
@Composable
fun Comment_Screen() {
    com.example.makeupbeauty.ui.theme.MakeupBeautyTheme {
        Scaffold(
            topBar = {
                TopBarWithBack(
                    title = "评论和@",
                    onBackClick = {

                    },
                )
            },
            backgroundColor = cottonBall,
            content = {
                Card_Comment()
            })
    }
}

@Composable
fun Card_Comment(){
    val list = remember { NotesDateProvoder.CommentList }
    LazyColumn {
        items(
            items = list,
            itemContent = { item -> List_CommentItem(item = item)
            }
        )
    }
}



@Composable
fun List_CommentItem(item: Comment, modifier: Modifier = Modifier) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp, 24.dp, 0.dp, 8.dp)
                .height(height = 80.dp), Alignment.CenterStart
        ) {
            Row(modifier = Modifier) {
                Image(
                    painter = painterResource(id = item.imageID),
                    contentDescription = "avatar",
                    modifier = Modifier
                        .padding(12.dp)
                        .clip(CircleShape)
                        .size(60.dp)
                )

                Column() {
                    Spacer(
                        Modifier
                            .height(12.dp)
                    )
                    Row(modifier = Modifier.padding(horizontal = 4.dp), Arrangement.Center) {
                        Text(text = item.name, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
                        Spacer(modifier = Modifier.padding(4.dp))
                    }
                    Spacer(
                        Modifier
                            .height(8.dp)
                    )

                    Text(text = "评论了你： " + item.title, fontSize = 10.sp, color = grey)
                }
                Spacer(modifier = Modifier.padding(90.dp))

                Image(
                    painter = painterResource(id = R.drawable.khcard),
                    contentDescription = "avatar",
                    modifier = Modifier
                        .padding(12.dp)
                        .size(60.dp)
                )
            }
//
            //            Text(text = "12:17", modifier = Modifier.padding( start=320.dp,top=1.dp),color= grey)

        }
    }
}