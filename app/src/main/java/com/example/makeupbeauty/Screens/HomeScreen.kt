package com.example.makeupbeauty.Screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState(0)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
//        Text(
//            text = "Home View",
//            fontWeight = FontWeight.Bold,
//            color = Color.Black,
//            textAlign = TextAlign.Center,
//            fontSize = 25.sp
//        )
        ScrollableContent(scrollState = scrollState)
    }
}


@Composable
fun ScrollableContent(scrollState: ScrollState){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
            .verticalScroll(state = scrollState)
    ) {
        RecommendTitle(text = "Title")

    }
}

@Composable
fun RecommendTitle(text: String, modifier: Modifier = Modifier){
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        textAlign = TextAlign.Left,
        modifier = modifier.padding(8.dp,4.dp,8.dp,24.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
