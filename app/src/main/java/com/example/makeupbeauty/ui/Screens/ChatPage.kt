package com.example.makeupbeauty.ui.Screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.makeupbeauty.R
import com.example.makeupbeauty.ui.Topbars.ChatTopBar
import com.example.makeupbeauty.component.models.Chat
import com.example.makeupbeauty.component.models.ChatUser
import com.example.makeupbeauty.component.models.Msg
import com.example.makeupbeauty.data.ChatViewModel
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

@Composable
fun ChatPage(modifier: Modifier = Modifier) {
    val viewModel: ChatViewModel = viewModel()
    val offsetPercentX by animateFloatAsState(if (viewModel.chatting) 0f else 1f)
    val chat = viewModel.currentChat
    if (chat != null) {
        Column(
            modifier
                .offsetPercent(offsetPercentX)
                .background(Color.White)
                .fillMaxSize()
        ) {
            // 联系人顶栏
            ChatTopBar(chat.friend.name) {
                viewModel.endChat()
            }
            var shakingTime by remember {
                mutableStateOf(0)
            }
            Box(
                Modifier
                    .background(Color.White)
                    .weight(1f)
            ) {
                Box(
                    Modifier
                        .alpha(0f)
                        .fillMaxSize()
                ) {
//                    Image(
//                        painterResource(R.drawable.logotest), null,
//                        Modifier
//                            .align(Alignment.CenterStart)
//                            .padding(bottom = 100.dp)
//                    )
//                    Image(
//                        painterResource(R.drawable.logotest), null,
//                        Modifier
//                            .align(Alignment.TopEnd)
//                            .padding(horizontal = 24.dp)
//                    )
//                    Image(
//                        painterResource(R.drawable.logotest), null,
//                        Modifier
//                            .align(Alignment.BottomEnd)
//                            .padding(vertical = 200.dp)
//                    )
                }
                val shakingOffset = remember {
                    Animatable(0f)
                }
                LaunchedEffect(key1 = shakingTime) {
                    if (shakingTime != 0) {
                        shakingOffset.animateTo(
                            0f,
                            animationSpec = spring(0.3f, 600f),
                            initialVelocity = -2000f
                        )
                    }
                }
                LazyColumn(
                    Modifier
                        .fillMaxSize()
                        .offset(shakingOffset.value.dp, shakingOffset.value.dp)
                ) {
                    items(chat.msgs.size) { index ->
                        val msg = chat.msgs[index]
                        MessageItem(msg, shakingTime, chat.msgs.size - index - 1)
                    }
                }
            }
            ChatBottomBar(onBombClicked = {
                viewModel.boom(chat)
                shakingTime++
            }, chat)
        }
    }
}

@Composable
fun ChatBottomBar(onBombClicked: () -> Unit, chat: Chat) {
    val viewModel: ChatViewModel = viewModel()
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
        Text(
            "\uD83D\uDCA3",
            Modifier
                .clickable(onClick = onBombClicked)
                .padding(4.dp)
                .align(Alignment.CenterVertically),
            fontSize = 24.sp
        )
        Icon(
            painterResource(R.drawable.ic_add),
            contentDescription = null,
            Modifier
                .align(Alignment.CenterVertically)
                .padding(4.dp)
                .clickable {
                    viewModel.send(chat, editingText)
                    editingText = ""
                }
                .size(28.dp),
            tint = Color(0xFF000000).convert(ColorSpaces.CieXyz)
        )
    }
}

@Composable
fun MessageItem(msg: Msg, shakingTime: Int, shakingLevel: Int) {
    val shakingAngleBubble = remember { Animatable(0f) }
    LaunchedEffect(key1 = shakingTime, block = {
        if (shakingTime != 0) {
            delay(shakingLevel.toLong() * 30)
            shakingAngleBubble.animateTo(
                0f,
                animationSpec = spring(0.4f, 500f),
                initialVelocity = 1200f / (1 + shakingLevel * 0.4f)
            )
        }
    })
    if (msg.from == ChatUser.Me) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            val bubbleColor = Color(0xFFB0EB6E).convert(ColorSpaces.CieXyz)
            Text("${msg.text}",
                Modifier
                    .graphicsLayer(
                        rotationZ = shakingAngleBubble.value,
                        transformOrigin = TransformOrigin(1f, 0f)
                    )
                    .drawBehind {
                        val bubble = Path().apply {
                            val rect = RoundRect(
                                10.dp.toPx(),
                                0f,
                                size.width - 10.dp.toPx(),
                                size.height,
                                4.dp.toPx(),
                                4.dp.toPx()
                            )
                            addRoundRect(rect)
                            moveTo(size.width - 10.dp.toPx(), 15.dp.toPx())
                            lineTo(size.width - 5.dp.toPx(), 20.dp.toPx())
                            lineTo(size.width - 10.dp.toPx(), 25.dp.toPx())
                            close()
                        }
                        drawPath(bubble, bubbleColor)
                    }
                    .padding(20.dp, 10.dp),
                color = Color(0xFF191919).convert(ColorSpaces.CieXyz))
            Image(
                painterResource(msg.from.avatar),
                contentDescription = msg.from.name,
                Modifier
                    .graphicsLayer(
                        rotationZ = shakingAngleBubble.value * 0.6f,
                        transformOrigin = TransformOrigin(1f, 0f)
                    )
                    .size(40.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
        }
    } else {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painterResource(msg.from.avatar),
                contentDescription = msg.from.name,
                Modifier
                    .graphicsLayer(
                        rotationZ = -shakingAngleBubble.value * 0.6f,
                        transformOrigin = TransformOrigin(0f, 0f)
                    )
                    .size(40.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            val bubbleColor = Color.White
            Text("${msg.text}",
                Modifier
                    .graphicsLayer(
                        rotationZ = -shakingAngleBubble.value,
                        transformOrigin = TransformOrigin(0f, 0f)
                    )
                    .drawBehind {
                        val bubble = Path().apply {
                            val rect = RoundRect(
                                10.dp.toPx(),
                                0f,
                                size.width - 10.dp.toPx(),
                                size.height,
                                4.dp.toPx(),
                                4.dp.toPx()
                            )
                            addRoundRect(rect)
                            moveTo(10.dp.toPx(), 15.dp.toPx())
                            lineTo(5.dp.toPx(), 20.dp.toPx())
                            lineTo(10.dp.toPx(), 25.dp.toPx())
                            close()
                        }
                        drawPath(bubble, bubbleColor)
                    }
                    .padding(20.dp, 10.dp),
                color = Color(0xFF191919).convert(ColorSpaces.CieXyz))
        }
    }
}

fun Modifier.offsetPercent(offsetPercentX: Float = 0f, offsetPercentY: Float = 0f) =
    this.layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        layout(placeable.width, placeable.height) {
            val offsetX = (offsetPercentX * placeable.width).roundToInt()
            val offsetY = (offsetPercentY * placeable.height).roundToInt()
            placeable.placeRelative(offsetX, offsetY)
        }
    }