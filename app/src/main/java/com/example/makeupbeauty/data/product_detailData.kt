package com.example.makeupbeauty.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

//class product_detailData ( val pdetail: MutableList<detail>){}
class detail(val id: Int,
             val title: String,
             val price: Double,
             val isliked: Int,
//             val image: List<String>,
             val allimage:List<String>,
             val allcatagory:List<String>
//                         val image1: String,
//                         val image2:String,
//                         val image3:String,
//                         val image4:String,
//                         val imgge5:String,
//                         val catogory1:String,
//                         val catogory2:String,
//                         val catogory3:String,
//                         val catogory4:String,

)
{
    var read: Boolean by mutableStateOf(true)
}