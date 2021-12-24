package com.example.makeupbeauty.Search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.makeupbeauty.CommunityPost.UserItem
import com.example.makeupbeauty.ui.Screens.*
import com.example.makeupbeauty.data.ConcernDataProvider
import com.example.makeupbeauty.data.DemoDataProvider
import kotlinx.coroutines.InternalCoroutinesApi


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
        TabRow(selectedTabIndex = selectedIndex.value) {
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

@InternalCoroutinesApi
@Composable
fun showPost() {
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

@Composable
fun showUser() {
    val list = remember { DemoDataProvider.userList }
    //navController.navigate("PostActivity")

    LazyColumn {
        item {
            //HomeHeader()
        }
        items(
            items = list,
            itemContent = { item -> UserItem(item = item, modifier = Modifier)
                Divider()
            }
        )
    }
}


@InternalCoroutinesApi
@Preview(showBackground = true)
@Composable
fun previewSearchResult(){
    SearchResult()
}