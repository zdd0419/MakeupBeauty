package com.example.makeupbeauty.ui.Screens

import android.content.Context
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.models.Chat
import com.example.makeupbeauty.ui.Topbars.ChatTopBar
import com.example.makeupbeauty.viewModel.ChatViewModel
import com.example.makeupbeauty.viewModel.ServiceChatViewModel

@Composable
fun ServiceChatPage(modifier: Modifier = Modifier, finish: (() -> Unit)? = null, context: Context) {
    val viewModel: ServiceChatViewModel = ServiceChatViewModel(context)
        Column(
            modifier
                .background(Color.White)
                .fillMaxSize()
        ) {
            // 联系人顶栏
            ChatTopBar("客服", onBack = finish)
            Box(
                Modifier
                    .background(Color.White)
                    .weight(1f)
            ) {
                LazyColumn(
                    Modifier
                        .fillMaxSize()
                ) {
                    items(viewModel.messages.size) { index ->
                        val msg = viewModel.messages[index]
                        MessageItem(msg, 0, viewModel.messages.size - index - 1)
                    }
                }
            }
            ServiceChatBottomBar(viewModel = viewModel)
        }
}


@Composable
fun ServiceChatBottomBar(viewModel: ServiceChatViewModel) {
    var editingText by remember { mutableStateOf("") }
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color(0xFFF7F7F7).convert(ColorSpaces.CieXyz))
            .padding(4.dp, 0.dp)
    ) {
        Icon(
            painterResource(R.drawable.ic_voice),
            contentDescription = null,
            Modifier
                .align(Alignment.CenterVertically)
                .padding(4.dp)
                .size(28.dp),
            tint = Color(0xFF000000).convert(ColorSpaces.CieXyz)
        )
        BasicTextField(
            editingText, { editingText = it },
            Modifier
                .weight(1f)
                .padding(4.dp, 8.dp)
                .height(40.dp)
                .clip(MaterialTheme.shapes.small)
                .background(Color(0xFFFFFFFF).convert(ColorSpaces.CieXyz))
                .padding(start = 8.dp, top = 10.dp, end = 8.dp),
            cursorBrush = SolidColor(Color(0xFF191919).convert(ColorSpaces.CieXyz))
        )
        Icon(
            painterResource(R.drawable.ic_add),
            contentDescription = null,
            Modifier
                .align(Alignment.CenterVertically)
                .padding(4.dp)
                .clickable {
                    viewModel.send(editingText)
                    editingText = ""
                }
                .size(28.dp),
            tint = Color(0xFF000000).convert(ColorSpaces.CieXyz)
        )
    }
}
