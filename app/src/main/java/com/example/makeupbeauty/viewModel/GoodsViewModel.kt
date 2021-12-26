package com.example.makeupbeauty.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.makeupbeauty.data.productDeatil

class GoodsViewModel (application: Application) : AndroidViewModel(application){
    private var goodsLivaData = MutableLiveData<List<productDeatil>>();


}