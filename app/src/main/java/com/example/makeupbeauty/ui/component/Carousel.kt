package com.example.makeupbeauty.component

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.makeupbeauty.component.models.CarouselItem
import com.example.makeupbeauty.viewModel.product_detailViewlModel
//import com.carouseljc.models.CarouselItem
//import com.carouseljc.utils.AppConstants
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

private const val TAG = "CarouselTest"

@InternalCoroutinesApi
@ExperimentalPagerApi
@Composable
fun Carousel(modifier: Modifier = Modifier, imagesList: List<CarouselItem>) {
    if (imagesList.isEmpty())
        return
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    val handler by remember {
        mutableStateOf(Handler(Looper.getMainLooper()))
    }
    val product_detailViewlmodel: product_detailViewlModel = viewModel()
    val list1 = product_detailViewlmodel.getList()
    val runnable by remember {
        mutableStateOf(Runnable {
            coroutineScope.launch {
                val currentPage = pagerState.currentPage
                if (currentPage == imagesList.size - 1)
                    pagerState.animateScrollToPage(0)
                else
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
            }
        })
    }

    DisposableEffect(key1 = handler) {
        onDispose {
            handler.removeCallbacks(runnable)
        }
    }

    LaunchedEffect(key1 = pagerState) {
        // Collect from the a snapshotFlow reading the currentPage
        snapshotFlow { pagerState.currentPage }.collect {
            handler.removeCallbacks(runnable)
            handler.postDelayed(runnable, 5000L)
        }

    }

    Box(modifier = modifier) {

        HorizontalPager(
            count = imagesList.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
        ) { page ->
            Image(
                painter = painterResource(imagesList[page].id),
                contentDescription = "slider",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.FillBounds
            )
        }
        coroutineScope.launch {
            pagerState.scrollToPage(0)
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp),
            activeColor = Color.White,
            inactiveColor = Color.LightGray
        )
    }
}

