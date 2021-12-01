package com.example.makeupbeauty.Screens


import androidx.compose.foundation.*
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
import com.example.makeupbeauty.data.DemoDataProvider
import androidx.compose.foundation.lazy.items as items


@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState(0)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
      
        ScrollableContent(scrollState = scrollState)
    }
}


@Composable
fun ScrollableContent(scrollState: ScrollState){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(20.dp)
            .verticalScroll(state = scrollState)
    ) {
//
        //首页主图
        Image(painter = painterResource(id = com.example.makeupbeauty.R.drawable.makeup),
            contentDescription =null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(400.dp)
                .height(150.dp)
        )
        Row {
            CardDemo1()
            CardDemo2()
            CardDemo3()
            //三个实验室的part

        }

        RecommendTitle("每日推荐")

        VerticalListView()

    }
}

@Composable
fun RecommendTitle(text: String, modifier: Modifier = Modifier){
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        color = Color.Blue,
        textAlign = TextAlign.Left,
        modifier = modifier.padding(8.dp,4.dp,8.dp,24.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}


@Composable
fun CardDemo1() {
    Card(
        modifier = Modifier
            .padding(10.dp) // 外边距
            .clickable { }
            .wrapContentSize()
            ,
        // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
        // 将无法显示波纹效果

        elevation = 6.dp // 设置阴影
    ) {
        Row(
            modifier = Modifier.padding(10.dp) // 内边距
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 8.sp, color = Color(0xFF4552B8))
                    ) {
                        append("美发实验室")
                    }
                }
            )
            Image(painter = painterResource(id = com.example.makeupbeauty.R.drawable.hair),
                contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
            )
        }
    }
}



@Composable
fun CardDemo2() {
    Card(
        modifier = Modifier
            .padding(10.dp) // 外边距
            .clickable { }
            .wrapContentSize()
        ,

        // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
        // 将无法显示波纹效果

        elevation = 6.dp // 设置阴影
    ) {
        Row(
            modifier = Modifier.padding(10.dp) // 内边距
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 8.sp, color = Color(0xFF4552B8))
                    ) {
                        append("脸部实验室")
                    }
                }
            )
            Image(painter = painterResource(id = com.example.makeupbeauty.R.drawable.face),
                contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
            )
        }
    }
}

@Composable
fun CardDemo3() {
    Card(
        modifier = Modifier
            .padding(10.dp) // 外边距
            .clickable { }
            .wrapContentSize()
        ,

        // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
        // 将无法显示波纹效果

        elevation = 6.dp // 设置阴影
    ) {
        Row(
            modifier = Modifier.padding(10.dp) // 内边距
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 8.sp, color = Color(0xFF4552B8))
                    ) {
                        append("美甲实验室")
                    }
                }
            )
            Image(painter = painterResource(id = com.example.makeupbeauty.R.drawable.hand),
                contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
            )
        }
    }
}


@Composable
fun ArtistCard(
//    artist: Artist,
//    onClick: () -> Unit
) {
    val padding = 16.dp
    Column(
        Modifier
//            .clickable(onClick = onClick)
//            .padding(padding)
            .fillMaxWidth()
    ) {
        Row() {
            Image(painter =  painterResource(id = com.example.makeupbeauty.R.drawable.profile),
                contentDescription = null,
                    modifier=Modifier.size(60.dp)
                                 .clip(CircleShape)

            )
            Column() {
                Text(text="zdd")
                Text(text="dddd")
            }
        /*...*/ }
        Spacer(modifier = Modifier.width(12.dp))
        Card(elevation = 4.dp) { /*...*/ }
    }
}


@Composable
fun VerticalListView() {
    val list = remember { DemoDataProvider.itemList }
    LazyColumn {
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


