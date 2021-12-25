package com.example.makeupbeauty.viewModel

import android.content.ContentValues
import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.models.ChatUser
import com.example.makeupbeauty.component.models.Msg
import com.example.makeupbeauty.ui.CustomerService.CustomerServiceActivity
import com.example.makeupbeauty.util.DBHelper
import com.zhangke.websocket.WebSocketSetting
import com.zhangke.websocket.WebSocketHandler

import com.zhangke.websocket.SocketListener
import com.zhangke.websocket.response.ErrorResponse
import org.java_websocket.framing.Framedata
import java.nio.ByteBuffer


class ServiceChatViewModel(var context: Context) : ViewModel(){

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
            val value = ContentValues().apply {
//                第二条数据
                put("person", "customerService")
                put("message", "$message")
                put("time", "15:11")
            }
            db.insert("history", null, value)
        }

        override fun <T : Any?> onMessage(bytes: ByteBuffer?, data: T) {
        }

        override fun onPing(framedata: Framedata?) {
        }

        override fun onPong(framedata: Framedata?) {
        }

    }
    val messages = mutableStateListOf<Msg>()

    private val customerService = ChatUser(id = "Customer service",
        name = "Customer service",
        avatar = R.drawable.head)

    val helper = DBHelper(context, "history.db", 1)

    val db = helper.writableDatabase

    init {
        val cursor = db.query("history", null, null, null, null, null, null)
        if (cursor.moveToFirst()){
            do {
                val person=cursor.getString(cursor.getColumnIndexOrThrow("person"))
                val message=cursor.getString(cursor.getColumnIndexOrThrow("message"))
                val time=cursor.getString(cursor.getColumnIndexOrThrow("time"))
                if(person.equals("me")){
                    messages.add(Msg(ChatUser.Me, message,time).apply { read = true })
                }else{
                    messages.add(Msg(customerService, message, time).apply { read = true })
                }
            }while (cursor.moveToNext())
        }
        cursor.close()
        val setting = WebSocketSetting()
        setting.connectUrl = "ws://zrp.cool:8081/"
        val manager = WebSocketHandler.init(setting)
        val socketListener = ws_listener()
        manager.addListener(socketListener);
        manager.start()
    }



    fun send(text: String) {
        messages.add(Msg(ChatUser.Me, text, "15:10").apply { read = true })
        val manager = WebSocketHandler.getDefault()
        manager.send(text)
        val value = ContentValues().apply {
//                第二条数据
            put("person", "me")
            put("message", text)
            put("time", "15:10")
        }
        db.insert("history", null, value)
    }
}