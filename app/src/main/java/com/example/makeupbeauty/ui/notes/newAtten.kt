package com.example.makeupbeauty.notes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.component.TopBarWithBack
import com.example.makeupbeauty.notes.data.NotesDateProvoder
import com.example.makeupbeauty.notes.data.newAttention
import com.example.makeupbeauty.ui.theme.*

@Preview
@Composable
fun newAtten() {
    MakeupBeautyTheme {
        Scaffold(
            topBar = {
                TopBarWithBack(
                    title = "新增关注",
                    onBackClick = {

                    },
                )
            }, backgroundColor = cottonBall,
            content = {
//                LazyColumn() {
//                    item {
//
//                    }
//                }
                cardNew()
            })
    }
}

@Composable
fun cardNew(){
    val list = remember { NotesDateProvoder.newatten }
    LazyColumn {
        items(
            items = list,
            itemContent = { item -> ListItem(item = item)
            }
        )
    }
}



@Composable
fun ListItem(item: newAttention, modifier: Modifier = Modifier) {
    val isFavourite = remember { mutableStateOf(true) }
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp, 24.dp, 0.dp, 8.dp)
                .height(height = 80.dp), Alignment.CenterStart
        ) {
            Row(modifier = Modifier) {
                Image(
                    painter = painterResource(id = item.imageID),
                    contentDescription = "avatar",
                    modifier = Modifier
                        .padding(12.dp)
                        .clip(CircleShape)
                        .size(60.dp)
                )

                Column() {
                    Spacer(
                        Modifier
                            .height(12.dp)
                    )
                    Row(modifier = Modifier.padding(horizontal = 4.dp), Arrangement.Center) {
                        Text(text = item.name, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
                        Spacer(modifier = Modifier.padding(4.dp))
                    }
                    Spacer(
                        Modifier
                            .height(8.dp)
                    )

                    Text(text = "关注了你", fontSize = 10.sp, color = grey)
                }
                Spacer(modifier = Modifier.padding(90.dp))

                Card(
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .padding(end=8.dp),
                    shape = RoundedCornerShape(3.dp),
                    elevation = 2.dp,

                    ) {
                    Column(modifier=Modifier.fillMaxWidth().height(40.dp)) {
                        IconToggleButton(
                            checked = isFavourite.value,
                            onCheckedChange = { isFavourite.value = !isFavourite.value }
                        ) {
                            if (isFavourite.value) {
                                Icon(
                                    imageVector = Icons.Outlined.Favorite,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(2.dp),
                                    tint = red,
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(2.dp)
                                )
                            }
                        }

                        Text(text = "回粉", fontSize = 10.sp, modifier = Modifier.padding(start=15.dp))
                    }

                }


            }







//
        //            Text(text = "12:17", modifier = Modifier.padding( start=320.dp,top=1.dp),color= grey)

    }



    }
}




