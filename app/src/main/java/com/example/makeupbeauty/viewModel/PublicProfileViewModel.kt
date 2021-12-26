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
    val PublicProfileItemList by mutableStateOf(
        listOf(
            PublicProfileItem(
                1,
                "",
                R.drawable.avatar,
                R.drawable.hair,
                ""
            ),
            PublicProfileItem(
                2,
                "",
                R.drawable.avatar,
                R.drawable.face,
                ""
            ),
            PublicProfileItem(
                3,
                "",
                R.drawable.avatar,
                R.drawable.face1,
                ""
            ),
            PublicProfileItem(
                4,
                "",
                R.drawable.avatar,
                R.drawable.face2,
                ""
            ),
            PublicProfileItem(
                5,
                "",
                R.drawable.avatar,
                R.drawable.face3,
                ""
            ),
            PublicProfileItem(
                6,
                "",
                R.drawable.avatar,
                R.drawable.hand,
                ""
            ),
            PublicProfileItem(
                7,
                "",
                R.drawable.avatar,
                R.drawable.hand2,
                ""
            ),
            PublicProfileItem(
                6,
                "",
                R.drawable.avatar,
                R.drawable.hand,
                ""
            ),
            PublicProfileItem(
                6,
                "",
                R.drawable.avatar,
                R.drawable.hand,
                ""
            ),
            PublicProfileItem(
                4,
                "",
                R.drawable.avatar,
                R.drawable.face2,
                ""
            ),
            PublicProfileItem(
                4,
                "",
                R.drawable.avatar,
                R.drawable.face2,
                ""
            )
        )
    )
}