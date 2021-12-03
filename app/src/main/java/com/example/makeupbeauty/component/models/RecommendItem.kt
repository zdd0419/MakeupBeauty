package com.example.makeupbeauty.component.models

data class RecommendItem(
    val id: Int,
    val title: String,
    val subtitle: String,
    val imageId: Int,
    val source: String = "demo source"
)
