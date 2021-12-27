package com.example.makeupbeauty.data

import androidx.compose.ui.graphics.painter.Painter

data class CartItemData (
    val id: Int,
    val imagePainter: String,
    val title: String,
    val price: Double,
    val pricetag: String,
    val count: Int,
)