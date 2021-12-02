package com.example.makeupbeauty.component.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
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
            .fillMaxWidth()
            .wrapContentSize()
        ,
        // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
        // 将无法显示波纹效果

        elevation = 6.dp // 设置阴影
    ) {
        Row(
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary)
                        ) {
                            append("美发实验室")
                        }
                    }
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "尝试新发色\n123123123123\n.......",
                    fontSize = 16.sp,
                )
            }

            Image(painter = painterResource(id = R.drawable.ic_hair_card),
                contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(120.dp)
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
            .fillMaxWidth()
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
                    withStyle(style = SpanStyle(fontSize = 12.sp, color = Color(0xFF4552B8))
                    ) {
                        append("脸部实验室")
                    }
                }
            )
            Image(painter = painterResource(id = R.drawable.ic_face_card),
                contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(48.dp)
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
            .fillMaxWidth()
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
                    withStyle(style = SpanStyle(fontSize = 12.sp, color = Color(0xFF4552B8))
                    ) {
                        append("美甲实验室")
                    }
                }
            )
            Image(painter = painterResource(id = R.drawable.ic_hand_card),
                contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(48.dp)
            )
        }
    }
}
