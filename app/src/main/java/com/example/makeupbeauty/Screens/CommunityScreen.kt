package com.example.makeupbeauty.Screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.makeupbeauty.data.ConcernDataProvider
import com.example.makeupbeauty.data.DemoDataProvider
import com.example.makeupbeauty.R
import kotlinx.coroutines.InternalCoroutinesApi

private enum class DemoTabs(val value: String) {
    CONCERN("关注"),
    COMMEND("推荐"),
}


@InternalCoroutinesApi
@ExperimentalFoundationApi
@Composable
fun CommunityScreen() {
    val tabsName = remember { DemoTabs.values().map { it.value } }
    val selectedIndex = remember { mutableStateOf(DemoTabs.COMMEND.ordinal) }

    Column(
    ) {
        TabRow(selectedTabIndex = selectedIndex.value) {
            tabsName.forEachIndexed { index, title ->
                Tab(
                    selected = index == selectedIndex.value,
                    onClick = {
                        when (title) {
                            DemoTabs.CONCERN.value -> {
                                selectedIndex.value = DemoTabs.CONCERN.ordinal
                            }
                            DemoTabs.COMMEND.value -> {
                                selectedIndex.value = DemoTabs.COMMEND.ordinal
                            }
                        }
                    },
                    text = { Text(title) }
                )
            }
        }
        Surface(modifier = Modifier.weight(0.5f)) {
            when (selectedIndex.value) {
                DemoTabs.CONCERN.ordinal -> {
                    getConcern()
                }
                DemoTabs.COMMEND.ordinal -> {
                    getCommend()
                }
            }
        }
    }

    Box(modifier = Modifier
        .padding(bottom = 75.dp)
        .fillMaxSize()
        .wrapContentSize(align = Alignment.BottomEnd)){
        AddMultiFab()
    }
}

@InternalCoroutinesApi
@Composable
fun getConcern() {
    val list = remember { ConcernDataProvider.ConcernItemList }
    //navController.navigate("PostActivity")

    LazyColumn {
        item {
            //HomeHeader()
        }
        items(
            items = list,
            itemContent = { item -> ConcernItem(item = item, modifier = Modifier)
                ListItemDivider()
            }
        )
    }
}

@Composable
private fun ListItemDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
//        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f)
    )
}

@InternalCoroutinesApi
@ExperimentalFoundationApi
@Composable
fun getCommend() {
    val list = remember { ConcernDataProvider.CommendItemList }
    LazyColumn() {
        item {
            StaggeredVerticalGrid(maxColumnWidth = 250.dp) {
                list.forEach {
                    CommendItem(item = it)
                }
            }
        }
    }

}



@InternalCoroutinesApi
@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun CommunityScreenPreview() {
    //CommunityScreen()
}



@Composable
fun AddMultiFab(){
    val expandFbItemList: MutableList<MultiFabItem> = mutableListOf(
        MultiFabItem(
            srcIconColor = Color.White,
            fabBackgroundColor = Color.Black,
            labelBackgroundColor = Color.Red.copy(alpha = 0.45F),
            labelTextColor = Color.Blue.copy(alpha = 0.45F),
            //自己设置一个图片或者svg
            icon = ImageVector.vectorResource(id = R.drawable.ic_idea),
            label = "图片"
        ),
        MultiFabItem(
            srcIconColor = Color.Yellow,
            fabBackgroundColor = Color.DarkGray,
            //自己设置一个图片或者svg
            icon = ImageVector.vectorResource(id = R.drawable.ic_idea),
            label = "视频"
        )
    )
    val context = LocalContext.current
    FloatingAddButton(srcIcon = Icons.Filled.Add, showLabels = true,items = expandFbItemList) {
        //弹出来的item被点击了
        Toast.makeText(context.applicationContext,"点击了:${it.label}",Toast.LENGTH_SHORT).show()
    }
}
