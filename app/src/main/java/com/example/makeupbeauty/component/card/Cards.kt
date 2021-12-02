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
import androidx.compose.ui.graphics.painter.Painter
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
fun TopLabCards(
    labTitle:String,
    labContent:String,
    labImage:Painter,
    onClick:()->Unit = {}
){
    Card(
        modifier = Modifier
            .padding(10.dp) // 外边距
            .clickable(onClick = onClick)
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
            Column() {
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary)
                        ) {
                            append(labTitle)
                        }
                    }
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = labContent,
                    fontSize = 14.sp,
                )
            }

            Image(painter = labImage,
                contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(150.dp)
            )
        }
    }
}
