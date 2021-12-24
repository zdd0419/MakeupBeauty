package com.example.makeupbeauty.component.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Chat (val friend: ChatUser, val msgs: MutableList<Msg>){}

class Msg(val from: ChatUser, val text: String ,val time: String){
    var read: Boolean by mutableStateOf(true)
}