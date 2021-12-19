package com.example.makeupbeauty.commodityDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.R
import com.example.makeupbeauty.ui.theme.grey
import com.example.makeupbeauty.ui.theme.orange
import com.example.makeupbeauty.ui.theme.white

@Composable
fun chooseProduct(){
    val context = LocalContext.current;
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
           productDetail(labTitle = "￥300", imageid = R.drawable.product)
        }
        productCatagory()
        productNumber()
        Button(
            onClick = {
//                      context.startActivity(paymentActivity.newIntent(context))
            },

            colors = ButtonDefaults.buttonColors(backgroundColor = orange),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 30.dp,
                    bottom = 34.dp
                )
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text(
                text = "确认",
                color = white,
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
        }
    }


}
//添加购买数量
@Composable
fun productNumber(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,

        ) {

        Text(
            text="购买数量",
            fontSize = 20.sp
        )
        Icon(
            imageVector = Icons.Default.RemoveCircle,
            modifier = Modifier.padding(220.dp, 0.dp,0.dp,0.dp),
            contentDescription = null,
            tint= grey
        )
        //这个购买数量默认为1
        Text(
            text="1",
//            modifier = Modifier.padding(100.dp, 5.dp),
            color = orange,
            fontSize = 20.sp
        )
        //点击这个图标购买数量应该相应减少
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = null,
            tint= grey
        )
    }
}

@Composable
fun productDetail(
    labTitle:String,
    imageid: Int,
    onClick:()->Unit = {}
){
    Card(
        modifier = Modifier
            .padding(10.dp) // 外边距
            .clickable(onClick = onClick)
            .fillMaxWidth()
        ,

        // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
        // 将无法显示波纹效果

        elevation = 6.dp // 设置阴影
    ) {
        Row(
            modifier = Modifier.padding(10.dp) // 内边距
        ) {

            Image(painter = painterResource(id = imageid),
                contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
            )

            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Red)
                    ) {
                        append(labTitle)
                    }
                }
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
            )
        }
    }
}

@Composable
fun productCatagory(
    onClick:()->Unit = {}
){
    Card(
        modifier = Modifier
            .padding(1.dp) // 外边距
            .clickable(onClick = onClick)
            .fillMaxWidth()
        ,

        // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
        // 将无法显示波纹效果

        elevation = 6.dp // 设置阴影
    ) {
        Column(
            modifier = Modifier.padding(10.dp) // 内边距
        ) {

           Card(
               modifier = Modifier
                   .padding(10.dp) // 外边距
                   .clickable(onClick = onClick)
                   .fillMaxWidth(),

               // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
               // 将无法显示波纹效果

               elevation = 6.dp // 设置阴影
         ) {

               Text(
                   text="N19",
                   fontSize = 20.sp
               )
        }

            Card(
                modifier = Modifier
                    .padding(10.dp) // 外边距
                    .clickable(onClick = onClick)
                    .fillMaxWidth(),

                // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
                // 将无法显示波纹效果

                elevation = 6.dp // 设置阴影
            ) {

                Text(
                    text="N20",
                    fontSize = 20.sp
                )
            }

        }
    }
}


//
//@Composable
//fun productList() {
//    Divider(color = Color.LightGray, thickness = 0.8f.dp)
//    productListItem("N19", "$350")
//    Divider(color = Color.LightGray, thickness = 0.8f.dp)
//    productListItem("N19", "$350")
//    Divider(color = Color.LightGray, thickness = 0.8f.dp)
//    productListItem("N19", "$350")
//    Divider(color = Color.LightGray, thickness = 0.8f.dp)
//    productListItem("N19", "$350")
//    Divider(color = Color.LightGray, thickness = 0.8f.dp)
//
//}

//@Composable
//fun productListItem(
//    title: String,
//    price:String,
//    badge: @Composable (() -> Unit)? = null,
//    endBadge: @Composable (() -> Unit)? = null
//) {
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(60.dp)
//            .background(Color.White),
//        verticalAlignment = Alignment.CenterVertically,
//
//    ) {
//
//        Text(
//            title,
//            fontSize = 20.sp
//        )
//
//        Text(
//            price,
//            modifier=Modifier.padding(100.dp,5.dp),
//            color = orange,
//            fontSize = 20.sp
//        )
//        badge?.invoke()
//        Spacer(Modifier.weight(1f))
//        endBadge?.invoke()
//
//    }
//
//
//}

@Preview(showBackground = true)
@Composable
fun chooseProductChoose(){
    chooseProduct()
}