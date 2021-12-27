package com.example.makeupbeauty.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import com.example.makeupbeauty.component.models.Comment

data class notesData(
    val id: Int,
    val title: String,
    val content:String,
    val author:String,
    val avator:String,
    var isliked: MutableState<Int>,
    var iscollected: Int,
    var imagelist:MutableList<String>,
    var commentlist: MutableList<Comment> = mutableStateListOf(),
    val time:String

)
