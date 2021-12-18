package com.example.makeupbeauty.Login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.R
import com.example.makeupbeauty.ui.theme.MakeupBeautyTheme

class Setting : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            MakeupBeautyTheme{
                Surface(color = MaterialTheme.colors.background){
                    SettingScreen()
                }
            }
        }

    }

}

@Composable
fun SettingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Box(Modifier.background(Color.White)) {
            Head(R.drawable.avatar, "test longest", "1", 0, 0)
        }
        // 设置列表
        List()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    SettingScreen()
}

// 设置列表
@Composable
fun List() {
    LazyColumn(){
        item{
            Spacer(
                Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .height(8.dp)
            )
        }

        // 状态与安全
        item {
            Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    Icons.Outlined.AdminPanelSettings,
                 contentDescription = "",
                 tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "状态与安全",
                    fontSize = 20.sp
                )
                Spacer(Modifier.weight(1f))
           }
        }

        item{
            Divider(color = Color.LightGray, thickness = 0.8f.dp)
        }

        // 通知设置
        item{
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    Icons.Outlined.MarkChatUnread,
                    contentDescription = "",
                    tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "通知设置",
                    fontSize = 20.sp
                )
                Spacer(Modifier.weight(1f))
            }
        }

        item{
            Spacer(
                Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .height(8.dp)
            )
        }

        // 常见问题
        item{
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    Icons.Outlined.ContactSupport,
                    contentDescription = "",
                    tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "常见问题",
                    fontSize = 20.sp
                )
                Spacer(Modifier.weight(1f))
            }
        }

        item{
            Divider(color = Color.LightGray, thickness = 0.8f.dp)
        }

        // 意见反馈
        item{
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    Icons.Outlined.QuestionAnswer,
                    contentDescription = "",
                    tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "意见反馈",
                    fontSize = 20.sp
                )
                Spacer(Modifier.weight(1f))
            }
        }

        item{
            Divider(color = Color.LightGray, thickness = 0.8f.dp)
        }

        // 关于
        item{
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    Icons.Outlined.Group,
                    contentDescription = "",
                    tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "关于",
                    fontSize = 20.sp
                )
                Spacer(Modifier.weight(1f))
            }
        }

        item{
            Spacer(
                Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .height(8.dp)
            )
        }

        // 退出登录
        item{
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    Icons.Default.Logout,
                    contentDescription = "",
                    tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "退出登录",
                    fontSize = 20.sp
                )
                Spacer(Modifier.weight(1f))
            }
        }
    }
}

//头像部分
@Composable
fun Head(imageid: Int, name: String, vip: String, prefer: Int, fans: Int) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp, 24.dp, 0.dp, 8.dp)
        .height(height = 90.dp), Alignment.CenterStart) {
        Row(modifier = Modifier) {
            Image(
                painter = painterResource(id = imageid),
                contentDescription = "avatar",
                modifier = Modifier
                    .padding(12.dp)
                    .clip(CircleShape)
                    .size(60.dp))

            Column() {
                Spacer(
                    Modifier
                        .height(22.dp)
                )
                Row(modifier = Modifier.padding(horizontal = 4.dp), Arrangement.Center) {
                    Text(
                        text = name,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 25.sp,
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = "vip "+vip,color = Color.Cyan, textAlign = TextAlign.Center, fontSize = 17.sp)
                }
//                Spacer(
//                    Modifier
//                        .height(8.dp)
//                )
//                Row(modifier = Modifier.padding(horizontal = 4.dp)) {
//                    Text(text = "关注: "+prefer.toString(), fontSize = 17.sp)
//                    Spacer(modifier = Modifier.padding(16.dp))
//                    Text(text = "粉丝: "+fans.toString(), fontSize = 17.sp)
//                }
            }
        }
    }
}

@Composable
fun MeListItem(
    //@DrawableRes icon: Int,
    imageVector : Icons,
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
        Icon(
            Icons.Default.Email,
            contentDescription = "",
            tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
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