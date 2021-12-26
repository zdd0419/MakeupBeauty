package com.example.makeupbeauty.ui.Screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
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
import androidx.compose.material.icons.filled.Favorite
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.models.ConcernItem
import com.example.makeupbeauty.component.models.PublicProfileItem
import com.example.makeupbeauty.data.ConcernDataProvider
import com.example.makeupbeauty.ui.theme.MakeupBeautyTheme
import com.example.makeupbeauty.viewModel.ChatViewModel
import com.example.makeupbeauty.viewModel.PostViewModel
import com.example.makeupbeauty.viewModel.PublicProfileViewModel
import kotlinx.coroutines.InternalCoroutinesApi

class PublicProfileScreen : ComponentActivity(){
    companion object{
        fun newIntent(context: Context) =
            Intent(context, PublicProfileScreen::class.java).apply { putExtra("PublicProfileScreen",true) }
    }

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            MakeupBeautyTheme{
                Surface(color = MaterialTheme.colors.background){
                    Public_ProfileScreen()
                }
            }
        }
    }
}

@InternalCoroutinesApi
@Composable
fun Public_ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(Modifier.background(Color.White)) {
            getUserPost()
        }
    }
}

//头像部分
@Composable
fun UserHead(imageid: Int, name: String, vip: String, prefer: Int, fans: Int) {
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp, 24.dp, 0.dp, 8.dp)
        .height(height = 170.dp),
//        Alignment.CenterStart
    ) {
        item{
            Row(modifier = Modifier) {
                Column() {
                    Image(
                        painter = painterResource(id = imageid),
                        contentDescription = "avatar",
                        modifier = Modifier
                            .padding(12.dp)
                            .clip(CircleShape)
                            .size(80.dp))
                }

                Column() {
                    Spacer(
                        Modifier
                            .height(38.dp)
                    )
                    Row(modifier = Modifier.padding(horizontal = 4.dp)) {
                            Text(text = "关注: "+prefer.toString(), fontSize = 17.sp)
                            Spacer(modifier = Modifier.padding(16.dp))
                            Text(text = "粉丝: "+fans.toString(), fontSize = 17.sp)

                    }
                }
                val context = LocalContext.current;
                Column() {
                    Row(modifier = Modifier.fillMaxWidth()){
                        OutlinedButton(
                            onClick = { context.startActivity(ChatListScreen.newIntent(context)) },
                            shape = RoundedCornerShape(//圆角
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
                                .width(70.dp)
                                .height(30.dp)
//                                .align(Alignment.TopEnd)
                                .padding(end = 8.dp)
                        ){
                            Text(text = "消息", fontSize = 12.sp)
                        }

                        OutlinedButton(
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(//圆角
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
                                .width(70.dp)
                                .height(30.dp)
//                                .align(Alignment.TopEnd)
                                .padding(end = 8.dp)
                        ){
                            Text(text = "关注", fontSize = 12.sp)
                        }
                    }

                }
            }
        }
        item{
            Row(modifier = Modifier) {
                Row(modifier = Modifier.padding(horizontal = 4.dp), Arrangement.Center) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(text = name, fontWeight = FontWeight.ExtraBold, fontSize = 25.sp)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = "vip $vip",color = Color.Cyan, textAlign = TextAlign.Center, fontSize = 17.sp)
                }
            }
        }

    }
}


@InternalCoroutinesApi
@Composable
fun getUserPost() {
    val publicProfileViewModel: PublicProfileViewModel = viewModel()
    val list = publicProfileViewModel.My_Post

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        item{
            UserHead(R.drawable.avatar, "test longest", "1", 0, 0)
        }
        item{
            Divider()
        }

        item{
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "主页", fontSize = 20.sp, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(15.dp))
        }

        item{
            Divider()
        }

        item {
            list.forEach {
                MyPostItem(item = it)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PublicProfileScreenPreview() {
    PublicProfileScreen()
}