package com.example.makeupbeauty.ui.Screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.makeupbeauty.viewModel.PublicProfileViewModel

class PublicProfileScreen : ComponentActivity(){
    companion object{
        fun newIntent(context: Context) =
            Intent(context, PublicProfileScreen::class.java).apply { putExtra("PublicProfileScreen",true) }
    }

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

@Composable
fun Public_ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Column(Modifier.background(Color.White)) {
            UserHead(R.drawable.avatar, "test longest", "1", 0, 0)
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

@Composable
fun getUserPost() {
    val ProfileViewModel: PublicProfileViewModel = viewModel()
//    val list = ProfileViewModel.PublicProfileItemList

    Card {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
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


//            item {
//                list.forEach {
//                    PublicProfileItem(item = it)
//                }
//            }
        }
    }
}


@Composable
fun PublicProfileItem(item: PublicProfileItem, modifier: Modifier = Modifier, onClick:()->Unit = {}) {
//    val typography = MaterialTheme.typography
    Card(modifier = Modifier
        .clickable { onClick }
        .padding(4.dp))
    {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
//            .testTag("${item.id}")
        ) {
            val imageModifier = Modifier
                .height(100.dp)
                .width(100.dp)
//                .fillMaxWidth()
                .clip(shape = MaterialTheme.shapes.medium)

            Row() {
                Column() {
                    Image(
                        painter = painterResource(item.imageId),
                        modifier = imageModifier,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }

                Column() {
                    Row() {
                        Text(
                            text = item.source,
                            modifier = Modifier
                                .padding(8.dp))
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    Row(modifier = Modifier
                        .padding(8.dp)
                        .height(25.dp)
                    )
                    {
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
                            val checkedState = remember { mutableStateOf(false) }

                            IconToggleButton(
                                modifier = Modifier.size(30.dp)
                                            .padding(4.dp)
                                            .align(alignment = Alignment.CenterEnd),
                                checked = checkedState.value,
                                onCheckedChange = {
                                    checkedState.value = it
                                },
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Favorite,
                                    contentDescription = "Favorite",
                                    tint = if (checkedState.value) {
                                        Color.Red
                                    } else {
                                        Color.Gray
                                    }
                                )
                            }
                        }

                    }

                }
                //Spacer(Modifier.height(16.dp))

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PublicProfileScreenPreview() {
    PublicProfileScreen()
}