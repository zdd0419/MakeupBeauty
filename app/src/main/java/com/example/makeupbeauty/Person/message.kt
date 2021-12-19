package com.example.makeupbeauty.Person

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.TopBarWithBack
import com.example.makeupbeauty.notes.*
import com.example.makeupbeauty.ui.theme.*
import com.example.makeupbeauty.ui.theme.lightGrey


class Message : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            message()
        }
    }
}

@Preview
@Composable
fun message(){
    MakeupBeautyTheme {
        Scaffold(
            topBar = {
                TopBarWithBack(
                    title ="消息",
                    onBackClick = {

                    },
                )
            }, backgroundColor = cottonBall,
            content = {
                LazyColumn() {
                    item {
                        Card(shape = RoundedCornerShape(3.dp),
                            elevation = 2.dp,
                            modifier=Modifier.fillMaxWidth() ){
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            ) {
                                Spacer(modifier = Modifier.padding(14.dp))
                                card(imageVector = Icons.Outlined.Favorite, title = "赞",1)
                                Spacer(modifier = Modifier.padding(24.dp))
                                card(imageVector = Icons.Outlined.Person, title = "新增",2)
                                Spacer(modifier = Modifier.padding(24.dp))
                                card(imageVector = Icons.Outlined.Message, title = "评论",3)
                            }
                        }
                        Divider(color = lightGrey, thickness = 2.dp)

                        Card(shape = RoundedCornerShape(3.dp),
                            elevation = 2.dp,
                            modifier=Modifier.fillMaxWidth() ) {
                            newMesageCard(R.drawable.avatar, "dd")
                        }
                        Card(shape = RoundedCornerShape(3.dp),
                            elevation = 2.dp,
                            modifier=Modifier.fillMaxWidth() ) {
                            newMesageCard(R.drawable.avatar, "aa")
                        }
                        Card(shape = RoundedCornerShape(3.dp),
                            elevation = 2.dp,
                            modifier=Modifier.fillMaxWidth() ) {
                            newMesageCard(R.drawable.avatar, "aa")
                        }
                        Card(shape = RoundedCornerShape(3.dp),
                            elevation = 2.dp,
                            modifier=Modifier.fillMaxWidth() ) {
                            newMesageCard(R.drawable.avatar, "aa")
                        }
                        Card(shape = RoundedCornerShape(3.dp),
                            elevation = 2.dp,
                            modifier=Modifier.fillMaxWidth() ) {
                            newMesageCard(R.drawable.avatar, "aa")
                        }
                    }
                }


                
            })
    }
}


@Composable
fun card(
    imageVector: ImageVector,
    title:String,
    badge:Int
){
    Card(shape = RoundedCornerShape(3.dp),
        elevation = 2.dp,
    modifier= Modifier
        .height(90.dp)
        .width(70.dp)) {
        Column(modifier=Modifier.padding(start=10.dp,top=3.dp)) {
            Box() {
                if(imageVector==Icons.Outlined.Favorite)
                {
                    Icon(
                        imageVector = imageVector,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp),
                        tint= red
                    )

                }else if(imageVector==Icons.Outlined.Person){
                    Icon(
                        imageVector = imageVector,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp),
                        tint= blue
                    )
                }else{
                    Icon(
                        imageVector = imageVector,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp),
                        tint= green
                    )
                }

                if(badge!=0){
                    Text(
                        text = "$badge",
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.surface,
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .clip(CircleShape)
                            .background(Color.Red)
                            .align(Alignment.TopEnd)
                            .size(16.dp)
                    )
                }

            }

            Text(text=title,modifier=Modifier.padding(10.dp), fontSize = 16.sp)


        }
    }

    
}


@Composable
fun newMesageCard(imageid: Int, name: String) {
    Row() {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp, 24.dp, 0.dp, 8.dp)
            .height(height = 80.dp), Alignment.CenterStart) {
            Row(modifier = Modifier) {
                Image(
                    painter = painterResource(id = imageid),
                    contentDescription = "avatar",
                    modifier = Modifier
                        .padding(12.dp)
                        .clip(CircleShape)
                        .size(60.dp))

                Column() {
                    Spacer(
                        Modifier
                            .height(12.dp)
                    )
                    Row(modifier = Modifier.padding(horizontal = 4.dp), Arrangement.Center) {
                        Text(text = name, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
                        Spacer(modifier = Modifier.padding(4.dp))
                    }
                    Spacer(
                        Modifier
                            .height(8.dp)
                    )

                    Text(text = "非常喜欢！ ",fontSize = 10.sp,color=grey)
                }

            }
            Text(text = "12:17", modifier = Modifier.padding( start=320.dp,top=1.dp),color= grey)

        }

    }

}
