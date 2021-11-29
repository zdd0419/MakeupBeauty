package com.example.makeupbeauty.ui.theme.BottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector


sealed class Screen(
    val id:String,
    val title:String,
    val icon:ImageVector,
){
    object Home:Screen("home","首页", Icons.Outlined.Home)
    object Shop:Screen("shop","商城", Icons.Outlined.ShoppingCart)
    object Profile:Screen("profile","个人", Icons.Outlined.Person)
    object Community:Screen("community","社区", Icons.Outlined.Face)
//    object Add:Screen("add","Add", Icons.Outlined.AddCircle)

    object Items{
        val list = listOf(
            Home,Shop,Community,Profile
        )
    }
}
