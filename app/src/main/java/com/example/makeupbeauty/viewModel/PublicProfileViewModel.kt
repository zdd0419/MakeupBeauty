package com.example.makeupbeauty.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.models.*
import com.example.makeupbeauty.data.notesData

class PublicProfileViewModel: ViewModel() {
    val My_Post= mutableListOf(
        notesData(
            1,
            "赫本，永远不会过时",
            "Elegance is the only beauty that never fades .--- Audrey Hepburn\n" +
                    "优雅是唯一不会褪色的美。———奥黛丽.赫本\n "+"onchic 小心诗比较法式的一款,但是也没有很浮夸,平时约会带配裙子很赞",
            "小羊",
            "https://img.zrp.cool/2021/12/26/3ae3b54bc4c12.jpg",
            0,
            0,
            arrayListOf<String>(
                "https://img.zrp.cool/2021/12/25/4880a230047c6.jpg",
                "https://img.zrp.cool/2021/12/25/ea230ef06162c.jpg",
                "https://img.zrp.cool/2021/12/25/c64f04dd0e747.jpg",
                "https://img.zrp.cool/2021/12/25/d7ec4a7ba3691.jpg",
                "https://img.zrp.cool/2021/12/25/7e25a3ee03ae4.jpg",
                "https://img.zrp.cool/2021/12/25/4880a230047c6.jpg"
            ),

            arrayListOf<Comment> (
                Comment("1", "1", "1", "1", 1)
            ),
            "2021-12-26"
        ),
        notesData(
            2,
            "赫本，永远不会过时",
            "Elegance is the only beauty that never fades .--- Audrey Hepburn\n" +
                    "优雅是唯一不会褪色的美。———奥黛丽.赫本\n "+"onchic 小心诗比较法式的一款,但是也没有很浮夸,平时约会带配裙子很赞",
            "小羊",
            "https://img.zrp.cool/2021/12/26/3ae3b54bc4c12.jpg",
            0,
            0,
            arrayListOf<String>(
                "https://img.zrp.cool/2021/12/25/4880a230047c6.jpg",
                "https://img.zrp.cool/2021/12/25/ea230ef06162c.jpg",
                "https://img.zrp.cool/2021/12/25/c64f04dd0e747.jpg",
                "https://img.zrp.cool/2021/12/25/d7ec4a7ba3691.jpg",
                "https://img.zrp.cool/2021/12/25/7e25a3ee03ae4.jpg",
                "https://img.zrp.cool/2021/12/25/4880a230047c6.jpg"
            ),

            arrayListOf<Comment> (
                Comment("1", "1", "1", "1", 1)
            ),
            "2021-12-26"
        ),
//        notesData(
//            3,
//            "",
//            ""
//                    +""
//                    +""
//                    +""
//                    +""
//                    +""
//                    +""
//                    +""
//                    +""
//                    +"",
//            "",
//            "",
//            0,
//            0,
//            arrayListOf<String>(
//0
//            ),
//
//            arrayListOf<Comment> (
//                Comment("1", "1", "1", "1", 1)
//            ),
//            ""
//        ),
    )

    val myAvatar = "https://img.zrp.cool/2021/12/26/3ae3b54bc4c12.jpg" //本人头像
    var index by mutableStateOf(0)
    var option by mutableStateOf(0)    //0:concern, 1:recommend

    fun changeConcern(i: Int) {
        index = i;
        option = 0;
    }

    fun changeRecommend(i: Int) {
        index = i;
        option = 1;
    }


    fun getPost(): notesData {
        return My_Post.elementAt(index)
    }
}