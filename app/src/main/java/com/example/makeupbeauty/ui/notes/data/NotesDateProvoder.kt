package com.example.makeupbeauty.notes.data

import com.example.makeupbeauty.R
import com.example.makeupbeauty.notes.data.newAttention
import com.example.makeupbeauty.ui.AttentionScreen
import com.example.makeupbeauty.ui.AttentionList
import com.example.makeupbeauty.ui.notes

object NotesDateProvoder {
     var newatten= listOf(
         newAttention(
             "dd",
             R.drawable.profile
         ),
         newAttention(
             "ylg",
         R.drawable.user1
        )
     )

    var like_Favorites= listOf(
        Like_and_Attention(
            "哎咿呀",
            R.drawable.profile,
            "点赞"
        ),
        Like_and_Attention(
            "睡不醒",
            R.drawable.user1,
            "收藏"
        ),
        Like_and_Attention(
            "话梅糖",
            R.drawable.profile,
            "收藏"
        ),
        Like_and_Attention(
            "糕哩个糕",
            R.drawable.user1,
            "点赞"
        )
    )

    var Attentionlist = listOf(
        Attention(
            "梨豆子",
            R.drawable.profile
        ),
        Attention(
            "哈库拉玛塔塔",
            R.drawable.user1,
        ),
        Attention(
            "叽叽穷叽叽",
            R.drawable.profile,
        ),
        Attention(
            "饼菠萝",
            R.drawable.profile,
            )
    )

    var CommentList= listOf(
        Comment(
            "哎咿呀",
            R.drawable.profile,
            "哈哈哈哈哈"
        ),
        Comment(
            "睡不醒",
            R.drawable.user1,
            "好好看哦！！"
        ),
        Comment(
            "话梅糖",
            R.drawable.profile,
            "爱了爱了"
        ),
        Comment(
            "糕哩个糕",
            R.drawable.user1,
            "哇~！"
        )
    )

    var Mnotes = mutableListOf(
        notes(
            "圣诞节妆容",
            R.drawable.notes3,
            "过节要画这个又纯又欲的小鹿妆咩"
        ),
        notes(
            "秋冬氛围眼妆",
            R.drawable.notes2,
            "这个眼妆非常适合秋冬日常化的~"
        ),
        notes(
                "贫民窟女孩的平价化妆品",
        R.drawable.notes1,
        "这些彩妆虽然平价，但是非常好用！"
        )
    )
}