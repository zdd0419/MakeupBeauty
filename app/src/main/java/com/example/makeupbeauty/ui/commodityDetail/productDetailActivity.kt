package com.example.makeupbeauty.commodityDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.makeupbeauty.CommunityPost.PostBottomBar
import com.example.makeupbeauty.R
import com.example.makeupbeauty.commodityDetail.ui.theme.MakeupBeautyTheme
import com.example.makeupbeauty.component.Carousel
import com.example.makeupbeauty.component.TopAppBarWithBack
import com.example.makeupbeauty.data.DemoDataProvider
import com.example.makeupbeauty.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

class productDetailActivity : ComponentActivity() {
    companion object {
        fun newIntent(context: Context) =
            Intent(context, productDetailActivity::class.java).apply { putExtra("product", true) }
    }
    @ExperimentalPagerApi
    @InternalCoroutinesApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ProductDetailsScreen({onBackPressed()})
                }
            }
        }
    }
}



@ExperimentalPagerApi
@InternalCoroutinesApi
@ExperimentalMaterialApi
@Preview
@Composable
fun ProductDetailsScreen(onClick:()->Unit = {}) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val context = LocalContext.current;
    Scaffold(
        topBar = {
            TopAppBarWithBack(
                onBackClick = {
                    onClick
                },
            )
        },
//        backgroundColor = lightgraybg,
//        floatingActionButton = {
//            float(coroutineScope, bottomSheetScaffoldState, sheetState)
//        },
        bottomBar = {
//            PostBottomBar(360, 65, 14)
            Row(){
                Button(
                    onClick = {
//                          context.startActivity(paymentActivity.newIntent(context))
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = yellow),
                    modifier = Modifier
                        .width(200.dp),
//                        .padding(
//                            top = 30.dp,
//                            bottom = 34.dp
//                        )
//                        ,
//                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = "立即购买",
                        color = white,
                        style = MaterialTheme.typography.button,
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                    )
                }

                Button(
                    onClick = {
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = orange),
                    modifier = Modifier
                        .width(200.dp),
//                        .padding(
//                            top = 30.dp,
//                            bottom = 34.dp
//                        ),
//                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = "加入购物车",
                        color = white,
                        style = MaterialTheme.typography.button,
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                    )
                }
            }

        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                ConstraintLayout {
                    val (imagesliderref, addtocartref) = createRefs()
                    Box(modifier = Modifier
                        .height(300.dp)
                        .constrainAs(imagesliderref) {
                            top.linkTo(imagesliderref.top)
                            bottom.linkTo(imagesliderref.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }) {
//                        HeaderImagesSlider()
                        Carousel(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(280.dp)
                                .padding(10.dp),
                            DemoDataProvider.productlist
                        )

                    }
                    Surface(
                        color = white,
//                        shape = RoundedCornerShape(40.dp)
//                            .copy(
//                                bottomStart = ZeroCornerSize,
//                                bottomEnd = ZeroCornerSize
//                            ),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 300.dp)
                            .constrainAs(addtocartref) {
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp)
                        ) {

                            ProductTitle()
                            Spacer(modifier = Modifier.padding(5.dp))
//                            Divider(color = lightGrey, thickness = 2.dp)
                            ProductAvailableSize()
                            Spacer(modifier = Modifier.padding(5.dp))
//                            Divider(color = lightGrey, thickness = 2.dp)
                            ProductItemColorWithDesc()


                        }


                    }

                }

            }
        }
    )

}

//悬浮
@ExperimentalMaterialApi
@Composable
fun float(coroutineScope: CoroutineScope,
          bottomSheetScaffoldState: BottomSheetScaffoldState,
          sheetState: ModalBottomSheetState){
    FloatingActionButton(
        onClick = {
            coroutineScope.launch {
                bottomSheetScaffoldState.bottomSheetState.expand()
            }

        },
        backgroundColor = orange
    ) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "Add To Cart",
            tint = white
        )
    }

}




@Composable
fun HeaderImagesSlider() {
    val showThumbImagesList = listOf<Int>(
        R.drawable.product,
        R.drawable.ysl1,
        R.drawable.ysl2,
        R.drawable.ysl3
    )

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
//        Image(
//            contentScale = ContentScale.Fit,
//            painter = painterResource(id = R.drawable.product),
//            contentDescription = "",
//            modifier = Modifier
//                .size(230.dp)
//        )

        headImage(imgid = R.drawable.product)

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),

            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(showThumbImagesList.size) { item ->
                Box(
                    modifier = Modifier
                        .height(60.dp)
                        .width(62.dp)
                        .border(
                            color = if (item == 0) orange else lightGrey,
                            width = 2.dp,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable {

                        }) {
                    Image(
                        painter = painterResource(showThumbImagesList[item]),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp, 50.dp)
                            .padding(
                                start = 10.dp,
                                end = 5.dp,
                                top = 5.dp,
                                bottom = 5.dp
                            )
                    )

                }
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }


}

@Composable
fun headImage(imgid:Int){
    Image(
        contentScale = ContentScale.Fit,
        painter = painterResource(id = imgid),
        contentDescription = "",
        modifier = Modifier
            .size(230.dp)
    )
}
@Composable
fun ProductTitle() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider(
            color = grey,
            modifier = Modifier
                .height(4.dp)
                .width(40.dp)
        )
        Spacer(modifier = Modifier.padding(5.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$ 350 ",
                    color = orange,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1,
                )
                Text(
                    text = "YSL圣罗兰小金条细管口红 ",
                    color = titleTextColor,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1,
                )

            }
        }


}

