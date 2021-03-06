package com.example.makeupbeauty.ui.CommunityPost

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.example.makeupbeauty.CommunityPost.PostBottomBar
import com.example.makeupbeauty.CommunityPost.PostImage
import com.example.makeupbeauty.ui.Screens.ui.theme.MakeupBeautyTheme
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.models.CarouselItem
import com.example.makeupbeauty.component.models.Comment
import com.example.makeupbeauty.ui.Screens.LoadImage
import com.example.makeupbeauty.viewModel.PostViewModel
import com.example.makeupbeauty.viewModel.PublicProfileViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.InternalCoroutinesApi

val commentText = mutableStateOf("")


class MyPostActivity : ComponentActivity() {
    companion object {
        fun newIntent(context: Context) =
            Intent(context,MyPostActivity::class.java).apply { putExtra("MyPostActivity",true) }
    }

    @ExperimentalComposeUiApi
    @InternalCoroutinesApi
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    title_Content()
                                },
                                elevation = 0.dp,
                                navigationIcon = {
                                    IconButton(onClick = { onBackPressed() }) {
                                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                                    }
                                },
                                backgroundColor = Color.White
                            )
                        },
                        bottomBar = {
                            PostBottomBar(360, 65, 14)
                        }
                    ) {
                        PostContent()
                    }
                }
            }
        }
    }
}


@Composable
fun title_Content() {
    val publicProfileViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PublicProfileViewModel>()
    val item = publicProfileViewModel.getPost()
    LoadImage(
        url = item.avator,
        modifier = Modifier
            .padding(top = 12.dp, bottom = 12.dp, end = 12.dp)
            .clip(CircleShape)
            .size(40.dp),
        contentScale = null)

    Text(text = item.author)
    Box(modifier = Modifier.fillMaxWidth()){
        OutlinedButton(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(//??????
                topStart = 10.dp,
                topEnd = 10.dp,
                bottomStart = 10.dp,
                bottomEnd = 10.dp),
            border = BorderStroke(1.dp, Color.Red),
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = Color.Transparent,
                contentColor = Color.Red
            ),
            modifier = Modifier
                .width(80.dp)
                .height(35.dp)
                .align(Alignment.TopEnd)
                .padding(end = 8.dp)
        ){
            Text(text = "??????")         //??????
        }
    }
}


@ExperimentalPagerApi
@InternalCoroutinesApi
@Composable
fun image_Header() {
    var newComment = ""
    val publicProfileViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PublicProfileViewModel>()
    val item = publicProfileViewModel.getPost()

    Column() {
        PostImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(bottom = 4.dp),
            item.imagelist
        )
        Spacer(
            Modifier
                .height(8.dp))
        Text(
            text = item.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Black,
            modifier = Modifier
                .padding(8.dp))
        Text(
            text = item.content,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(8.dp))

        Spacer(
            Modifier
                .height(8.dp))


        //????????????????????????
        Row(modifier = Modifier
            .padding(8.dp)
        ){
            Box(modifier = Modifier.fillMaxHeight()){
                Text(
                    text = item.time,
                    color = Color.LightGray,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Box(modifier = Modifier.fillMaxWidth()){
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(//??????
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp),
                    border = BorderStroke(2.dp, Color.LightGray),
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .height(30.dp)
                        .align(Alignment.TopEnd)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.SentimentVeryDissatisfied,
                        tint = Color.LightGray,
                        contentDescription = null,
                        modifier = Modifier
                        //.align(Alignment.End)
                    )
                    Text(
                        text = "?????????",
                        fontSize = 10.sp,
                        color = Color.LightGray
                    )
                }
            }


            Spacer(
                Modifier
                    .height(8.dp))
        }

        Spacer(
            Modifier
                .height(16.dp))
        Divider(color = Color.LightGray, thickness = 0.8f.dp)
        Spacer(
            Modifier
                .height(8.dp))

        Text(
            text = "???"+ item.commentlist.size +"?????????",
            fontSize = 15.sp,
            color = Color.LightGray,
            modifier = Modifier.padding(8.dp)
        )
        Spacer(
            Modifier
                .height(8.dp))


        //?????????
        Row(modifier = Modifier
            .wrapContentHeight()
            .padding(12.dp)){
            LoadImage(
                url = publicProfileViewModel.myAvatar,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(30.dp),
                contentScale = null)

            Spacer(
                Modifier
                    .width(16.dp))

            TextField(
                value = commentText.value,
                onValueChange = { commentText.value = it },
                placeholder = {
                    Text(text = "?????????????????????????????????~", color = Color(0xFF666666), fontSize = 12.sp)
                },
                modifier = Modifier
                    .height(height = 45.dp)
                    .fillMaxWidth(),
                shape = CircleShape,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFFDDDDDD),
                    cursorColor = Color.Black,
                    disabledLabelColor = Color(0xFFDDDDDD),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
            )
        }

        Spacer(
            Modifier
                .height(16.dp))

    }
}



@ExperimentalPagerApi
@InternalCoroutinesApi
@Composable
fun PostContent() {
    val publicProfileViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PublicProfileViewModel>()
    val item = publicProfileViewModel.getPost()
    val list = item.commentlist

    LazyColumn(modifier = Modifier) {
        item {
            //HomeHeader()
            image_Header()
        }
        items(
            items = list,
            itemContent = { item -> MyPostListItem(item = item)
                Spacer(
                    Modifier
                        .height(10.dp))
                Divider(color = Color.LightGray, thickness = 0.8f.dp)
                Spacer(
                    Modifier
                        .height(8.dp))
            }
        )
        item {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)) {
                Text(
                    text = "- THE END -",
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}


@InternalCoroutinesApi
@Composable
fun MyPostListItem(item: Comment) {
    val publicProfileViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PublicProfileViewModel>()
    //val item = postViewModel.getPost()
    Row(modifier = Modifier
        .padding(12.dp)) {
        LoadImage(
            url = publicProfileViewModel.myAvatar,
            modifier = Modifier
                .clip(CircleShape)
                .size(35.dp),
            contentScale = null)

        Spacer(
            Modifier
                .width(12.dp))

        Column() {
            Text(
                item.title,
                color = Color.LightGray,
                fontSize = 14.sp
            )
            Spacer(
                Modifier
                    .height(4.dp))


            Row() {
                Text(
                    item.content
                )
                Box() {
                    Text(
                        item.time,
                        color = Color.LightGray,
                        fontSize = 12.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

            }

        }


        Box(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.align(Alignment.TopEnd)) {
                Icon(
                    Icons.Outlined.FavoriteBorder,
                    contentDescription = "",
                    modifier = Modifier
                        .clickable { }
                )
                Text(text = item.likeNum.toString())
            }

        }

    }
}


@InternalCoroutinesApi
@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MakeupBeautyTheme {
        //PostContent()
    }
}