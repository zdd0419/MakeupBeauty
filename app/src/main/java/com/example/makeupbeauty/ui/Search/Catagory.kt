package com.example.makeupbeauty.Search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.makeupbeauty.ui.Screens.StaggeredVerticalGrid
import com.example.makeupbeauty.Search.ui.theme.MakeupBeautyTheme
import com.example.makeupbeauty.data.DemoDataProvider



class Catagory : ComponentActivity() {
    companion object{
        fun newIntent(context: Context) =
            Intent(context, Catagory::class.java).apply { putExtra("category",true) }
    }

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
                                    Text(text = "category")
                                },
                                elevation = 0.dp,
                                navigationIcon = {
                                    IconButton(onClick = { onBackPressed() }) {
                                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                                    }
                                },
                                backgroundColor = Color.White
                            )
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