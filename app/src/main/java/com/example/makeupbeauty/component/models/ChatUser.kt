package com.example.makeupbeauty.component.models

import androidx.annotation.DrawableRes
import com.example.makeupbeauty.R

class ChatUser (
    val id: String,
    val name: String,
    @DrawableRes val avatar: Int
    ){
    companion object{
        val Me: ChatUser = ChatUser("test","test", R.drawable.head)
    }

}