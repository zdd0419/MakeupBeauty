package com.example.makeupbeauty.Search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.makeupbeauty.BottomNavigation.BottomNavigation
import com.example.makeupbeauty.CommunityPost.PostActivity
import com.example.makeupbeauty.Screens.*
import com.example.makeupbeauty.Search.ui.theme.MakeupBeautyTheme
import com.example.makeupbeauty.Search.ui.theme.SearchHistory
import com.example.makeupbeauty.Topbars.TopBarNavigation
import kotlinx.coroutines.InternalCoroutinesApi


class SearchActivity : ComponentActivity() {
    companion object{
        fun newIntent(context: Context) =
            Intent(context, SearchActivity::class.java).apply { putExtra("search",true) }
    }

    @InternalCoroutinesApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //val currentScreen= mutableStateOf<NavigationItem>(NavigationItem.Home)
            val navController = rememberNavController()

            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            SearchTopBar({onBackPressed()}, navController)
                        }
                    ) {
                        SearchNavigation(navController)
                    }
                }
            }
        }
    }
}

@InternalCoroutinesApi
@ExperimentalFoundationApi
@Composable
fun SearchNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = "history") {
        composable("history") {
            SearchHistory()
        }
        composable("result") {
            SearchResult()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MakeupBeautyTheme {
        //Greeting("Android")
    }
}