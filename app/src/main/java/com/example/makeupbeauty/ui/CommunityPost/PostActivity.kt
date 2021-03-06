package com.example.makeupbeauty.CommunityPost

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.example.makeupbeauty.ui.Screens.ui.theme.MakeupBeautyTheme
import com.example.makeupbeauty.R
import com.example.makeupbeauty.commodityDetail.productDetailActivity
import com.example.makeupbeauty.component.card.TopLabCards
import com.example.makeupbeauty.component.models.CarouselItem
import com.example.makeupbeauty.component.models.Comment
import com.example.makeupbeauty.ui.Screens.LoadImage
import com.example.makeupbeauty.viewModel.PostViewModel
import com.example.makeupbeauty.viewModel.product_detailViewlModel
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.InternalCoroutinesApi

val commentText = mutableStateOf("")
//val is = remember { mutableStateOf() }

@InternalCoroutinesApi
class PostActivity : ComponentActivity() {
    companion object {
        fun newIntent(context: Context) =
            Intent(context,PostActivity::class.java).apply { putExtra("aaa",true) }
    }



    @ExperimentalComposeUiApi
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        setContent {
            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                        titleContent()
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
                        content()
                    }
                }
            }
        }
    }


}


@ExperimentalPagerApi
@InternalCoroutinesApi
@Composable
fun titleContent() {
    val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
    val item = postViewModel.getPost()
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


@ExperimentalComposeUiApi
@ExperimentalPagerApi
@InternalCoroutinesApi
@Composable
fun imageHeader() {
    var newComment = ""
    val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
    val item = postViewModel.getPost()
    val isFavourite = remember { mutableStateOf(item.isliked) }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column {
        PostImage(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(300.dp, 500.dp)
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


        val commentList = item.commentlist

        if(item.title.contains("??????", true)) {
            val product_detailViewlmodel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<product_detailViewlModel>()
            product_detailViewlmodel.setId(25)
            val context = LocalContext.current
            val intent = Intent(context, productDetailActivity::class.java)
            TopLabCards(labTitle = "??????????????????", labContent = product_detailViewlmodel.getKhItem().title, labImage = painterResource(id = R.drawable.dior1),
                onClick = {
                    ContextCompat.startActivity(context, intent, null)
                },
            )
        }

        Text(

            text = "???"+ commentList.size +"?????????",
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
                url = postViewModel.myAvatar,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(30.dp),
                contentScale = null)

            Spacer(
                Modifier
                    .width(16.dp))

            TextField(
                singleLine = true,
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
                keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Go),
                keyboardActions = KeyboardActions(
                    onGo = {

                        keyboardController?.hide()
                        postViewModel.postComment(
                            item.id,
                            Comment(
                                postViewModel.myAvatar,
                                postViewModel.myName,
                                commentText.value,
                                "",
                                0
                            )
                        )
                        commentText.value = ""
                    }
                )
            )
        }

        Spacer(
            Modifier
                .height(16.dp))

    }
}


@SuppressLint("UnrememberedMutableState")
@ExperimentalComposeUiApi
@ExperimentalPagerApi
@InternalCoroutinesApi
@Composable
fun content() {
    val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
    val item = postViewModel.getPost()
    val commentList = item.commentlist

        LazyColumn(modifier = Modifier) {
            item {
                //HomeHeader()
                imageHeader()
            }
            items(
                items = commentList,
                itemContent = { item -> CommentListItem(item = item)
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
fun CommentListItem(item: Comment) {
    val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
    //val item = postViewModel.getPost()
    Row(modifier = Modifier
        .padding(12.dp)) {
        LoadImage(
            url = postViewModel.myAvatar,
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