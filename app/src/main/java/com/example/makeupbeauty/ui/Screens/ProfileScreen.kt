package com.example.makeupbeauty.ui.Screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.R
import com.example.makeupbeauty.commodityDetail.MyoderActivity
import com.example.makeupbeauty.ui.MynotesActivity
import com.example.makeupbeauty.ui.collectActivity

@Composable
fun ProfileScreen() {
    val context = LocalContext.current;
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(245,245,245))
    ) {
        Box(Modifier.background(Color.White)) {
            Icon(
                imageVector = Icons.Outlined.Settings,
                tint = MaterialTheme.colors.onSurface,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(start = 12.dp, end = 12.dp, top = 18.dp, bottom = 12.dp)
                    .clickable { context.startActivity(SettingScreen.newIntent(context)) }
            )
            Head(R.drawable.avatar, "test longest", "1", 0, 0)
        }
        List()
    }
}
/*
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}*/

@Composable
fun List() {
    Divider(color = Color.LightGray, thickness = 0.8f.dp)
    MeListItem(Icons.Outlined.History, "历史")
    Divider(color = Color.LightGray, thickness = 0.8f.dp)
    MeListItem(Icons.Outlined.ListAlt, "订单")
    Spacer(
        Modifier
            .background(Color(245,245,245))
            .fillMaxWidth()
            .height(8.dp)
    )
    MeListItem(Icons.Outlined.CameraAlt, "我的发布")
    Divider(color = Color.LightGray, thickness = 0.8f.dp)
    MeListItem(Icons.Outlined.LocalActivity, "我的收藏")
    Divider(color = Color.LightGray, thickness = 0.8f.dp)
    MeListItem(Icons.Outlined.Mail, "我的消息")
    Divider(color = Color.LightGray, thickness = 0.8f.dp)
}

//头像部分
@Composable
fun Head(imageid: Int, name: String, vip: String, prefer: Int, fans: Int) {
    val context = LocalContext.current;
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
                    .size(80.dp)
                    .clickable { context.startActivity(PublicProfileScreen.newIntent(context)) })

            Column() {
                Spacer(
                    Modifier
                        .height(12.dp)
                )
                Row(modifier = Modifier.padding(horizontal = 4.dp), Arrangement.Center) {
                    Text(text = name, fontWeight = FontWeight.ExtraBold, fontSize = 25.sp)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = "vip $vip",color = Color.Cyan, textAlign = TextAlign.Center, fontSize = 17.sp)
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
    icon: ImageVector,
    title: String,
    badge: @Composable (() -> Unit)? = null,
    endBadge: @Composable (() -> Unit)? = null
) {
    val context = LocalContext.current;
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .clickable{if(title == "订单"){context.startActivity(MyoderActivity.newIntent(context))}
                if(title == "我的发布"){context.startActivity(MynotesActivity.newIntent(context))}
                if(title == "我的收藏"){context.startActivity(collectActivity.newIntent(context))}
                if(title == "我的消息"){context.startActivity(ChatListScreen.newIntent(context))}},
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            imageVector = icon,
            "title",
            Modifier
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
