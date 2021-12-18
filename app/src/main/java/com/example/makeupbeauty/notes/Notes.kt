package com.example.makeupbeauty.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.R
import com.example.makeupbeauty.commodityDetail.PaymentView
import com.example.makeupbeauty.component.TopBarWithBack
import com.example.makeupbeauty.searchText
import com.example.makeupbeauty.ui.theme.*
import androidx.compose.material.Icon as Icon
val TitleText = mutableStateOf("")
val contentText = mutableStateOf("")
class Notes : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           notes()
        }
    }
}
@Preview
@Composable
fun notes(){
    MakeupBeautyTheme {
        Scaffold(
            topBar = {
                TopBarWithBack(
                    title ="编辑笔记",
                    onBackClick = {

                    },
                )
            }, backgroundColor = cottonBall,
            content = {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)) {
                        Pic(R.drawable.product)
                        IconButtonDemo()
                    }
                    addTitleSection()
                    addContent()
                    addButton()
                }
            })
    }



}

@Composable
fun Pic(
    imageID:Int
){

    Image(
        painter = painterResource(id = imageID),
        contentDescription = "avatar",
        modifier = Modifier
            .size(80.dp))

}


@Composable
fun IconButtonDemo() {
    IconButton(
        onClick = {},
        modifier = Modifier
            .height(80.dp)
            .width(80.dp)
    ) {

        Card(  modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .border(
                color = lightGrey,
                width = 1.dp,
                shape = RoundedCornerShape(10.dp)
            )
        )
        {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add pic",
                tint = grey,

            )
        }


    }
}

@Composable
fun addTitleSection() {
    TextField(
        value = TitleText.value,
        onValueChange = {
            TitleText.value = it
        },
        placeholder = {
            Text(text = "填写标题后会有更多赞哦~", color = Color(0xFF666666), fontSize = 20.sp)
        },
        modifier = Modifier
            .height(58.dp)
            .fillMaxWidth()
            .background(Color.White),
        textStyle = TextStyle(fontSize = 20.sp),
        //设置背景色为白色
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        singleLine = true,
    )
}

@Composable
fun addContent(){
    TextField(
        value = contentText.value,
        onValueChange = {
            contentText.value = it
        },
        placeholder = {
            Text(text = "添加正文", color = Color(0xFF666666), fontSize = 16.sp)
        },
        modifier = Modifier
            .height(258.dp)
            .fillMaxWidth()
            .background(Color.White),
        textStyle = TextStyle(fontSize = 20.sp),
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        singleLine = true,
    )
}


@Composable
fun addButton(){
    Button(
        onClick = {
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = orange),
        modifier = Modifier
            .width(300.dp)
            .padding(
                start = 100.dp,
                top = 4.dp,
                bottom = 34.dp
            ),
        shape = RoundedCornerShape(14.dp)
    ) {
        Text(
            text = "发布笔记",
            color = white,
            style = MaterialTheme.typography.button,
            fontSize=20.sp,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        )
}

}