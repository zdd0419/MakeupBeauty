package com.example.makeupbeauty.notes

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.makeupbeauty.ui.theme.lightGrey
import com.example.makeupbeauty.ui.theme.orange
import com.example.makeupbeauty.ui.theme.white
import androidx.compose.material.Icon as Icon

@Preview
@Composable
fun notes(){
    IconButtonDemo()

}

@Composable
fun Pic(
    imageID:Int
){

    Image(
        painter = painterResource(id = imageID),
        contentDescription = "avatar",
        modifier = Modifier
            .padding(12.dp)
            .clip(CircleShape)
            .size(40.dp))

}


@Composable
fun IconButtonDemo() {
    IconButton(
        onClick = {},
    ) {
        Card(  modifier = Modifier
            .height(60.dp)
            .width(62.dp)
            .border(
                color =  lightGrey,
                width = 2.dp,
                shape = RoundedCornerShape(16.dp)
            )) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Add To Cart",
                tint = white
            )
        }


    }
}
