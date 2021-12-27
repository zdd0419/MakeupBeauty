package com.example.makeupbeauty.viewModel

import androidx.lifecycle.ViewModel
import com.example.makeupbeauty.data.OrdetData

class OrderViewModel :ViewModel(){
    val unPayorderlist = mutableListOf<OrdetData>()

    fun addOrder(title: String, price:Double, count: Int, address: String, status: String, image: String)
    {
        unPayorderlist.add(
            OrdetData(
                title = title,
                price = price,
                count = count,
                address = address,
                image = image,
                status = status
            )
        )
    }
}