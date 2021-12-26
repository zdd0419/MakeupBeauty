package com.example.makeupbeauty.data

import com.example.makeupbeauty.component.models.Comment

data class notesData(
    val id: Int,
    val title: String,
    val content:String,
    val author:String,
    val avator:String,
    val isliked: Int,
    val iscollected: Int,
    val imagelist:List<String>,
    val commentlist:List<Comment>,
    val time:String

)
