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
import androidx.core.content.ContextCompat
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.example.makeupbeauty.R
import com.example.makeupbeauty.TryOn.TryOn
import com.example.makeupbeauty.commodityDetail.ui.theme.MakeupBeautyTheme
import com.example.makeupbeauty.component.Carousel
import com.example.makeupbeauty.component.TopAppBarWithBack
import com.example.makeupbeauty.component.card.TopLabCards
import com.example.makeupbeauty.ui.theme.*
import com.example.makeupbeauty.viewModel.CartViewModel
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
                        text = "????????????",
                        color = white,
                        style = MaterialTheme.typography.button,
                        modifier = Modifier
                            .padding(top = 8.dp, bottom = 8.dp)
                            .clickable(
                                onClick = {

                                    context.startActivity(MyoderActivity.newIntent(context))
                                }
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
                        .width(200.dp)
                        .clickable(
                            onClick = {

                                context.startActivity(shoppingCarActivity.newIntent(context))
                            }
                        ),
//                        .padding(
//                            top = 30.dp,
//                            bottom = 34.dp
//                        ),
//                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = "???????????????",
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
//                            ProductAvailableSize()
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
                    text = "???"+product_detailViewlmodel.getItem().price,
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

                val context = LocalContext.current
                val intent = Intent(context, TryOn::class.java)

                TopLabCards(labTitle = "???????????????", labContent = "??????AR??????\n??????????????????????????????\n", labImage = painterResource(id = R.drawable.ic_face_card),
                    onClick = {
                        ContextCompat.startActivity(context, intent, null)
                    })
            }
        }


}

@Composable
fun ProductAvailableSize() {
    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            text = "????????????????????????",
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
                            product_detailViewlmodel.setId(item)
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
                text = "????????????",
                color = titleTextColor,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.padding(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(0.dp),
                verticalAlignment = Alignment.CenterVertically

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
                    text = "??????",
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
                commentCard(R.drawable.profile4, "??????", "10", 0, 0,"????????????????????????????????????????????????")
                Divider(color = lightGrey, thickness = 2.dp)
                commentCard(R.drawable.user1, "??????", "1", 0, 0,"???????????????????????????????????????????????????????????????")
                Divider(color = lightGrey, thickness = 2.dp)
                commentCard(R.drawable.profile2, "??????", "2", 0, 0,"???????????????????????????????????????")
                Divider(color = lightGrey, thickness = 2.dp)
                commentCard(R.drawable.profile3, "??????", "1", 0, 0,"???????????????????????????????????????????????????")
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
            Text(text = "?????????", fontSize = 12.sp)
        }
        DropdownMenu(
            expanded = expandState.value,
            onDismissRequest = {
                Log.e("ccm","?????????Request")
                expandState.value = false
            },
            offset = DpOffset(20.dp,10.dp),
            properties = PopupProperties()
        ) {
            dropdownMenuItemTest(expandState,Icons.Filled.Favorite,"?????????")
            dropdownMenuItemTest(expandState,Icons.Filled.Edit,"?????????")
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

//???????????????????????????
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

//????????????
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
    val intent = Intent(LocalContext.current, shoppingCarActivity::class.java)
    val cartViemmodel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<CartViewModel>()

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
        productCatagory(intent)
        val number = productNumber()
        Button(
            onClick = {
                cartViemmodel.addCartItem(
                    product_detailViewlmodel.getItem().allimage[0],
                    product_detailViewlmodel.getItem().title,
                    product_detailViewlmodel.getItem().price,
                    number,
                )
                context.startActivity(intent)
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
                text = "??????",
                color = white,
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
        }
    }


}
//??????????????????
@Composable
fun productNumber():Int{
    val number = remember {mutableStateOf(1)}
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,

        ) {

        Text(
            text="????????????",
            fontSize = 20.sp
        )
        Icon(
            imageVector = Icons.Default.RemoveCircle,
            modifier = Modifier
                .padding(220.dp, 0.dp, 0.dp, 0.dp)
                .clickable { number.value-- },
            contentDescription = null,
            tint= grey
        )
        //???????????????????????????1
        Text(
            text=number.value.toString(),
//            modifier = Modifier.padding(100.dp, 5.dp),
            color = orange,
            fontSize = 20.sp
        )
        //????????????????????????????????????????????????
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = null,
            tint= grey,
            modifier = Modifier.clickable {
                number.value++

            }

        )
    }
    return number.value
}

@Composable
fun productDetail(
    labTitle:Double,
    imageid: String,
    onClick:()->Unit = {}
){
    Card(
        modifier = Modifier
            .padding(10.dp) // ?????????
            .clickable(onClick = onClick)
            .fillMaxWidth()
        ,

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????

        elevation = 6.dp // ????????????
    ) {
        Row(
            modifier = Modifier.padding(10.dp) // ?????????
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
    intent: Intent,
    onClick:()->Unit = {}
){
    val choose = remember {mutableStateOf(0)}

    Card(
        modifier = Modifier
            .padding(1.dp) // ?????????
            .clickable(onClick = onClick)
            .fillMaxWidth()
        ,

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????

        elevation = 6.dp // ????????????
    ) {

        LazyColumn(
            modifier = Modifier.padding(10.dp) // ?????????
        ) {
            items(product_detailViewlmodel.getItem().allcatagory.size) { item ->
                Card(
                    modifier = Modifier
                        .padding(10.dp) // ?????????
                        .clickable(onClick = {
                            choose.value = item
//                            product_detailViewlmodel.setChoose(item)

                            intent.putExtra("price", product_detailViewlmodel.getItem().price)
                            intent.putExtra("title", product_detailViewlmodel.getItem().title)
                            intent.putExtra(
                                "catagory",
                                product_detailViewlmodel.getItem().allcatagory[item]
                            )
                            //intent.putExtra("product_id", product_detailViewlmodel.setId(item))
                            intent.putExtra(
                                "photos",
                                product_detailViewlmodel.getItem().allimage[item]
                            )
                        }
                        )
                        .fillMaxWidth(),

                    // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
                    // ???????????????????????????

                    backgroundColor = if(item != choose.value) Color(0xFFDDDDDD) else Color(0xFFF56040),
                    elevation = 6.dp // ????????????
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



