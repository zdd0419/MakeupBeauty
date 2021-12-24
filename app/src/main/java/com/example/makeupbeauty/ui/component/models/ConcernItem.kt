package com.example.makeupbeauty.component.models

data class ConcernItem(

    val id: Int,
    val name: String,
    val avatarId: Int,      //头像
    val imageId: Int,
    val source: String = "demo source"
)

