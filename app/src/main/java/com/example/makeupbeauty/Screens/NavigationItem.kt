package com.example.makeupbeauty.Screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector


sealed class NavigationItem(
    val id:String,
    val title:String,
    val icon:ImageVector,
){
    object Home: NavigationItem("home","首页", Icons.Outlined.Home)
    object Store: NavigationItem("shop","商城", Icons.Outlined.ShoppingCart)
    object Profile: NavigationItem("profile","个人", Icons.Outlined.Person)
    object Community: NavigationItem("community","社区", Icons.Outlined.Face)
//    object Add:Screen("add","Add", Icons.Outlined.AddCircle)

    object Items{
        val list = listOf(
            Home, Store, Community, Profile
        )
    }
}
