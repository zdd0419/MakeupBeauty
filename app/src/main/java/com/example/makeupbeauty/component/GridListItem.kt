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

import com.example.makeupbeauty.data.model.storeItem

@Composable
fun GridListItem(
    item: storeItem,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current;
    Material3Card(
        shape = androidx.compose.material.MaterialTheme.shapes.medium,
        modifier = modifier
            .width(150.dp)
            .height(130.dp)
            .padding(25.dp)
//            .testTag("${TestTags.HOME_SCREEN_LIST_ITEM}-${item.id}")

    ) {
        Column(modifier = Modifier.clickable(onClick = {

        })) {
            Image(
                painter = painterResource(item.imageId),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .clickable(onClick ={context.startActivity(productDetailActivity.newIntent(context))} )
            )
            Column(modifier = Modifier.padding(1.dp)
                ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.caption.copy(fontSize = 7.sp),
//                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(5.dp,0.dp,0.dp,0.dp)
//                    textAlign = TextAlign.Center ,
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

