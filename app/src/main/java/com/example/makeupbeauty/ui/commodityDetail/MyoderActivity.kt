package com.example.makeupbeauty.commodityDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.ButtonState
import com.example.makeupbeauty.component.TopBarWithBack
import com.example.makeupbeauty.data.detail
import com.example.makeupbeauty.ui.Screens.ChatListScreen
import com.example.makeupbeauty.ui.Screens.ShowDialog
import com.example.makeupbeauty.ui.theme.*
import com.example.makeupbeauty.viewModel.product_detailViewlModel
import com.google.accompanist.coil.rememberCoilPainter
import com.zhangke.websocket.util.LogUtil


class MyoderActivity : ComponentActivity() {

    companion object {
        fun newIntent(context: Context) =
            Intent(context, MyoderActivity::class.java).apply { putExtra("myOder", true) }
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

        if (title != null) {
            Log.e("Receive: ", title)
        } else
            Log.e("Receive: ", "NULL!!!!")

        setContent {
            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    oderAc(
                        title,
                        price,
                        category,
                        photos
                    )
                }
            }
        }
    }
}

@Composable
fun oderAc(title:String?,price:Double,category:String?,photos:String?) {
    com.example.makeupbeauty.ui.theme.MakeupBeautyTheme {
        Scaffold(
            topBar = {
                TopBarWithBack(
                    title = "我的订单",
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
                OderItemList(title,price,category,photos)
            })
    }
}


@Composable
fun OderItemList(title:String?,price:Double,category:String?,photos:String?) {
    val product_detailViewlmodel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<product_detailViewlModel>()
    val painter = rememberCoilPainter(photos)
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        item{
            if (title != null) {
                oderItems(
                    imagePainter = painter,
                    title = title,
                    price = price,
                    pricetag = "$",
                    count = "x1",
                    backgroundColor = lightsilverbox
                )
            }
            oderItems(
                imagePainter = painterResource(id = R.drawable.dior1),
                title = "迪奥精华水",
                price = 600.00,
                pricetag = "$",
                count = "x1",
                backgroundColor = lightsilverbox
            )
            oderItems(
                imagePainter = painterResource(id = R.drawable.khcard),
                title = "迪奥口红",
                price = 350.00,
                pricetag = "$",
                count = "x1",
                backgroundColor = lightsilverbox

            )
        }



    }
}
data class ButtonState(var text: String, var textColor: Color, var buttonColor: Color)

@Composable
fun oderItems(
    imagePainter: Painter,
    title: String = "",
    price: Double =0.00,
    pricetag: String = "",
    count: String = "",
    backgroundColor: Color = Color.Transparent
) {
    val context = LocalContext.current;
    val alertDialog = remember { mutableStateOf(false) }
    val isChoose = remember { mutableStateOf(true) }



    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        item {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(200.dp)
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
                    .padding(horizontal = 16.dp),
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

                Text(
                    text = "收货地址：北京交通大学南门",
                    fontSize = 14.sp,
                    color = titleTextColor
                )

                Button(
                    onClick = {
                        alertDialog.value = true
                    },

                    colors = ButtonDefaults.buttonColors(backgroundColor = orange),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 170.dp,
                            top = 30.dp,
//                            bottom = 34.dp,
//                            end=10.dp

                        )
                        .align(Alignment.CenterHorizontally)
                        .clickable {

                        },
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = "" +
                                "确认收货",
                        color = white,
                        style = MaterialTheme.typography.button,
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                        fontSize = 10.sp,

                    )
                }

            }
        }

    }
    ShowDialog(alertDialog)
}


