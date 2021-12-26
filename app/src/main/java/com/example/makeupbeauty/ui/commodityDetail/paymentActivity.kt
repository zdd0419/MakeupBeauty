package com.example.makeupbeauty.commodityDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.makeupbeauty.commodityDetail.ui.theme.MakeupBeautyTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.TopAppBarWithBack
import com.example.makeupbeauty.component.TopBarWithBack
import com.example.makeupbeauty.ui.theme.*
import com.google.accompanist.coil.rememberCoilPainter


class paymentActivity : ComponentActivity() {
    companion object {
        fun newIntent(context: Context) =
            Intent(context, paymentActivity::class.java).apply { putExtra("payment", true) }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle:Bundle?=intent.extras
        var title: String? = "123"
        var price: Double = 0.0
        var category:String? = ""
        var photos:String? = ""
        if(bundle!=null) {
            title = bundle!!.getString("title")
            price = bundle!!.getDouble("price")
            category =bundle!!.getString("catagory")
            photos =bundle!!.getString("photos")
        }
        setContent {
            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PaymentView(title,price,category,photos)
                }
            }
        }
    }
}



@Composable
fun PaymentView(title:String?,price:Double,category:String?,photos:String?) {
    val intent = Intent(LocalContext.current, MyoderActivity::class.java)
    intent.putExtra("price",price)
    intent.putExtra("title", title)
    intent.putExtra("catagory", category)
    //intent.putExtra("product_id", product_detailViewlmodel.setId(item))
    intent.putExtra("photos", photos)
    com.example.makeupbeauty.ui.theme.MakeupBeautyTheme {
        Scaffold(
            topBar = {
                TopBarWithBack(
                    title = stringResource(R.string.title_activity_payment),
                    onBackClick = {

                    },
                )
            }, backgroundColor = cottonBall,
            content = {
                LazyColumn() {
                    item {
                        Owner(
                            imageid = R.drawable.avatar,
                            name = "蛋蛋",
                            address = "北京交通大学南门",
                            phoneNumber = "18907763271"
                        )

                        ProductItemList(title,price,category,photos)
                        pay()
                        total(1, 350.00,intent)
                    }

                }

            })

    }
}



@Composable
fun Owner(imageid: Int, name: String, address: String,phoneNumber:String) {
    Card(shape = RoundedCornerShape(6.dp),
        elevation = 5.dp) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp, 2.dp, 0.dp, 8.dp)
            .height(height = 100.dp), Alignment.CenterStart) {
            Row(modifier = Modifier) {
                Image(
                    painter = painterResource(id = imageid),
                    contentDescription = "avatar",
                    modifier = Modifier
                        .padding(12.dp)
                        .clip(CircleShape)
                        .size(40.dp))

                Column() {
                    Spacer(
                        Modifier
                            .height(12.dp)
                    )
                    Row(modifier = Modifier.padding(horizontal = 4.dp), Arrangement.Center) {
                        Text(text = name, fontWeight = FontWeight.ExtraBold, fontSize = 17.sp)
                        Spacer(modifier = Modifier.padding(4.dp))
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = phoneNumber, fontSize = 10.sp,color= grey)
                    }
                    Spacer(
                        Modifier
                            .height(5.dp)
                    )
                    Row(modifier = Modifier.padding(horizontal = 4.dp)) {
                        Text(text = "地址: "+ address, fontSize = 15.sp)
                        Spacer(modifier = Modifier.padding(16.dp))
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null,
                            modifier=Modifier.size(16.dp),
                            tint= grey
                        )
                    }
                }
            }
        }
    }

}


//购买的商品详情信息
@Composable
fun product(
    imagePainter: Painter,
    title: String = "",
    price: Double = 0.0,
    pricetag: String = "",
    count: String = "",
    prodcutCatagory:String="",
    backgroundColor: Color = Color.Transparent
) {
    Card(shape = RoundedCornerShape(6.dp),
        elevation = 5.dp) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            item {
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(50.dp)
                        .fillMaxWidth(0.2f)
                        .clip(RoundedCornerShape(20.dp))
                        .background(backgroundColor),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = imagePainter,
                        contentDescription = "",
                        modifier = Modifier.padding(8.dp),
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = title,
                        fontSize = 10.sp,
                        color = titleTextColor,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text=prodcutCatagory,fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(150.dp))
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        orange,
                                        fontWeight = FontWeight.Bold
                                    )
                                ) {
                                    append(pricetag)
                                }
                                withStyle(
                                    style = SpanStyle(
                                        titleTextColor
                                    )
                                ) {
                                    append(price.toString())
                                }
                            },
                            style = MaterialTheme.typography.subtitle1,
                            modifier = Modifier,
                            fontSize = 16.sp

                        )
                        Box(
                            modifier = Modifier
                                .size(35.dp, 35.dp)
                                .clip(CircleShape)
                                .background(backgroundColor),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = count,
                                fontSize = 14.sp,
                                color = titleTextColor
                            )
                        }

                    }

                    productAddNumber(count)
