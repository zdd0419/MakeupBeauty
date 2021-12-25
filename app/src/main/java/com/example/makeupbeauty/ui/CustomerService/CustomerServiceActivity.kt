package com.example.makeupbeauty.ui.CustomerService

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.example.makeupbeauty.ui.Screens.ServiceChatPage

import com.example.makeupbeauty.commodityDetail.ui.theme.MakeupBeautyTheme

class CustomerServiceActivity : ComponentActivity() {
    val REQUEST_EXTERNAL_STORAGE = 1;
    val PERMISSIONS_STORAGE = arrayOf("android.permission.READ_EXTERNAL_STORAGE",
        "android.permission.WRITE_EXTERNAL_STORAGE" )

    companion object {
        fun newIntent(context: Context) =
            Intent(context, CustomerServiceActivity::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if (ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                //没有权限则申请权限
                ActivityCompat.requestPermissions(this,PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
            }
        }

        setContent {
            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ServiceChatPage(context = this)
                }
            }
        }
    }
}