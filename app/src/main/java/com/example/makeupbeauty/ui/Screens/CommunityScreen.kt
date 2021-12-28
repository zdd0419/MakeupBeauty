package com.example.makeupbeauty.ui.Screens

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
//import com.example.makeupbeauty.data.ConcernDataProvider
import com.example.makeupbeauty.R
import com.example.makeupbeauty.TryOn.TryOn
import com.example.makeupbeauty.data.notesData
import com.example.makeupbeauty.ui.Notes
import com.example.makeupbeauty.viewModel.PostViewModel
import kotlinx.coroutines.InternalCoroutinesApi

private enum class DemoTabs(val value: String) {
    CONCERN("关注"),
    COMMEND("推荐"),
}


@InternalCoroutinesApi
@ExperimentalFoundationApi
@Composable
fun CommunityScreen() {
    val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
    //postViewModel.init()
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
    val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
    val list = postViewModel.my_concern
    postViewModel.changeConcern(0)
    //val list = postViewModel.my_concern
    //navController.navigate("PostActivity")

    LazyColumn {
        item {
            //HomeHeader()
        }
        items(
            items = postViewModel.my_concern,
            itemContent = { item ->
                postViewModel.changeConcern(item.id)
                ConcernItem(item = item, modifier = Modifier)
                ListItemDivider()
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
    val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
    val list = postViewModel.notes_detail
    postViewModel.changeConcern(1)
    //Log.e("", list.toString())
    LazyColumn() {
        item {
            StaggeredVerticalGrid(maxColumnWidth = 250.dp) {
                list.forEach {
                    postViewModel.changeRecommend(it.id)
                    CommendItem(item = it)
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
        if (it.label == "图片")
        {
            val intent = Intent(context, Notes::class.java)
            startActivity(context, intent, null
             //   Notes.newIntent(context)
            )
        }else {

        }
    }
}