@Composable
fun ProductAvailableSize() {
    val itemListavailablesize = listOf("N196", "N21", "N28", "N32")
    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            text = "可选择的颜色分类",
            color = titleTextColor,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.padding(10.dp))

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(itemListavailablesize.size) { item ->
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(75.dp)
                        .border(
                            color = if (item == 1) orange else lightGrey,
                            width = 2.dp,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clickable { }) {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 20.dp,
                                end = 16.dp,
                                top = 10.dp,
                                bottom = 8.dp
                            ),
                        text = itemListavailablesize[item],
                        fontWeight = FontWeight.Bold,
                        color = if (item == 1) titleTextColor else Color.LightGray
                    )


                }
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }



}

@Composable
fun ProductItemColorWithDesc() {
    Card(shape = RoundedCornerShape(3.dp),
        elevation = 2.dp) {
        Column(modifier = Modifier
            .fillMaxWidth()
        ) {
            Text(
                text = "用户评价",
                color = titleTextColor,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.padding(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                ,
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalAlignment = Alignment.CenterVertically,

                ) {

                val modifier=Modifier
                FavIcon(modifier)
                FavIcon(modifier)
                FavIcon(modifier)
                FavIcon(modifier)
                FavIcon(modifier)

            }


            Spacer(modifier = Modifier.padding(10.dp))
            Divider(color = lightGrey, thickness = 2.dp)
            Row() {
                Text(
                    text = "评论",
                    color = titleTextColor,
                    fontSize = 18.sp
                )

                dropdownMenuTest()
            }
            Divider(color = lightGrey, thickness = 2.dp)

//            Spacer(modifier = Modifier.padding(5.dp))
            Column(modifier = Modifier
                .fillMaxWidth()
            ) {
                commentCard(R.drawable.avatar, "test longest", "1", 0, 0)
                Divider(color = lightGrey, thickness = 2.dp)
                commentCard(R.drawable.avatar, "test longest", "1", 0, 0)
                Divider(color = lightGrey, thickness = 2.dp)
                commentCard(R.drawable.avatar, "test longest", "1", 0, 0)
                Divider(color = lightGrey, thickness = 2.dp)
                commentCard(R.drawable.avatar, "test longest", "1", 0, 0)
            }

        }
    }


//        Text(
//            text = stringResource(id = R.string.product_text_description),
//            color = lightblack,
//            fontSize = 14.sp
//        )


}





@Composable
fun dropdownMenuTest(){
    val expandState = remember {
        mutableStateOf(false)
    }
    Column() {
        Button(
            modifier = Modifier
                .padding(start = 220.dp, top = 2.dp, end = 2.dp)
                .size(width = 50.dp, height = 18.dp)
                .alpha(0.5f),
            onClick = {
                expandState.value = true
            }) {
            Text(text = "按时间", fontSize = 12.sp)
        }
        DropdownMenu(
            expanded = expandState.value,
            onDismissRequest = {
                Log.e("ccm","执行了Request")
                expandState.value = false
            },
            offset = DpOffset(20.dp,10.dp),
            properties = PopupProperties()
        ) {
            dropdownMenuItemTest(expandState,Icons.Filled.Favorite,"按时间")
            dropdownMenuItemTest(expandState,Icons.Filled.Edit,"按星级")
        }
    }
}


@Composable
fun dropdownMenuItemTest(state: MutableState<Boolean>, icon: ImageVector, text:String){
    val interactionSource = remember { MutableInteractionSource() }
    val pressState = interactionSource.collectIsPressedAsState()
    val focusState = interactionSource.collectIsFocusedAsState()
    DropdownMenuItem(
        onClick = {
            state.value = false
        },
        enabled = true,
        interactionSource = interactionSource
    ) {
        Icon(imageVector = icon, contentDescription = text,tint = if(pressState.value || focusState.value) Color.Red else Color.Black)
        Text(text = text,modifier = Modifier.padding(start = 2.dp),color = if(pressState.value || focusState.value) Color.Red else Color.Black)
    }
}

//添加用户评价的爱心
@Composable
fun FavIcon(modifier: Modifier = Modifier) {
    val isFavourite = remember { mutableStateOf(true) }
    IconToggleButton(
        checked = isFavourite.value,
        onCheckedChange = { isFavourite.value = !isFavourite.value }
    ) {
        if (isFavourite.value) {
            Icon(
//                imageVector = Icons.Filled.Favorite,
                imageVector = Icons.Outlined.Favorite,
                contentDescription = null,
                modifier = modifier,
                tint = orange
            )
        } else {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = modifier
            )
        }
    }
}

//头像部分
@Composable
fun commentCard(imageid: Int, name: String, vip: String, prefer: Int, fans: Int) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp, 24.dp, 0.dp, 8.dp)
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
                    Text(text = name, fontWeight = FontWeight.ExtraBold, fontSize = 15.sp)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = "vip "+vip,color = Color.Cyan, textAlign = TextAlign.Center, fontSize = 14.sp)
                }
                Spacer(
                    Modifier
                        .height(8.dp)
                )

                Text(text = "非常喜欢！ ",fontSize = 15.sp)
            }
        }
    }
}



//@ExperimentalMaterialApi
//@Preview
//@Composable
//fun PreviewDetailScreen() {
//    val product = productData.productList
//    MakeupBeautyTheme(true) {
//        ProductDetailsScreen()
//    }
//
//}


