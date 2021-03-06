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
import com.example.makeupbeauty.commodityDetail.ui.theme.MakeupBeautyTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita

import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.TopBarWithBack
import com.example.makeupbeauty.ui.theme.*
import com.example.makeupbeauty.viewModel.CartViewModel
import com.example.makeupbeauty.viewModel.OrderViewModel
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
    val cartViewmodel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<CartViewModel>()
    val payList = cartViewmodel.payItemList
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
                Box() {
                    LazyColumn() {
                        item {
                            Owner(
                                imageid = R.drawable.avatar,
                                name = "??????",
                                address = "????????????????????????",
                                phoneNumber = "18907763271"
                            )
                            payList.forEach {
                                ProductItemList(it.title,it.price,it.count,it.imagePainter)
                                cartViewmodel.removeFromCart(it.id)
                            }
                            pay()
                            total(payList.size, cartViewmodel.getTotalPriceInOrder(),intent)
                        }
//                    item {
//
//                    }
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
                        Text(text = "??????: "+ address, fontSize = 15.sp)
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


//???????????????????????????
@Composable
fun product(
    imagePainter: Painter,
    title: String = "",
    price: Double = 0.0,
    pricetag: String = "",
    count: Int = 1,
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
                                text = "x$count",
                                fontSize = 14.sp,
                                color = titleTextColor
                            )
                        }

                    }

                    productAddNumber(count)
//                        Spacer(modifier = Modifier.width(150.dp))
                    Row {
                        Text(
                            text = "???" + count + "???" ,
                            fontSize = 14.sp,
//                            modifier=Modifier.padding(20.dp,2.dp,0.dp,0.dp),
                            color = titleTextColor
                        )
                        Text(
                            text = "???$price",
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
fun ProductItemList(title:String?,price:Double,count:Int,photos:String?) {
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
                pricetag = "???",
                count = count,
                prodcutCatagory="",
                backgroundColor = lightsilverbox
            )
        }

    }
}


//??????????????????
@Composable
fun productAddNumber(
    buyNumber:Int=1
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,

        ) {

        Text(
            text="????????????",
            fontSize = 14.sp
        )
        Icon(
            imageVector = Icons.Default.RemoveCircle,
            modifier = Modifier.padding(140.dp, 0.dp,0.dp,0.dp),
            contentDescription = null,
            tint= grey
        )
        //???????????????????????????1
        Text(
            text="x$buyNumber",
//            modifier = Modifier.padding(100.dp, 5.dp),
            color = orange,
            fontSize = 14.sp
        )
        //????????????????????????????????????????????????
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
            Text(text = "????????????", fontWeight = FontWeight.ExtraBold, fontSize = 17.sp)
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


//??????
@Composable
fun total(totalCount:Int=0,
          price:Double=0.00,
          intent:Intent
){
    val cartViewmodel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<CartViewModel>()
    val OrderViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<OrderViewModel>()
    val payList = cartViewmodel.payItemList
    val context = LocalContext.current;
    Row(modifier = Modifier
        .fillMaxWidth()) {
        Row {
            Text(
                text = "???" + totalCount + "???" ,
                fontSize = 20.sp,
//                            modifier=Modifier.padding(20.dp,2.dp,0.dp,0.dp),
                color = grey,
                modifier = Modifier.padding(start=30.dp,top = 20.dp, bottom = 8.dp)
            )
            Text(
                text = "???$price",
                fontSize = 20.sp,
                modifier=Modifier.padding(10.dp,20.dp,8.dp,0.dp),
                color = red
            )

        }

        Button(
            onClick = {
                payList.forEach {
                    OrderViewModel.addOrder(
                        title = it.title,
                        price = it.price,
                        count = it.count,
                        address = "????????????:????????????????????????",
                        status = "?????????",
                        image = it.imagePainter
                    )
                }
                payList.clear()
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
                text = "????????????",
                color = white,
                style = MaterialTheme.typography.button,
                fontSize=20.sp,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
        }
    }

}