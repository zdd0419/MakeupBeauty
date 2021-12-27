package com.example.makeupbeauty.CommunityPost

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.makeupbeauty.component.models.ConcernItem
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.models.User

@Composable
fun UserItem(item: User, modifier: Modifier = Modifier, onClick:()->Unit = {}) {
    Card() {
        Row(modifier = Modifier.padding(12.dp)) {
            Image(
                painter = painterResource(id = R.drawable.user1),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(35.dp))

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = item.name)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "小红书号："+item.id)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "笔记 · " + item.postNum +"|" +"粉丝 · "+item.fansNum)
            }


            Box(modifier = Modifier.fillMaxWidth()){
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(50),
                    border = BorderStroke(1.dp, Color.Red),
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = if(item.concern) Color.Gray else Color.Red
                    ),
                    modifier = Modifier
                        .width(80.dp)
                        .height(35.dp)
                        .align(Alignment.TopEnd)
                        .padding(end = 8.dp)
                ){
                    Text(text = if(item.concern) "已关注" else "关注")
                }
            }

        }
    }
}