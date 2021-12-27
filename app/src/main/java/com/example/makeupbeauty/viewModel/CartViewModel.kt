package com.example.makeupbeauty.viewModel

import androidx.lifecycle.ViewModel
import com.example.makeupbeauty.commodityDetail.pay
import com.example.makeupbeauty.commodityDetail.total
import com.example.makeupbeauty.data.CartItemData

class CartViewModel: ViewModel() {
    var totalNum = 0
    val cartItemList = mutableListOf<CartItemData>()
    val payItemList = mutableListOf<CartItemData>()
    fun addCartItem(imageId:String, title: String, price: Double, count: Int){
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
    fun removeFromCart(id:Int){
        val iter = cartItemList.listIterator()

        while (iter.hasNext()){
            val item = iter.next()
            if(item.id == id){
                iter.remove()
            }
        }
    }
    fun getTotalPriceInCart():Double{
        var totalprice = 0.0
        cartItemList.forEach{
            totalprice += it.price * it.count
        }
        return totalprice
    }
    fun getTotalPriceInOrder():Double{
        var total = 0.0
        payItemList.forEach{
            total += it.price * it.count
        }
        return total
    }
    fun addToPay(id: Int){
        cartItemList.forEach{
            if (it.id == id){
                payItemList.add(it)
                return@forEach
            }
        }
    }
    fun removeFromPay(id:Int){
        val iter = payItemList.listIterator()

        while (iter.hasNext()){
            val item = iter.next()
            if(item.id == id){
                iter.remove()
            }
        }
    }
}