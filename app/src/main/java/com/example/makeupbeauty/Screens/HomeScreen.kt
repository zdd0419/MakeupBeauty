package com.example.makeupbeauty.Screens


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.card.TopLabCards
import com.example.makeupbeauty.data.DemoDataProvider
import androidx.compose.foundation.lazy.items as items


@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState(0)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        VerticalListView()
    }
}


@Composable
fun HomeHeader() {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(bottom = 0.dp)
    ) {
        Image(
            painter = painterResource(id = com.example.makeupbeauty.R.drawable.home_banner),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clickable {}
        )
        LazyRow(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            item {
                TopLabCards(labTitle = "美发实验室", labContent = "尝试新发色\n秋冬发色\n总有一款是你心仪的", labImage = painterResource(id = R.drawable.ic_hair_card))
                TopLabCards(labTitle = "脸部实验室", labContent = "尝试新妆容\n圣诞特定妆容\n快来试试吧", labImage = painterResource(id = R.drawable.ic_face_card))
                TopLabCards(labTitle = "美甲实验室", labContent = "尝试新美甲\n圣诞美甲新品来咯！\n快叫上你的姐妹一起来试试！", labImage = painterResource(id = R.drawable.ic_hand_card))
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        RecommendTitle("每日推荐")
    }


}

@Composable
fun RecommendTitle(text: String, modifier: Modifier = Modifier){
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue,
        textAlign = TextAlign.Center,
        modifier = modifier.padding(10.dp,4.dp,8.dp,0.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
fun VerticalListView() {
    val list = remember { DemoDataProvider.itemList }
    LazyColumn {
        item {
            HomeHeader()
        }
        items(
            items = list,
            itemContent = { item -> VerticalListItem(item = item)
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


