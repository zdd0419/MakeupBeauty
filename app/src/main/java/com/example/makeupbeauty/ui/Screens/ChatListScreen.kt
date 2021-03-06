package com.example.makeupbeauty.ui.Screens


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.makeupbeauty.R
import com.example.makeupbeauty.ui.Topbars.ChatTopBar
import com.example.makeupbeauty.component.models.Chat
import com.example.makeupbeauty.viewModel.ChatViewModel
import com.example.makeupbeauty.ui.AttentionScreen
import com.example.makeupbeauty.ui.CommentScreen
import com.example.makeupbeauty.ui.LikeAndFavorites
import com.example.makeupbeauty.ui.theme.MakeupBeautyTheme

class ChatListScreen : ComponentActivity(){
    companion object{
        fun newIntent(context: Context) =
            Intent(context, ChatListScreen::class.java).apply { putExtra("ChatList",true) }
    }
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            MakeupBeautyTheme{
                val viewModel: ChatViewModel = viewModel()
                Surface(color = MaterialTheme.colors.background){
                    ChatList(viewModel.chats)
                    ChatPage()
                }
            }
        }

    }

}



@Composable
fun ChatList(chats: List<Chat>) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ){
        // ????????????
        ChatTopBar(title = "??????")
        // ???????????? ???????????? ?????????@
        ChatCard()
        Spacer(
            Modifier
                .background(Color.White)
                .fillMaxWidth()
                .height(8.dp)
        )
        // ????????????
        LazyColumn(modifier = Modifier.background(Color.White)){
            itemsIndexed(chats){ index, chat ->
                ChatListItem(chat)
                if(index<chats.lastIndex){
                    Divider(
                        startIndent = 68.dp,
                        color = Color.LightGray,
                        thickness = 0.9f.dp
                    )
                }
            }
        }
    }
}

// ????????????????????????
fun Modifier.unread(show: Boolean, color: Color): Modifier = this.drawWithContent {
    drawContent()
    if(show){
        drawCircle(color, 6.dp.toPx(), Offset(size.width - 1.dp.toPx(), 1.dp.toPx() ))
    }
}

// ???????????? ???????????? ?????????@

@Composable
fun ChatCard(){
    val context = LocalContext.current;
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 16.dp)
    ) {
        Column(
            modifier = Modifier.clickable { context.startActivity(LikeAndFavorites.newIntent(context)) }
        ) {
            Image(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "",
                modifier = Modifier.size(70.dp)
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = " ????????????",
                color = Color.Gray,
                fontSize = 15.sp
            )
        }

        Spacer(modifier = Modifier.width(15.dp))

        Column(
            modifier = Modifier.clickable {  }
        ) {
            Image(
                painter = painterResource(id = R.drawable.attention),
                contentDescription = "",
                modifier = Modifier.size(70.dp)
                    .clickable { context.startActivity(AttentionScreen.newIntent(context)) }
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = " ????????????",
                color = Color.Gray,
                fontSize = 15.sp
            )
        }

        Spacer(modifier = Modifier.width(15.dp))

        Column(
            modifier = Modifier.clickable {  }
        ) {
            Image(
                painter = painterResource(id = R.drawable.message),
                contentDescription = "",
                modifier = Modifier.size(70.dp)
                    .clickable { context.startActivity(CommentScreen.newIntent(context)) }
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = " ?????????@",
                color = Color.Gray,
                fontSize = 15.sp
            )
        }
    }

//    Card(elevation = 8.dp, modifier = Modifier.padding(8.dp)) {
//        Row(
//            horizontalArrangement = Arrangement.SpaceAround,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 32.dp, vertical = 16.dp)
//        ) {
//            Column(
//                modifier = Modifier.clickable {  }
//            ) {
//                Image(
//                        painter = painterResource(id = R.drawable.heart),
//                        contentDescription = "",
//                        modifier = Modifier.size(70.dp)
//                    )
//                    Spacer(modifier = Modifier.height(3.dp))
//                    Text(
//                        text = " ????????????",
//                        color = Color.Gray,
//                        fontSize = 15.sp
//                    )
//            }
//
//            Spacer(modifier = Modifier.width(15.dp))
//
//            Column(
//                modifier = Modifier.clickable {  }
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.attention),
//                    contentDescription = "",
//                    modifier = Modifier.size(70.dp)
//                )
//                Spacer(modifier = Modifier.height(3.dp))
//                Text(
//                    text = " ????????????",
//                    color = Color.Gray,
//                    fontSize = 15.sp
//                )
//            }
//
//            Spacer(modifier = Modifier.width(15.dp))
//
//            Column(
//                modifier = Modifier.clickable {  }
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.message),
//                    contentDescription = "",
//                    modifier = Modifier.size(70.dp)
//                )
//                Spacer(modifier = Modifier.height(3.dp))
//                Text(
//                    text = "  ?????????@",
//                    color = Color.Gray,
//                    fontSize = 15.sp
//                )
//            }
//        }
//    }
}

// ???????????????
@Composable
fun ChatListItem(chat: Chat){
        val viewModel: ChatViewModel = viewModel()
    Row(
        Modifier
            .clickable {
                viewModel.startChat(chat)
            }
            .fillMaxWidth()
    ) {
        // ??????
        Image(painterResource(id = chat.friend.avatar), contentDescription = chat.friend.name,
            Modifier
                .padding(8.dp)
                .size(60.dp)
                .unread(!chat.msgs.last().read, Color.Red)
                .clip(CircleShape)
                //.clip(RoundedCornerShape(4.dp))
        )

        Column(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            // ??????
            Text(
                text = chat.friend.name,
                fontSize = 22.sp,
                color = Color.Black,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(2.dp))
            // ????????????
            Text(
                text = chat.msgs.last().text,
                fontSize = 17.sp,
                color = Color.Gray,
                maxLines = 1
            )
        }

        // ??????
        Text(
            text = chat.msgs.last().time,
            Modifier.padding(8.dp,8.dp,12.dp,8.dp),
            fontSize = 15.sp,
            color = Color.LightGray
        )
    }
}