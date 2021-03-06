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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.KeyboardArrowRight

import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.example.makeupbeauty.R
import com.example.makeupbeauty.commodityDetail.shoppingCarActivity
import com.example.makeupbeauty.component.TopBarWithBack
import com.example.makeupbeauty.notes.data.NotesDateProvoder
import com.example.makeupbeauty.notes.data.notes
import com.example.makeupbeauty.ui.Screens.CommendItem
import com.example.makeupbeauty.ui.Screens.NotesItem
import com.example.makeupbeauty.ui.Screens.StaggeredVerticalGrid
import com.example.makeupbeauty.ui.theme.*
import com.example.makeupbeauty.viewModel.PostViewModel
import kotlinx.coroutines.InternalCoroutinesApi

class MynotesActivity : ComponentActivity() {
    companion object {
        fun newIntent(context: Context) =
            Intent(context, MynotesActivity::class.java).apply { putExtra("mYNOTES", true) }
    }
    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Mynotes()
                }
            }
        }
    }
}



@InternalCoroutinesApi
@Preview
@Composable
fun Mynotes() {
    com.example.makeupbeauty.ui.theme.MakeupBeautyTheme {
        Scaffold(
            topBar = {
                TopBarWithBack(
                    title = "????????????",
                    onBackClick = {

                    },
                )
            }, backgroundColor = cottonBall,
            content = {
                Column() {
                    cardNotes()
                    bootton()
                }

            })
    }
}

@InternalCoroutinesApi
@Composable
fun cardNotes(){
    val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
    postViewModel.changePost(1)
    val list = postViewModel.my_post
    //Log.e("", list.toString())
    LazyColumn() {
        item {
            StaggeredVerticalGrid(maxColumnWidth = 250.dp) {
                list.forEach {
                    postViewModel.changePost(it.id)
                    NotesItem(item = it)
                }
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "- THE END -",
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.TopCenter))
            }
        }
    }
}

@Composable
fun MyNotesCard(item:notes){
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
                        .size(60.dp)
                )

                Column() {
                    Spacer(
                        Modifier
                            .height(12.dp)
                    )
                    Row(modifier = Modifier.padding(horizontal = 4.dp), Arrangement.Center) {
                        Text(text = item.title, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
                        Spacer(modifier = Modifier.padding(4.dp))
                    }
                    Spacer(
                        Modifier
                            .height(8.dp)
                    )
                    Row() {
                        Text(text = item.detail, fontSize = 10.sp, color = grey)
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Outlined.KeyboardArrowRight,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(25.dp)
                                    .padding(2.dp),
                                tint = grey,
                            )
                        }
                    }


                }
//                Spacer(modifier = Modifier.padding(end=10.dp))
//
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = null,
                        modifier = Modifier
                            .size(45.dp)
                            .padding(12.dp),
                        tint = red,
                    )
                }


            }







//
            //            Text(text = "12:17", modifier = Modifier.padding( start=320.dp,top=1.dp),color= grey)

        }



    }
}


//????????????
@Composable
fun bootton(){
    Column(modifier=Modifier.fillMaxWidth()) {
        Button(
            onClick = {
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = orange),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 30.dp,
                )
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text(
                text = "??????",
                color = white,
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
        }
        Button(
            onClick = {
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = grey),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 3.dp,
                )
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text(
                text = "??????",
                color = white,
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
        }
    }
}