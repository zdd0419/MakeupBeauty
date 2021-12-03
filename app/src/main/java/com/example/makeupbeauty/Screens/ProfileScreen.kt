package com.example.makeupbeauty.Screens

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.R

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Box(Modifier.background(Color.White)) {
            Icon(
                imageVector = Icons.Outlined.Settings,
                tint = MaterialTheme.colors.onSurface,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(start = 12.dp, end = 12.dp, top = 18.dp, bottom = 12.dp)
            )
            Head(R.drawable.avatar, "test longest", "1", 0, 0)
        }
        List()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}

@Composable
fun List() {
    Divider(color = Color.LightGray, thickness = 0.8f.dp)
    MeListItem(R.drawable.icon, "历史")
    Divider(color = Color.LightGray, thickness = 0.8f.dp)
    MeListItem(R.drawable.icon, "订单")
    Spacer(
        Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .height(8.dp)
    )
    MeListItem(R.drawable.icon, "我发布的帖子")
    Divider(color = Color.LightGray, thickness = 0.8f.dp)
    MeListItem(R.drawable.icon, "我喜欢的帖子")
    Divider(color = Color.LightGray, thickness = 0.8f.dp)
    MeListItem(R.drawable.icon, "我的消息")
    Divider(color = Color.LightGray, thickness = 0.8f.dp)
}

//头像部分
@Composable
fun Head(imageid: Int, name: String, vip: String, prefer: Int, fans: Int) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp,24.dp,0.dp,8.dp)
        .height(height = 120.dp), Alignment.CenterStart) {
        Row(modifier = Modifier) {
            Image(
                painter = painterResource(id = imageid),
                contentDescription = "avatar",
                modifier = Modifier
                    .padding(12.dp)
                    .clip(CircleShape)
                    .size(80.dp))

            Column() {
                Spacer(
                    Modifier
                        .height(12.dp)
                )
                Row(modifier = Modifier.padding(horizontal = 4.dp), Arrangement.Center) {
                    Text(text = name, fontWeight = FontWeight.ExtraBold, fontSize = 25.sp)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = "vip "+vip,color = Color.Cyan, textAlign = TextAlign.Center, fontSize = 17.sp)
                }
                Spacer(
                    Modifier
                        .height(8.dp)
                )
                Row(modifier = Modifier.padding(horizontal = 4.dp)) {
                    Text(text = "关注: "+prefer.toString(), fontSize = 17.sp)
                    Spacer(modifier = Modifier.padding(16.dp))
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
    badge: @Composable (() -> Unit)? = null,
    endBadge: @Composable (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
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
            fontSize = 20.sp
        )
        badge?.invoke()
        Spacer(Modifier.weight(1f))
        endBadge?.invoke()
    }
}
