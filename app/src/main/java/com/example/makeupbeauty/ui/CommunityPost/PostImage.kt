package com.example.makeupbeauty.CommunityPost

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.makeupbeauty.component.models.CarouselItem
import com.example.makeupbeauty.ui.Screens.LoadImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@InternalCoroutinesApi
@ExperimentalPagerApi
@Composable
fun PostImage(modifier: Modifier = Modifier, imagesList: List<String>) {
    if (imagesList.isEmpty())
        return
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    val handler by remember {
        mutableStateOf(Handler(Looper.getMainLooper()))
    }

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
                //.wrapContentHeight()
                .fillMaxWidth()
        ) { page ->
            LoadImage(
                url = imagesList[page],
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds)

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