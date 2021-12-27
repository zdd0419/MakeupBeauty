package com.example.makeupbeauty.ui


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.makeupbeauty.ui.theme.MakeupBeautyTheme
import com.example.makeupbeauty.ui.Screens.*
import com.example.makeupbeauty.BottomNavigation.BottomNavigation
import com.example.makeupbeauty.ui.Topbars.TopBarNavigation
import com.example.makeupbeauty.R
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.InternalCoroutinesApi
import com.androidisland.vita.startVita

class MainActivity : ComponentActivity() {
    companion object {
        fun newIntent(context: Context) =
            Intent(context, MainActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                .apply { putExtra("ReStart", true) }
    }
    @ExperimentalFoundationApi
    @ExperimentalPagerApi
    @InternalCoroutinesApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.statusBarColor = ContextCompat.getColor(this, R.color.theme)
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


