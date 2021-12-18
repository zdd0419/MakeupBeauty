package com.example.makeupbeauty.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.models.Chat
import com.example.makeupbeauty.component.models.ChatUser
import com.example.makeupbeauty.component.models.Msg

class ChatViewModel: ViewModel() {
    val chats by mutableStateOf(
        listOf(
            Chat(
                friend = ChatUser("test","test", R.drawable.head),
                mutableStateListOf(
                    Msg(ChatUser("test","test",R.drawable.head),"1","14:28"),
                    Msg(ChatUser.Me,"2","14:29"),
                    Msg(ChatUser("test","test",R.drawable.head),"3","14:30"),
                    Msg(ChatUser.Me,"4","14:31"),
                    Msg(ChatUser("test","test",R.drawable.head),"5","14:32"),
                    Msg(ChatUser.Me,"6","14:33"),
                )
            ),
            Chat(
                friend = ChatUser("test2","test2",R.drawable.logotest),
                mutableStateListOf(
                    Msg(ChatUser("test2","test2",R.drawable.head),"1","14:28"),
                    Msg(ChatUser.Me,"2","14:29"),
                    Msg(ChatUser("test2","test2",R.drawable.head),"3","14:30"),
                    Msg(ChatUser.Me,"4","14:31"),
                    Msg(ChatUser("test2","test2",R.drawable.head),"5","14:32").apply { read = false },
                )
            ),
            Chat(
                friend = ChatUser("test3","test3",R.drawable.logotest),
                mutableStateListOf(
                    Msg(ChatUser("test3","test3",R.drawable.head),"1","14:28"),
                    Msg(ChatUser.Me,"2","14:29"),
                    Msg(ChatUser("test3","test3",R.drawable.head),"3","14:30"),
                    Msg(ChatUser.Me,"4","14:31"),
                    Msg(ChatUser("test3","test3",R.drawable.head),"5","14:32").apply { read = false },
                )
            )
        )
    )
    var selectedTab by mutableStateOf(0)

    var currentChat: Chat? by mutableStateOf(null)
    var chatting by mutableStateOf(false)

    fun startChat(chat: Chat) {
        chatting = true
        currentChat = chat
    }

    fun endChat(): Boolean {
        if (chatting) {
            chatting = false
            return true
        }
        return false
    }

    fun boom(chat: Chat) {
        chat.msgs.add(Msg(ChatUser.Me, "\uD83D\uDCA3", "15:10").apply { read = true })
    }

    fun send(chat: Chat, text: String) {
        chat.msgs.add(Msg(ChatUser.Me, text, "15:10").apply { read = true })
    }
}