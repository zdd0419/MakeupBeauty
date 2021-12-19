package com.example.makeupbeauty.Search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.makeupbeauty.Search.ui.theme.MakeupBeautyTheme
import com.example.makeupbeauty.Search.ui.theme.SearchHistory
import kotlinx.coroutines.InternalCoroutinesApi


class SearchActivity : ComponentActivity() {
    companion object{
        fun newIntent(context: Context) =
            Intent(context, SearchActivity::class.java).apply { putExtra("search",true) }
    }

    private fun goBack() {
        Toast.makeText(null, "back", Toast.LENGTH_SHORT).show()
        finish()
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
                            TopAppBar(
                                title = {
                                    Surface(modifier = Modifier) {

                                        Row() {
                                            SearchTextField()
                                            SearchButton(navController)
                                        }


                                    }
                                },
                                navigationIcon = {
                                    IconButton(onClick = { onBackPressed() }) {
                                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                                    }
                                },
                                backgroundColor = MaterialTheme.colors.background
                            )
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