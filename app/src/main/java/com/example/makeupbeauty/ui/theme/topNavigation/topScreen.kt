package com.example.makeupbeauty.ui.theme.topNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.TextFieldValue
import com.example.makeupbeauty.ui.theme.BottomNavigation.Screen

sealed class topScreen(
    val id:String,
    val title:String,
    val icon: ImageVector,

    ){

    object Search: topScreen("search","首页", Icons.Outlined.Search)
    object Items{
        val list = listOf(
            topScreen.Search
        )
    }
}
