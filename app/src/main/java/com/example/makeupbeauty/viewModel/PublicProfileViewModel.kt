package com.example.makeupbeauty.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.models.Chat
import com.example.makeupbeauty.component.models.ChatUser
import com.example.makeupbeauty.component.models.Msg
import com.example.makeupbeauty.component.models.PublicProfileItem

class PublicProfileViewModel: ViewModel() {

    val PublicProfileCommendItemList = listOf(
        PublicProfileItem(
            1,
            "小熊",
            R.drawable.avatar,
            R.drawable.hair,
            "小熊小可爱啦啦啦啦啦啦"
        ),
        PublicProfileItem(
            2,
            "小羊",
            R.drawable.avatar,
            R.drawable.face,
            "五五五五五五五五啦啦啦啦啦啦"
        ),
        PublicProfileItem(
            3,
            "小熊",
            R.drawable.avatar,
            R.drawable.face1,
            "小熊小可爱啦啦啦啦啦啦"
        ),
        PublicProfileItem(
            4,
            "小样",
            R.drawable.avatar,
            R.drawable.face2,
            "小熊小可爱啦啦啦啦啦啦"
        ),
        PublicProfileItem(
            5,
            "小熊",
            R.drawable.avatar,
            R.drawable.face3,
            "小熊小可爱啦啦啦啦啦啦"
        ),
        PublicProfileItem(
            6,
            "小熊",
            R.drawable.avatar,
            R.drawable.hand,
            "小熊小可爱啦啦啦啦啦啦"
        ),
        PublicProfileItem(
            7,
            "小熊",
            R.drawable.avatar,
            R.drawable.hand2,
            "小熊小可爱啦啦啦啦啦啦"
        ),
        PublicProfileItem(
            6,
            "小熊",
            R.drawable.avatar,
            R.drawable.hand,
            "小熊小可爱啦啦啦啦啦啦"
        ),
        PublicProfileItem(
            6,
            "小熊",
            R.drawable.avatar,
            R.drawable.hand,
            "小熊小可爱啦啦啦啦啦啦"
        ),
        PublicProfileItem(
            4,
            "小样",
            R.drawable.avatar,
            R.drawable.face2,
            "小熊小可爱啦啦啦啦啦啦"
        ),
        PublicProfileItem(
            4,
            "小样",
            R.drawable.avatar,
            R.drawable.face2,
            "小熊小可爱啦啦啦啦啦啦"
        )
    )
}