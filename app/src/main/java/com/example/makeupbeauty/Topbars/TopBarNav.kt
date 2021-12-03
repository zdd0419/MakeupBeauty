package com.example.makeupbeauty.Topbars

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.makeupbeauty.DefaultTopbar
import com.example.makeupbeauty.Screens.NavigationItem
import com.example.makeupbeauty.StoreTopbar

@ExperimentalAnimationApi
@Composable
fun TopBarNavigation(
    navController: NavController
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    if (currentRoute == NavigationItem.Store.id){
        StoreTopbar()
    }else if(currentRoute != NavigationItem.Profile.id){
        DefaultTopbar()
    }
}