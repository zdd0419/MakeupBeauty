package com.example.makeupbeauty.viewModel

import androidx.lifecycle.ViewModel
import com.example.makeupbeauty.commodityDetail.pay
import com.example.makeupbeauty.commodityDetail.total
import com.example.makeupbeauty.data.CartItemData

class CartViewModel: ViewModel() {
    var totalNum = 0
    val cartItemList = mutableListOf<CartItemData>()
    val payItemList = mutableListOf<CartItemData>()
    fun addCartItem(imageId:String, title: String, price: Double, count: String){
        cartItemList.add(
            CartItemData(
                id = totalNum + 1,
                imagePainter = imageId,
                title = title,
                price = price,
                count = count,
                pricetag = "￥"
        ))
        totalNum += 1
    }
    fun getTotalPrice():Double{
        var totalprice = 0.0
        cartItemList.forEach{
            totalprice += it.price
        }
        return totalprice
    }

    fun addToPay(id: Int){
        payItemList.add(cartItemList[id])
    }
    fun removeFromPay(id:Int){
        payItemList.forEach{
            if (it.id == id){
                payItemList.remove(it)
                return@forEach
            }
        }
    }
}