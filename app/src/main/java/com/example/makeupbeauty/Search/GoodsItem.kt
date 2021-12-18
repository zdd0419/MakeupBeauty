package com.example.makeupbeauty.Search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.makeupbeauty.CommunityPost.PostActivity
import com.example.makeupbeauty.component.models.ConcernItem
import com.example.makeupbeauty.component.models.Goods

@Composable
fun GoodsItem(item: Goods, modifier: Modifier = Modifier, onClick:()->Unit = {}) {
    val context = LocalContext.current;
    Card(modifier = Modifier
        .clickable { }
        .padding(4.dp))
    {
        Column {
            Image(
                painter = painterResource(item.pic),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.heightIn(100.dp, 300.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = item.name,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "￥"+item.price.toString(),
                color = Color.Red
            )
        }
    }
}