package com.example.makeupbeauty.viewModel

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.makeupbeauty.Person.message
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.models.Chat
import com.example.makeupbeauty.component.models.ChatUser
import com.example.makeupbeauty.component.models.Msg
import com.zhangke.websocket.WebSocketSetting
import com.zhangke.websocket.WebSocketHandler

import com.zhangke.websocket.WebSocketManager
import com.zhangke.websocket.SocketListener
import com.zhangke.websocket.response.ErrorResponse
import org.java_websocket.framing.Framedata
import java.nio.ByteBuffer


class ServiceChatViewModel: ViewModel() {

    inner class ws_listener : SocketListener {
        override fun onConnected() {
        }

        override fun onConnectFailed(e: Throwable?) {
        }

        override fun onDisconnect() {
        }

        override fun onSendDataError(errorResponse: ErrorResponse?) {
        }

        override fun <T : Any?> onMessage(message: String?, data: T) {
            messages.add(Msg(customerService, "$message", "15:11").apply { read = true })
        }

        override fun <T : Any?> onMessage(bytes: ByteBuffer?, data: T) {
        }

        override fun onPing(framedata: Framedata?) {
        }

        override fun onPong(framedata: Framedata?) {
        }

    }

    init {
        val setting = WebSocketSetting()
        setting.connectUrl = "ws://zrp.cool:8081/"
        val manager = WebSocketHandler.init(setting)
        val socketListener = ws_listener()
        manager.addListener(socketListener);
        manager.start()
    }

    private val customerService = ChatUser(id = "Customer service",
                                    name = "Customer service",
                                   avatar = R.drawable.head)

    val messages = mutableStateListOf<Msg>()

    fun send(text: String) {
        messages.add(Msg(ChatUser.Me, text, "15:10").apply { read = true })
        val manager = WebSocketHandler.getDefault()
        manager.send(text)
    }
}