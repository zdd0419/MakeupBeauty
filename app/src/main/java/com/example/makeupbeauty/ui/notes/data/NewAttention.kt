package com.example.makeupbeauty.notes.data

data class newAttention(
    val name: String,
    val imageID: Int,
)

data class Like_and_Attention(
    val name: String,
    val imageID: Int,
    val title: String
)

data class Attention(
    val name: String,
    val imageID: Int
)

data class Comment(
    val name: String,
    val imageID: Int,
    val title: String
)