package com.example.makeupbeauty.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.ak1.pix.helpers.*
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.TopBarWithBack
import com.example.makeupbeauty.ui.theme.*
import io.ak1.pix.models.Mode
import androidx.compose.material.Icon as Icon
import io.ak1.pix.models.Options
import io.ak1.pix.models.Ratio
import io.ak1.pix.helpers.addPixToActivity


val TitleText = mutableStateOf("")
val contentText = mutableStateOf("")
class Notes_ : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) =
            Intent(context, Notes_::class.java).apply { putExtra("notes",true) }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           notes {
               val options = Options().apply{
                   ratio = Ratio.RATIO_AUTO                                    //Image/video capture ratio
                   count = 1                                                   //Number of images to restrict selection count
                   spanCount = 4                                               //Number for columns in grid
                   path = "Pix/Camera"                                         //Custom Path For media Storage
                   isFrontFacing = false                                       //Front Facing camera on start
                   videoDurationLimitInSeconds = 10                            //Duration for video recording
                   mode = Mode.All                                             //Option to select only pictures or videos or both
               }

               addPixToActivity(R.id.NO_DEBUG, options) {
                   when (it.status) {
                       PixEventCallback.Status.SUCCESS -> {}//use results as it.data
                       PixEventCallback.Status.BACK_PRESSED -> {}// back pressed called
                   }
               }
           }
        }

    }
}


@Composable
fun notes(select_pic: () -> Unit){
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
                        IconButtonDemo(select_pic = select_pic)
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
fun IconButtonDemo(select_pic: () -> Unit) {
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
                modifier = Modifier.clickable {
                    select_pic()
                }
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