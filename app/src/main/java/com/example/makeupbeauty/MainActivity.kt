package com.example.makeupbeauty

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.ui.theme.MakeupBeautyTheme
import com.example.makeupbeauty.ui.theme.BottomNavigation.BottomNavigaition
import com.example.makeupbeauty.ui.theme.BottomNavigation.Screen
import com.example.makeupbeauty.ui.theme.topNavigation.TopNavigaition
import com.example.makeupbeauty.ui.theme.topNavigation.topScreen

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Main()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MakeupBeautyTheme {

    }
    
}

@Composable
fun Image(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) {

}

//首页
@SuppressLint("UnrememberedMutableState")
@ExperimentalAnimationApi
@Composable
fun Main(){
    val currentScreen= mutableStateOf<Screen>(com.example.makeupbeauty.ui.theme.BottomNavigation.Screen.Home)
    val currentTopScreen= mutableStateOf<topScreen>(com.example.makeupbeauty.ui.theme.topNavigation.topScreen.Search)
    //初始化搜索框文本变量
    var text by remember{
        mutableStateOf("")
    }
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(bottomBar = {//底部导航
            BottomNavigaition(currentScreenId = currentScreen.value.id){
                currentScreen.value=it
            }
        },
            //顶部应用栏
            topBar = {
                Row(
                    modifier = Modifier.background(MaterialTheme.colors.background)
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,

                    ){
                    Surface(
                        shape = CircleShape
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp),
                            contentScale = ContentScale.Crop
                        )
                    }

                        TextField(
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Gray,
                                disabledTextColor = Color.Transparent,
//                                backgroundColor = Color.White,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent),
                            value = text,
                            onValueChange = { text = it },
                            label = { Text(text = "请输入你想要搜索的内容",
                                fontSize = 10.sp,
                                color=Color.Gray,
                                textAlign= TextAlign.Center,
//                                modifier=Modifier.padding(0.1.dp)
                            ) },
                            shape = RoundedCornerShape(16.dp),//设置文本框圆角
                            trailingIcon =  {
                                Image(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = "search",
//                                                modifier = Modifier.clickable {
//                                                    Toast.makeText(
//                                                        this,
//                                                        "search $text",
//                                                        Toast.LENGTH_SHORT
//                                                    ).show()
//                                                }
                                )
                            },
                            //搜索框偏移
                            modifier = Modifier.offset(x = 20.dp)
                                .background(Color.White, CircleShape)
                                .height(23.dp)
                                .width(300.dp)

                        )

                    }




//                                    Spacer(Modifier.width(10.dp))


            }

        ) {

        }


    }

    //content

    Image(
        painter = painterResource(id = R.drawable.makeup),
        contentDescription = null,
        modifier = Modifier.size(100.dp),
        contentScale = ContentScale.Crop
    )


}


