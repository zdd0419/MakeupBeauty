package com.example.makeupbeauty.Search

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.makeupbeauty.CommunityPost.PostActivity
import com.example.makeupbeauty.Screens.StaggeredVerticalGrid
import com.example.makeupbeauty.Search.ui.theme.MakeupBeautyTheme
import com.example.makeupbeauty.data.DemoDataProvider

class Catagory : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            categoryTopBar(
                                category = "口红",
                                onClick = {onBackPressed()})
                        }

                    ){
                        showGoodsInCategory()
                    }
                }
            }
        }
    }
}


@Composable
fun showGoodsInCategory() {
    val list = remember { DemoDataProvider.goodsList }
    LazyColumn() {
        item {
            StaggeredVerticalGrid(maxColumnWidth = 250.dp) {
                list.forEach {
                    GoodsItem(item = it)
                }
            }
        }
    }
}

@Composable
fun categoryTopBar(category: String, onClick:()->Unit = {}) {
    TopAppBar(
        title = {
            Text(text = category)
        },
        elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = { onClick }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        },
        backgroundColor = Color.White
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    MakeupBeautyTheme {
        //Greeting("Android")
    }
}