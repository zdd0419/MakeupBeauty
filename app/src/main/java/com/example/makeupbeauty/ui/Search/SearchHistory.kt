package com.example.makeupbeauty.Search.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.VerticalGrid.VerticalGrid
import com.example.makeupbeauty.component.models.Item
import com.example.makeupbeauty.data.ConcernDataProvider
import com.example.makeupbeauty.data.DemoDataProvider.adlist
import com.example.makeupbeauty.data.DemoDataProvider.discoveryList
import com.example.makeupbeauty.data.DemoDataProvider.historyList


@ExperimentalFoundationApi
@Composable
fun SearchHistory() {
    Card() {
        Column {
            showHistory()
            showDiscovery()
        }
    }
}


@ExperimentalFoundationApi
@Composable
fun showHistory() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)
    ) {
        Column() {
            Row() {
                Text(
                    text = "历史搜索",
                    fontWeight = FontWeight.Black,
                    fontSize = 15.sp
                )

                Box(modifier = Modifier.fillMaxWidth()) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.TopEnd),
                        tint = Color.Gray)
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            lazyVerticalGrid(historyList)
        }
    }
}


@ExperimentalFoundationApi
@Composable
fun lazyVerticalGrid(list: List<String>) {
    //val list = remember { historyList }

    Column() {
        VerticalGrid(columns = 3){
            list.forEach { 
                historytext(text = it)
            }
        }
    }


}


@Composable
fun historytext(text: String) {
    Text(
        text = text,
        fontSize = 15.sp,
        color = Color.LightGray,
        modifier = Modifier.padding(12.dp)
    )
}


@ExperimentalFoundationApi
@Composable
fun showDiscovery() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)
    ) {
        Column() {
            Row() {
                Text(
                    text = "搜索发现",
                    fontWeight = FontWeight.Black,
                    fontSize = 15.sp
                )

                Box(modifier = Modifier.fillMaxWidth()) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.TopEnd),
                        tint = Color.Gray)
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            lazyVerticalGrid(discoveryList)
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun previewHistory() {
    SearchHistory()
}