package com.example.makeupbeauty.notes.data

import com.example.makeupbeauty.R
import com.example.makeupbeauty.notes.data.newAttention
import com.example.makeupbeauty.notes.notes

object NotesDateProvoder {
 var newatten= listOf(
     newAttention(
         "dd",
         R.drawable.profile
     ),
     newAttention(
         "ylg",
     R.drawable.avatar
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