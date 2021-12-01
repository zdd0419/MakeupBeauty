package com.example.makeupbeauty.Screens


import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.component.card.FaceLabCard
import com.example.makeupbeauty.component.card.HairLabCard
import com.example.makeupbeauty.component.card.HandLabCard
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
fun HomeHeader(){

        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(horizontal = 10.dp)
                .padding(top = 16.dp)
                .padding(bottom = 0.dp)
        ) {
            //首页主图
            Image(
                painter = painterResource(id = com.example.makeupbeauty.R.drawable.makeup),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .height(150.dp)
            )
            Row {
                HairLabCard()
                FaceLabCard()
                HandLabCard()
                //三个实验室的part
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
        modifier = modifier.padding(8.dp,4.dp,8.dp,0.dp)
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


