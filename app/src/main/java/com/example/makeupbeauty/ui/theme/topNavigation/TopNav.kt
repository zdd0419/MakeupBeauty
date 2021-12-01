package com.example.makeupbeauty.ui.theme.topNavigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.makeupbeauty.ui.theme.topNavigation.topScreen
import java.lang.reflect.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

@ExperimentalAnimationApi
@Composable
fun TopNavigaition(
    currentTopScreenId:String,
    onItemSelected:(topScreen)->Unit
) {
    val items = topScreen.Items.list

    Row(
        modifier= androidx.compose.ui.Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ){
        items.forEach{
                item->
            TopNavigationItem(item = item, isSelected = item.id==currentTopScreenId) {
                onItemSelected(item)
            }
        }


    }
}


@ExperimentalAnimationApi
@Composable
fun TopNavigationItem(item: topScreen, isSelected:Boolean, onClick:()->Unit){
    val background=if(isSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
    val contentColor=if(isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground



    Box(modifier= androidx.compose.ui.Modifier
        .clip(CircleShape)
        .clickable(onClick = onClick)){
        Row(
            modifier= androidx.compose.ui.Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ){
            Icon(imageVector = item.icon, contentDescription = null,tint=contentColor
            )
            AnimatedVisibility(visible = isSelected) {
                Text(text=item.title,
                    color=contentColor
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
@Preview
fun prev1(){
    TopNavigaition(currentTopScreenId = topScreen.Search.id){

    }
}

//@ExperimentalAnimationApi
//@Composable
//@Preview
//fun prev2(){
//   TopNavigationItem(item = topScreen.Search, isSelected = true) {
//
//    }}

