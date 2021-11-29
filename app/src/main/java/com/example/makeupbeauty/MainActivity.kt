package com.example.makeupbeauty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import com.example.makeupbeauty.ui.theme.MakeupBeautyTheme
import com.example.makeupbeauty.ui.theme.BottomNavigation.BottomNavigaition
import com.example.makeupbeauty.ui.theme.BottomNavigation.Screen

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val currentScreen= mutableStateOf<Screen>(com.example.makeupbeauty.ui.theme.BottomNavigation.Screen.Home)
            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(bottomBar = {
                        BottomNavigaition(currentScreenId = currentScreen.value.id){
                            currentScreen.value=it
                        }

                    }) {

                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MakeupBeautyTheme {

    }
    
}


