package com.example.makeupbeauty.ui.CustomerService

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.makeupbeauty.commodityDetail.MyoderActivity
import com.example.makeupbeauty.commodityDetail.shoppingCarActivity
import com.example.makeupbeauty.ui.Screens.ServiceChatPage

import com.example.makeupbeauty.commodityDetail.ui.theme.MakeupBeautyTheme

class CustomerServiceActivity : ComponentActivity() {
    companion object {
        fun newIntent(context: Context) =
            Intent(context, CustomerServiceActivity::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ServiceChatPage()
                }
            }
        }
    }
}