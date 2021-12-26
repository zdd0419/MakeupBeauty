package com.example.makeupbeauty.commodityDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.makeupbeauty.commodityDetail.ui.theme.MakeupBeautyTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.TopBarWithBack
import com.example.makeupbeauty.ui.theme.*


class MyoderActivity : ComponentActivity() {
    companion object {
        fun newIntent(context: Context) =
            Intent(context, MyoderActivity::class.java).apply { putExtra("myOder", true) }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    oderAc()
                }
            }
        }
    }
}


@Preview
@Composable
fun oderAc() {
    com.example.makeupbeauty.ui.theme.MakeupBeautyTheme {
        Scaffold(
            topBar = {
                TopBarWithBack(
                    title = "我的订单",
                    onBackClick = {

                    },
                )
            }, backgroundColor = cottonBall,
            content = {
//                LazyColumn() {
//                    item {
//
//                    }
//                }
                OderItemList()
            })
    }
}


@Composable
fun OderItemList() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        oderItems(
            imagePainter = painterResource(id = R.drawable.product),
            title = "YSL圣罗兰小金条细管口红",
            price = "350.00",
            pricetag = "$",
            count = "x1",
            backgroundColor = lightsilverbox
        )
        oderItems(
            imagePainter = painterResource(id = R.drawable.dior1),
            title = "迪奥精华水",
            price = "600.00",
            pricetag = "$",
            count = "x1",
            backgroundColor = lightsilverbox
        )
        oderItems(
            imagePainter = painterResource(id = R.drawable.khcard),
            title = "迪奥口红",
            price = "350.00",
            pricetag = "$",
            count = "x1",
            backgroundColor = lightsilverbox
        )

    }
}

@Composable
fun oderItems(
    imagePainter: Painter,
    title: String = "",
    price: String = "",
    pricetag: String = "",
    count: String = "",
    backgroundColor: Color = Color.Transparent
) {
    val isChoose = remember { mutableStateOf(true) }
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        item {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(200.dp)
                    .fillMaxWidth(0.2f)

                    .clip(RoundedCornerShape(20.dp))
                    .background(backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = imagePainter,
                    contentDescription = "",
                    modifier = Modifier.padding(8.dp),
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    color = titleTextColor,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    orange,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(pricetag)
                            }
                            withStyle(
                                style = SpanStyle(
                                    titleTextColor
                                )
                            ) {
                                append(price)
                            }
                        },
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier,
                        fontSize = 16.sp

                    )
                    Box(
                        modifier = Modifier
                            .size(35.dp, 35.dp)
                            .clip(CircleShape)
                            .background(backgroundColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = count,
                            fontSize = 14.sp,
                            color = titleTextColor
                        )
                    }
                }

                Text(
                    text = "收货地址：北京交通大学南门",
                    fontSize = 14.sp,
                    color = titleTextColor
                )

                Button(
                    onClick = {
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = orange),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 170.dp,
                            top = 30.dp,
//                            bottom = 34.dp,
//                            end=10.dp

                        )
                        .align(Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = "" +
                                "确认收货",
                        color = white,
                        style = MaterialTheme.typography.button,
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                        fontSize = 10.sp
                    )
                }

            }
        }

    }
}