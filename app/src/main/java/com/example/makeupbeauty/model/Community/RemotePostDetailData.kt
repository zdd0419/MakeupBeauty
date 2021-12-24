package com.example.makeupbeauty.model.Community

data class RemotePostDetailData(
    val comment_num: Int,
    val content: String,
    val id: Int,
    val is_active: Boolean,
    val like_num: Int,
    val timestamp: Any,
    val title: String,
    val user: Int
)