package com.example.makeup_me.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.makeupbeauty.R

@Composable
public fun MyInfo(imageid: Int, name: String, vip: String, prefer: Int, fans: Int) {
    Box(modifier = Modifier.fillMaxSize()){
        Column() {
            Head(R.drawable.avatar, "ylg", "1", 0, 0)
            Spacer(
                Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
            List()
        }
    }
}



@Composable
fun List() {
    MeListItem(R.drawable.icon, "历史（试妆）")
    Divider(startIndent = 56.dp, color = Color.Gray, thickness = 0.8f.dp)
    MeListItem(R.drawable.icon, "订单")
    Spacer(
        Modifier
            .background(Color.Gray)
            .fillMaxWidth()
            .height(8.dp)
    )
    MeListItem(R.drawable.icon, "我发布的帖子")
    Divider(startIndent = 56.dp, color = Color.Gray, thickness = 0.8f.dp)
    MeListItem(R.drawable.icon, "我喜欢的帖子")
    Divider(startIndent = 56.dp, color = Color.Gray, thickness = 0.8f.dp)
    MeListItem(R.drawable.icon, "我的消息")
}

//头像部分
@Composable
fun Head(imageid: Int, name: String, vip: String, prefer: Int, fans: Int) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(height = 120.dp), Alignment.Center) {
        Row(modifier = Modifier) {
            Image(
                painter = painterResource(id = imageid),
                contentDescription = "avatar",
                modifier = Modifier
                    .padding(4.dp)
                    .clip(CircleShape)
                    .size(80.dp))
            Column() {
                Row(modifier = Modifier.padding(horizontal = 4.dp), Arrangement.Center) {
                    Text(text = name, fontWeight = FontWeight.ExtraBold, fontSize = 25.sp)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = "vip "+vip, textAlign = TextAlign.Center, fontSize = 17.sp)
                }
                Spacer(
                    Modifier
                        .height(8.dp)
                )
                Row(modifier = Modifier.padding(horizontal = 4.dp)) {
                    Text(text = "关注: "+prefer.toString(), fontSize = 17.sp)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = "粉丝: "+fans.toString(), fontSize = 17.sp)
                }
            }
        }
    }
}

@Composable
fun MeListItem(
    @DrawableRes icon: Int,
    title: String,
    modifier: Modifier = Modifier,
    badge: @Composable (() -> Unit)? = null,
    endBadge: @Composable (() -> Unit)? = null
) {
    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(icon), "title", Modifier
                .padding(12.dp, 8.dp, 8.dp, 8.dp)
                .size(36.dp)
                .padding(8.dp)
        )
        Text(
            title,
            fontSize = 17.sp
        )
        badge?.invoke()
        Spacer(Modifier.weight(1f))
        endBadge?.invoke()
        /*
        Icon(
            painterResource(R.drawable.ic_arrow_more), contentDescription = "更多",
            Modifier
                .padding(0.dp, 0.dp, 12.dp, 0.dp)
                .size(16.dp)
        )*/
    }
}


@Preview()
@Composable
fun HeadPreview(){
    Head(R.drawable.avatar, "ylg", "1", 0, 0);
}