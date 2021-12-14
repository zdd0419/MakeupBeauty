package com.example.makeupbeauty.component.models

import android.text.format.Time
import java.text.SimpleDateFormat

data class Comment(
    val image: Int,          //评论者头像
    val title: String,
    val content: String,
    val time: String,
    val likeNum: Int         //点赞数
    )
