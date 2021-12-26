package com.example.makeupbeauty.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.commodityDetail.productDetailActivity
import com.example.makeupbeauty.data.detail

import com.example.makeupbeauty.data.model.storeItem
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun GridListItem(

    item: detail,
    modifier: Modifier = Modifier,
    onClick:()->Unit = {}
) {
    val context = LocalContext.current;
    val painter = rememberCoilPainter(item.allimage[0])
    Material3Card(
        shape = androidx.compose.material.MaterialTheme.shapes.medium,
        modifier = modifier
            .width(280.dp)
            .height(250.dp)
            .padding(8.dp)
//            .testTag("${TestTags.HOME_SCREEN_LIST_ITEM}-${item.id}")

    ) {
        Column(modifier = Modifier.clickable(onClick = {

        })) {
            Image(
                painter = painter,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
                    .clickable(onClick =onClick )
                    .align(Alignment.CenterHorizontally)
            )
            Column(modifier = Modifier.padding(1.dp)
                .align(Alignment.CenterHorizontally)
                ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.caption.copy(fontSize = 12.sp),
//                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center
//                    modifier = Modifier.padding(4.dp,1.dp,8.dp,0.dp)

                )
//                Text(
//                    text = item.subtitle,
//                    maxLines = 3,
//                    overflow = TextOverflow.Ellipsis,
//                    style = MaterialTheme.typography.body1
//                )
//                Text(
//                    text = item.source,
//                    style = MaterialTheme.typography.body2
//                )

            }
        }
    }
}

