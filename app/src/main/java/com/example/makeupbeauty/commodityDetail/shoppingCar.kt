package com.example.makeupbeauty.commodityDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.sharp.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.R
import com.example.makeupbeauty.ui.theme.*
import androidx.compose.material.Icon as Icon


@Preview(showBackground = true)
@Composable
fun AddToCartScren() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
//            TopAppBarHeader()
            Spacer(modifier = Modifier.padding(5.dp))
            DeleteCart()
            Spacer(modifier = Modifier.padding(20.dp))
            CartItemList()
            Spacer(modifier = Modifier.padding(20.dp))
            NextButtonWithTotalItems()
        }
    }
}


@Composable
fun DeleteCart() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = titleTextColor,
                            fontSize = 24.sp
                        )
                    ) {
                        append("购物车")
                    }

                }
            }
        )

        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Outlined.Delete,
                contentDescription = "",
                tint = orange
            )

        }
    }
}

@Composable
fun CartItemList() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        ProductCartItems(
            imagePainter = painterResource(id = R.drawable.product),
            title = "YSL圣罗兰小金条细管口红",
            price = "350.00",
            pricetag = "$",
            count = "x1",
            backgroundColor = lightsilverbox
        )
        ProductCartItems(
            imagePainter = painterResource(id = R.drawable.dior1),
            title = "迪奥精华水",
            price = "600.00",
            pricetag = "$",
            count = "x1",
            backgroundColor = lightsilverbox
        )
        ProductCartItems(
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
fun ProductCartItems(
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
            if (isChoose.value) {
                Icon(
                    imageVector = Icons.Filled.Circle,
                    contentDescription = null,
                    tint = lightGrey
                )
            } else {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "",
                    tint = Color.Green
                )
            }





            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
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

            }
        }

    }
}

@Composable
fun NextButtonWithTotalItems() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Divider(color = lightGrey, thickness = 2.dp)
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "3 Items",
                fontSize = 14.sp,
                color = lightGrey
            )

            Text(
                text = "$1300.00",
                fontSize = 18.sp,
                color = titleTextColor,
                fontWeight = FontWeight.Bold
            )
        }

        Button(
            onClick = {
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = orange),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 30.dp,
                    bottom = 34.dp
                )
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text(
                text = "结算",
                color = white,
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
        }

    }
}
