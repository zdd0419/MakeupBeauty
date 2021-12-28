package com.example.makeupbeauty.Search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.example.makeupbeauty.CommunityPost.UserItem
import com.example.makeupbeauty.commodityDetail.productDetailActivity
import com.example.makeupbeauty.ui.Screens.*
import com.example.makeupbeauty.data.ConcernDataProvider
import com.example.makeupbeauty.data.DemoDataProvider
import com.example.makeupbeauty.searchText
import com.example.makeupbeauty.viewModel.product_detailViewlModel
import com.example.makeupbeauty.viewModel.PostViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import com.example.makeupbeauty.R


private enum class SearchTabs(val value: String) {
    GOODS("商品"),
    POST("帖子"),
    USER("用户")
}


@InternalCoroutinesApi
@Composable
fun SearchResult() {
    val tabsName = remember { SearchTabs.values().map { it.value } }
    val selectedIndex = remember { mutableStateOf(SearchTabs.GOODS.ordinal) }

    Column(
    ) {
        TabRow(selectedTabIndex = selectedIndex.value,
        backgroundColor = Color(0xFFec8aa4),
        contentColor = Color.White) {
            tabsName.forEachIndexed { index, title ->
                Tab(
                    selected = index == selectedIndex.value,
                    onClick = {
                        when (title) {
                            SearchTabs.GOODS.value -> {
                                selectedIndex.value = SearchTabs.GOODS.ordinal
                            }
                            SearchTabs.POST.value -> {
                                selectedIndex.value = SearchTabs.POST.ordinal
                            }
                            SearchTabs.USER.value -> {
                                selectedIndex.value = SearchTabs.USER.ordinal
                            }
                        }
                    },
                    text = { Text(title) }
                )
            }
        }
        Surface(modifier = Modifier.weight(0.5f)) {
            when (selectedIndex.value) {
                SearchTabs.GOODS.ordinal -> {
                    showGoods()
                }
                SearchTabs.POST.ordinal -> {
                    showPost()
                }
                SearchTabs.USER.ordinal -> {
                    showUser()
                }

            }
        }
    }
}


@Composable
fun showGoods() {
    var num = 0;
    val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
    val product_detailViewlmodel: product_detailViewlModel = viewModel()
    val list1 = product_detailViewlmodel.getList()
    val context = LocalContext.current;
    val search = postViewModel.searchtext
    LazyColumn() {
        item {
            StaggeredVerticalGrid(maxColumnWidth = 250.dp) {
                list1.forEach {
                    if (it.title.contains(search)) {
                        num ++
                        GoodsItem(
                            item = it,
                            onClick = {context.startActivity(productDetailActivity.newIntent(context))}
                        )
                    }

                }
            }
            if(num == 0) {
                forBlank()
            }
        }
    }
}

@InternalCoroutinesApi
@Composable
fun showPost() {
    var num = 0
    val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
    val search = postViewModel.searchtext
    val list = postViewModel.notes_detail
    LazyColumn() {
        item {
            StaggeredVerticalGrid(maxColumnWidth = 250.dp) {
                list.forEach {
                    if(it.title.contains(search) or it.content.contains(search))
                        num ++
                        CommendItem(item = it)
                }
            }
            if(num == 0) {
                forBlank()
            }
        }
    }
}

@Composable
fun showUser() {
    var num = 0;
    val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
    val list = postViewModel.userList
    val search = postViewModel.searchtext
    //navController.navigate("PostActivity")

    LazyColumn {
        item {
            //HomeHeader()
        }
        items(
            items = list,
            itemContent = {
                    item -> if(item.name.contains(search)) {
                        num ++
                        UserItem(item = item, modifier = Modifier)
                        Divider()
                    }

            }
        )
        item {
            if(num == 0)
            {
                forBlank()
            }
        }
    }
}


@Composable
fun forBlank() {
    Box(modifier = Modifier.fillMaxWidth()){
        Text(
            text = "找不到搜索的内容\n 请换个关键词~",
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.Center),
            fontSize = 15.sp,
            color = Color(0xFFec8aa4)
        )
    }

    Image(
        painter = painterResource(id = R.drawable.remind),
        contentDescription = null)
    Image(
        painter = painterResource(id = R.drawable.remind),
        contentDescription = null)
    Text(
        text = "Makeup Beauty",
        modifier = Modifier.padding(12.dp),
        fontSize = 25.sp,
        color = MaterialTheme.colors.primary
    )
}


@InternalCoroutinesApi
@Preview(showBackground = true)
@Composable
fun previewSearchResult(){
    SearchResult()
}