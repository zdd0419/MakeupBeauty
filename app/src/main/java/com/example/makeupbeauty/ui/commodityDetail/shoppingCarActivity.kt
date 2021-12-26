package com.example.makeupbeauty.commodityDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import com.example.makeupbeauty.commodityDetail.ui.theme.MakeupBeautyTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.R
import com.example.makeupbeauty.ui.theme.*
import com.google.accompanist.coil.rememberCoilPainter
import androidx.compose.material.Icon as Icon

class shoppingCarActivity : ComponentActivity() {
    companion object {
        fun newIntent(context: Context) =
            Intent(context, shoppingCarActivity::class.java).apply { putExtra("chopCar", true) }
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
                    AddToCartScren(title,
                        price,
                        category,
                        photos)

                }
            }
        }
    }
}



@Composable
fun AddToCartScren(title:String?,price:Double,category:String?,photos:String?) {
    val intent = Intent(LocalContext.current, paymentActivity::class.java)
    intent.putExtra("price",price)
    intent.putExtra("title", title)
    intent.putExtra("catagory", category)
    //intent.putExtra("product_id", product_detailViewlmodel.setId(item))
    intent.putExtra("photos", photos)
    MakeupBeautyTheme {
        Scaffold(
            topBar = {
                CarWithBack(
                    title = "购物车",
                    onBackClick = {

                    },
                )
            }, backgroundColor = cottonBall,
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(30.dp)
                    ) {
//            TopAppBarHeader()
//                        Spacer(modifier = Modifier.padding(5.dp))
//                        DeleteCart()
//                        Spacer(modifier = Modifier.padding(20.dp))
                        CartItemList(title,
                            price,
                            category,
                            photos)
                        Spacer(modifier = Modifier.padding(20.dp))
                        NextButtonWithTotalItems(intent)
                    }
                }
            })
    }
}



@Composable
fun DeleteCart() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = titleTextColor,
                            fontSize = 24.sp
                        )
                    ) {
                        append("购物车")
                    }

                }
            }
        )


    }
}

@Composable
fun CarWithBack(title: String, onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onBackClick() }) {
            Icon(
                modifier = Modifier.size(32.dp, 32.dp),
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "",
                tint = black
            )
        }

        Text(
            text = title,
            color = eveningGlory,
            modifier = Modifier.padding(start = 16.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
        )
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Outlined.Delete,
                contentDescription = "",
                tint = orange
            )

        }

    }

}

@Composable
fun CartItemList(title:String?,price:Double,category:String?,photos:String?) {
    val painter = rememberCoilPainter(photos)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        if (title != null) {
            ProductCartItems(
                imagePainter = painter,
                title = title,
                price = price,
                pricetag = "$",
                count = "x1",
                backgroundColor = lightsilverbox
            )
        }
        ProductCartItems(
            imagePainter = painterResource(id = R.drawable.dior1),
            title = "迪奥精华水",
            price = 600.00,
            pricetag = "$",
            count = "x1",
            backgroundColor = lightsilverbox
        )
        ProductCartItems(
            imagePainter = painterResource(id = R.drawable.khcard),
            title = "迪奥口红",
            price = 350.00,
            pricetag = "$",
            count = "x1",
            backgroundColor = lightsilverbox
        )

    }
}

@Composable
fun ProductCartItems(
    imagePainter: Painter,
    title: String = "",
    price: Double = 0.0,
    pricetag: String = "",
    count: String = "",
    backgroundColor: Color = Color.Transparent
) {
    val isChoose = remember { mutableStateOf(true) }
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        item {
            IconToggleButton(
                checked = isChoose.value,
                onCheckedChange = { isChoose.value = !isChoose.value }
            ) {
                if (isChoose.value) {
                    Icon(
                        imageVector = Icons.Filled.Circle,
                        contentDescription = null,
                        tint = lightGrey
                    )
                } else {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "",
                        tint = Color.Green
                    )
                }
            }
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
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
                    fontSize = 18.sp,
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

            }
        }

    }
}

@Composable
fun NextButtonWithTotalItems(intent:Intent) {
    val context = LocalContext.current;
    Column(modifier = Modifier.fillMaxWidth()) {
        Divider(color = lightGrey, thickness = 2.dp)
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "3 Items",
                fontSize = 14.sp,
                color = lightGrey
            )

            Text(
                text = "$1300.00",
                fontSize = 18.sp,
                color = titleTextColor,
                fontWeight = FontWeight.Bold
            )
        }

        Button(
            onClick = {
                context.startActivity(intent)
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
                text = "结算",
                color = white,
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
        }

    }
}
