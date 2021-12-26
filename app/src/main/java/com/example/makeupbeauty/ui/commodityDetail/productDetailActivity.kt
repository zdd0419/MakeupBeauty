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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Settings
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.constraintlayout.compose.ConstraintLayout
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.example.makeupbeauty.R
import com.example.makeupbeauty.commodityDetail.ui.theme.MakeupBeautyTheme
import com.example.makeupbeauty.component.Carousel
import com.example.makeupbeauty.component.TopAppBarWithBack
import com.example.makeupbeauty.ui.theme.*
import com.example.makeupbeauty.viewModel.product_detailViewlModel
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

val product_detailViewlmodel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<product_detailViewlModel>()
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
//                    ProductDetailsScreen({onBackPressed()})
                    gotoShopCar()
                }
            }
        }
    }
}



@ExperimentalPagerApi
@InternalCoroutinesApi
@ExperimentalMaterialApi

@Composable
fun ProductDetailsScreen(expand: suspend () -> Unit,onClick:()->Unit = {}) {
    val context = LocalContext.current;
    Scaffold(
        topBar = {
            TopAppBarWithBack(
                onBackClick = {
                },
            )
        },
//        backgroundColor = lightgraybg,
//        floatingActionButton = {
//            float(coroutineScope, bottomSheetScaffoldState, sheetState)
//        },
        bottomBar = {
//            PostBottomBar(360, 65, 14)
            Row {
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
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp).clickable (
                            onClick={

                                context.startActivity(MyoderActivity.newIntent(context))}
                                )




                    )
                }


                val coroutineScope = rememberCoroutineScope()
                val expandSheet : () -> Unit = {
                    coroutineScope.launch {
                        expand()
                    }
                }

                Button(
                    onClick = expandSheet,
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
                        .height(350.dp)
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
                                .height(350.dp)
                                .padding(10.dp),
                            product_detailViewlmodel.getItem().allimage,

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

@InternalCoroutinesApi
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun gotoShopCar(){
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed
        )
    )

    BottomSheetScaffold(
        sheetContent = {
            // The content you want to show in your bottom sheet
            chooseProduct()
        },
        scaffoldState = bottomSheetScaffoldState) {
        // The content you want to show in your screen

        ProductDetailsScreen(expand = suspend {
            bottomSheetScaffoldState.bottomSheetState.collapse()
        })
    }

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
                    text = "$"+product_detailViewlmodel.getItem().price,
                    color = orange,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1,
                )
                Text(
                    text = product_detailViewlmodel.getItem().title,
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
            items(product_detailViewlmodel.getItem().allcatagory.size) { item ->
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(75.dp)
                        .border(
                            color = orange,
                            width = 2.dp,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clickable {

                        }) {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 20.dp,
                                end = 16.dp,
                                top = 10.dp,
                                bottom = 8.dp,
                            ),
                        text = product_detailViewlmodel.getItem().allcatagory[item],
                        fontWeight = FontWeight.Bold,
                        color =  titleTextColor  ,
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
                    fontSize = 24.sp
                )

//                dropdownMenuTest()
            }
            Divider(color = lightGrey, thickness = 2.dp)

//            Spacer(modifier = Modifier.padding(5.dp))
            Column(modifier = Modifier
                .fillMaxWidth()
            ) {
                commentCard(R.drawable.profile4, "蛋蛋", "10", 0, 0,"这新上新的口红好棒！姐妹们快冲！")
                Divider(color = lightGrey, thickness = 2.dp)
                commentCard(R.drawable.avatar, "小羊", "1", 0, 0,"整体包装特别好看，口红不拔干，上嘴效果很好")
                Divider(color = lightGrey, thickness = 2.dp)
                commentCard(R.drawable.profile2, "小熊", "2", 0, 0,"随便挑一个色号，都很好看！")
                Divider(color = lightGrey, thickness = 2.dp)
                commentCard(R.drawable.profile3, "梦凝", "1", 0, 0,"第一次买口红，就被种草了！好好看！")
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
fun commentCard(imageid: Int, name: String, vip: String, prefer: Int, fans: Int,text:String) {
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

                Text(text = text,fontSize = 15.sp)
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
            productDetail(labTitle =  product_detailViewlmodel.getItem().price, imageid =  product_detailViewlmodel.getItem().allimage[0])
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
    val number = remember {mutableStateOf(1)}
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
            modifier = Modifier.padding(220.dp, 0.dp,0.dp,0.dp).clickable { number.value--},
            contentDescription = null,
            tint= grey
        )
        //这个购买数量默认为1
        Text(
            text=number.value.toString(),
//            modifier = Modifier.padding(100.dp, 5.dp),
            color = orange,
            fontSize = 20.sp
        )
        //点击这个图标购买数量应该相应减少
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = null,
            tint= grey,
            modifier = Modifier.clickable {
                number.value++
            }

        )
    }
}

@Composable
fun productDetail(
    labTitle:Double,
    imageid: String,
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

            Image(painter = rememberCoilPainter(imageid),
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
                        append(labTitle.toString())
                    }
                }
            )
//            Icon(
//                imageVector = Icons.Default.ArrowDropDown,
//                contentDescription = null,
//            )
        }
    }
}

@Composable
fun productCatagory(
    onClick:()->Unit = {}
){
    val choose = remember {mutableStateOf(0)}
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

        LazyColumn(
            modifier = Modifier.padding(10.dp) // 内边距
        ) {
            items(product_detailViewlmodel.getItem().allcatagory.size) { item ->
                Card(
                    modifier = Modifier
                        .padding(10.dp) // 外边距
                        .clickable(onClick = {
                                choose.value = item
                            }
                        )
                        .fillMaxWidth(),

                    // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
                    // 将无法显示波纹效果

                    backgroundColor = if(item != choose.value) Color(0xFFDDDDDD) else Color(0xFFF56040),
                    elevation = 6.dp // 设置阴影
                ) {

                    Text(
                        text = product_detailViewlmodel.getItem().allcatagory[item],
                        fontSize = 20.sp
                    )
                }
            }
        }



        }
    }



