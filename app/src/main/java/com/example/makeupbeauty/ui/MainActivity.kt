package com.example.makeupbeauty.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.makeupbeauty.ui.theme.MakeupBeautyTheme
import com.example.makeupbeauty.ui.Screens.*
import com.example.makeupbeauty.BottomNavigation.BottomNavigation
import com.example.makeupbeauty.ui.Topbars.TopBarNavigation

import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.InternalCoroutinesApi


class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @ExperimentalPagerApi
    @InternalCoroutinesApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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


@ExperimentalFoundationApi
@InternalCoroutinesApi
@ExperimentalPagerApi
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