//                        Spacer(modifier = Modifier.width(150.dp))
                    Row {
                        Text(
                            text = "共" + count + "件" ,
                            fontSize = 14.sp,
//                            modifier=Modifier.padding(20.dp,2.dp,0.dp,0.dp),
                            color = titleTextColor
                        )
                        Text(
                            text = " ￥"+price,
                            fontSize = 14.sp,
                            modifier=Modifier.padding(20.dp,0.dp,0.dp,0.dp),
                            color = red
                        )

                    }
                }
            }

        }
    }
}

@Composable
fun ProductItemList(title:String?,price:Double,category:String?,photos:String?) {
    val painter = rememberCoilPainter(photos)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        if (title != null) {
            product(
                imagePainter = painter,
                title = title,
                price = price,
                pricetag = "$",
                count = "x1",
                prodcutCatagory="N19",
                backgroundColor = lightsilverbox
            )
        }

    }
}


//添加购买数量
@Composable
fun productAddNumber(
    buyNumber:String=""
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,

        ) {

        Text(
            text="购买数量",
            fontSize = 14.sp
        )
        Icon(
            imageVector = Icons.Default.RemoveCircle,
            modifier = Modifier.padding(140.dp, 0.dp,0.dp,0.dp),
            contentDescription = null,
            tint= grey
        )
        //这个购买数量默认为1
        Text(
            text=buyNumber,
//            modifier = Modifier.padding(100.dp, 5.dp),
            color = orange,
            fontSize = 14.sp
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
fun pay(){
    Card(shape = RoundedCornerShape(6.dp),
        elevation = 5.dp){
        Column(modifier = Modifier
            .fillMaxWidth()) {
            Text(text = "支付方式", fontWeight = FontWeight.ExtraBold, fontSize = 17.sp)
            Row(){
                Image(
                    painter = painterResource(R.drawable.zhufubao),
                    modifier = Modifier.fillMaxWidth(0.08f),
                    contentDescription = stringResource(R.string.text_mastercard_image),
                )
                Spacer(modifier = Modifier.width(330.dp))
                Icon(
                    imageVector = Icons.Filled.Circle,
                    contentDescription = null,
                    tint = lightGrey
                )

            }

            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = lightGrey, thickness = 1.dp)
            Row(){
                Image(
                    painter = painterResource(R.drawable.wechat),
                    modifier = Modifier.fillMaxWidth(0.08f),
                    contentDescription = stringResource(R.string.text_mastercard_image),
                )
                Spacer(modifier = Modifier.width(330.dp))
                Icon(
                    imageVector = Icons.Filled.Circle,
                    contentDescription = null,
                    tint = lightGrey
                )

            }


            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = lightGrey, thickness = 1.dp)
            Row(){
                Image(
                    painter = painterResource(R.drawable.bank),
                    modifier = Modifier.fillMaxWidth(0.1f),
                    contentDescription = stringResource(R.string.text_mastercard_image),
                )
                Spacer(modifier = Modifier.width(322.dp))
                Icon(
                    imageVector = Icons.Filled.Circle,
                    contentDescription = null,
                    tint = lightGrey
                )
            }


        }
    }
}


//总计
@Composable
fun total(totalCount:Int=0,
          price:Double=0.00,
          intent:Intent
){
    val context = LocalContext.current;
    Row(modifier = Modifier
        .fillMaxWidth()) {
        Row {
            Text(
                text = "共" + totalCount + "件" ,
                fontSize = 20.sp,
//                            modifier=Modifier.padding(20.dp,2.dp,0.dp,0.dp),
                color = grey,
                modifier = Modifier.padding(start=30.dp,top = 20.dp, bottom = 8.dp)
            )
            Text(
                text = " ￥"+price,
                fontSize = 20.sp,
                modifier=Modifier.padding(10.dp,20.dp,8.dp,0.dp),
                color = red
            )

        }

        Button(
            onClick = {
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = orange),
            modifier = Modifier
                .width(200.dp)

                .padding(
                    start = 30.dp,
                    top = 4.dp,
                    bottom = 34.dp
                ),

            shape = RoundedCornerShape(14.dp)
        ) {
            Text(
                text = "提交订单",
                color = white,
                style = MaterialTheme.typography.button,
                fontSize=20.sp,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
        }
    }

}