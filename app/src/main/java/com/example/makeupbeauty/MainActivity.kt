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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.makeupbeauty.ui.theme.MakeupBeautyTheme
import com.example.makeupbeauty.Screens.*
import com.example.makeupbeauty.BottomNavigation.BottomNavigation
import com.example.makeupbeauty.Topbars.TopBarNavigation


class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val currentScreen= mutableStateOf<NavigationItem>(NavigationItem.Home)
            val navController = rememberNavController()

            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                                 TopBarNavigation(navController = navController)
                        },
                        bottomBar = {
                            BottomNavigation(navController = navController)
                    }) {
                        Navigation(navController)
                    }
                }
            }
        }
    }
}


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.id) {
        composable(NavigationItem.Home.id) {
            HomeScreen()
        }
        composable(NavigationItem.Store.id) {
            StoreScreen()
        }
        composable(NavigationItem.Community.id) {
            CommunityScreen()
        }
        composable(NavigationItem.Profile.id) {
            ProfileScreen()
        }
    }
}
