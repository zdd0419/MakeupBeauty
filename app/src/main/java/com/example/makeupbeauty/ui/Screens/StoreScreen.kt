package com.example.makeupbeauty.ui.Screens

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.example.makeupbeauty.Search.Catagory
import com.example.makeupbeauty.VerticalGrid.StoryItem
import com.example.makeupbeauty.VerticalGrid.VerticalGrid
import com.example.makeupbeauty.commodityDetail.productDetailActivity
import com.example.makeupbeauty.component.Carousel
import com.example.makeupbeauty.component.GridListItem
import com.example.makeupbeauty.data.DemoDataProvider
import com.example.makeupbeauty.viewModel.PostViewModel
import com.example.makeupbeauty.viewModel.product_detailViewlModel
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
            .verticalScroll(rememberScrollState())
//            .wrapContentSize(Alignment.Center)
    ) {
//       item(){
//           Carousel(
//               modifier = Modifier
//                   .fillMaxWidth()
//                   .height(220.dp)
//                   .padding(10.dp),
//               DemoDataProvider.adlist
//           )


           GridListView()
       Spacer(modifier = Modifier.height(32.dp))
       Text(text="-精品库新品-",
           fontSize = 24.sp,
           fontWeight = FontWeight.Bold,
           color = Color(0xFFEC8AA4),
           textAlign = TextAlign.Center,
           modifier = Modifier.align(Alignment.CenterHorizontally)
       )

       productList()
       Spacer(modifier = Modifier.height(48.dp))
    }
}



@Composable
fun GridListView() {
    val product_detailViewlmodel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<product_detailViewlModel>()
    val context = LocalContext.current;
    //TODO: NO IN-BUILT GRID VIEW NOT AVAILABLE YET USING ROWS FOR NOW
    // GRIDS are not lazy driven yet so let's wait for Lazy Layout to make grids
    val posts = remember { DemoDataProvider.tweetList }
    Column() {
        VerticalGrid(columns = 4) {
            posts.forEach {
                StoryItem(
                    profileImageId = it.authorImageId,
                    profileName = it.author,
                    isMe = it.id == 1,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
                    onClick = {
                        product_detailViewlmodel.changeCategory(it.author)
                        Log.e(it.author,it.author)
                        context.startActivity(Catagory.newIntent(context))}
                )
            }
        }
    }
}

@Composable
fun productList(){
    val product_detailViewlmodel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<product_detailViewlModel>()
    product_detailViewlmodel.changeCategory("special")
    val list1 = product_detailViewlmodel.getList()
    val context = LocalContext.current;
    Column() {
            VerticalGrid(columns = 3) {
                list1.forEach {
                    GridListItem(item = it,
                        onClick = {
                            print("idididid:"+it.id)
                             product_detailViewlmodel.setId(it.id)
                            context.startActivity(productDetailActivity.newIntent(context))}
                        )

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




