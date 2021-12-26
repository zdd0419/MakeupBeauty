package com.example.makeupbeauty.ui.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.Search.Catagory
import com.example.makeupbeauty.VerticalGrid.StoryItem
import com.example.makeupbeauty.VerticalGrid.VerticalGrid
import com.example.makeupbeauty.component.Carousel
import com.example.makeupbeauty.component.GridListItem
import com.example.makeupbeauty.data.DemoDataProvider
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalPagerApi
@InternalCoroutinesApi
@Composable
fun StoreScreen() {
   Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
//            .wrapContentSize(Alignment.Center)
    ) {
//       item(){
           Carousel(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(160.dp)
                   .padding(10.dp),
               DemoDataProvider.adlist
           )


           GridListView()
       Text(text="-精品库新品-",
           fontSize = 12.sp,
           fontWeight = FontWeight.Bold,
           color = Color.Gray,
           textAlign = TextAlign.Center,
           modifier = Modifier.padding(146.dp,4.dp,8.dp,0.dp)
       )

       productList()
//       }

    }
}



@Composable
fun GridListView() {
    val context = LocalContext.current;
    //TODO: NO IN-BUILT GRID VIEW NOT AVAILABLE YET USING ROWS FOR NOW
    // GRIDS are not lazy driven yet so let's wait for Lazy Layout to make grids
    val posts = remember { DemoDataProvider.tweetList }
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        VerticalGrid(columns = 4) {
            posts.forEach {
                StoryItem(
                    profileImageId = it.authorImageId,
                    profileName = it.author,
                    isMe = it.id == 1,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
                    onClick = {context.startActivity(Catagory.newIntent(context))}
                )
            }
        }
    }
}

@Composable
fun productList(){
    val list = remember { DemoDataProvider.storeItemlist.take(6) }
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            VerticalGrid(columns = 3) {
                list.forEach {
                    GridListItem(item = it)
//                    when(it){
//                        storeItem(4,"迪奥迷你唇膏口红",R.drawable.dior2) ->ProductDetailsScreen()
//                    }
                }
            }
    }
}

@InternalCoroutinesApi
@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun StoreScreenPreview() {
    StoreScreen()

}




