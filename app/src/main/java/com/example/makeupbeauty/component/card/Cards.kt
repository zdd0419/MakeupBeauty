package com.example.makeupbeauty.component.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.R

@Composable
fun HairLabCard() {
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
            Image(painter = painterResource(id = R.drawable.hair),
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
fun FaceLabCard() {
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
            Image(painter = painterResource(id = R.drawable.face),
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
fun HandLabCard() {
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
            Image(painter = painterResource(id = R.drawable.hand),
                contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
            )
        }
    }
}
