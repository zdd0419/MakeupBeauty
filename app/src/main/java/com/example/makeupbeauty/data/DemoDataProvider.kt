package com.example.makeupbeauty.data
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.models.CarouselItem
import com.example.makeupbeauty.component.models.Goods
import com.example.makeupbeauty.component.models.Item
import com.example.makeupbeauty.component.models.User
import com.example.makeupbeauty.data.model.Tweet
import com.example.makeupbeauty.data.model.storeItem


object DemoDataProvider {
    val storeItemlist= listOf(
        storeItem(
            1,
            "3CE眼影盘",
            R.drawable.ce
        ),
        storeItem(
            2,
            "迪奥气垫粉底",
            R.drawable.cd
        ),
        storeItem(
            3,
            "迪奥精华水",
            R.drawable.dior1
        ),
        storeItem(
            4,
            "迪奥迷你唇膏口红",
            R.drawable.dior2
        ),
        storeItem(
            5,
            "完美日记小细跟口红礼盒",
            R.drawable.perferct
        ),
        storeItem(
            6,
            "moddy新品美瞳",
            R.drawable.moody
        ),

    )

    val itemList = listOf(
//        Item(
//            1,
//            "美妆1",
//            "好看的妆容",
//            R.drawable.face1,
//        ),
//        Item(
//            2,
//            "美妆2",
//            "好看的妆容",
//            R.drawable.face2,
//        ),
//        Item(
//            3,
//            "美妆3",
//            "好看的妆容",
//            R.drawable.face3,
//        ),
//        Item(
//            4,
//            "发色1",
//            "好看的发色",
//            R.drawable.hair1,
//        ),
//        Item(
//            5,
//            "发色2",
//            "好看的发色",
//            R.drawable.hair2,
//        ),
//        Item(
//            6,
//            "发色3",
//            "好看的发色",
//            R.drawable.hair3,
//        ),
//        Item(
//            7,
//            "美甲1",
//            "好看的美甲",
//            R.drawable.hand1,
//        ),
//        Item(
//            8,
//            "美甲2",
//            "好看的美甲",
//            R.drawable.hand2,
//        ),
//        Item(
//            9,
//            "美甲3",
//            "好看的美甲",
//            R.drawable.hand3,
//        ),
//        Item(
//            10,
//            "美甲4",
//            "好看的美甲g",
//            R.drawable.hand4
//        ) ,
        Item(
            1,
            "nyx16色眼妆|高级奶杏",
            "给姐妹们解锁一下NYX16色眼影盘教程",
            "https://s2.loli.net/2021/12/24/Q6HRzi7yUM81Fhp.jpg"
        ) ,
        Item(
            2,
            "创意妆容",
            "我的美妆分享",
            "https://s2.loli.net/2021/12/24/vAE8csN41KJfeGw.jpg",
        ) ,
        Item(
            3,
            "爱上我的新发色",
            "感觉这个发色超显白的，特别温柔喔！分享给姐妹们～",
            "https://s2.loli.net/2021/12/24/lwhVTWevHmu24Po.jpg",
        ) ,
        Item(
            4,
            "单眼皮泰式轻混血妆容",
            "今天的妆容有点泰",
            "https://s2.loli.net/2021/12/24/3CkMgPEOsjaXW2n.jpg",
        ) ,
        Item(
            5,
            "圣诞氛围的诱惑",
            "圣诞派对季当然要染个新发色",
            "https://s2.loli.net/2021/12/24/sMhdw4rCRVJP7xq.jpg",
        ) ,
        Item(
            6,
            "做了好看美甲",
            "#美甲分享 #可爱美甲",
            "https://s2.loli.net/2021/12/24/OlvbU5BL3yZf9Hd.jpg",
        ) ,
        Item(
            7,
            "新发色太适配秋冬啦～",
            "太适合秋冬啦～还小小的整了个挂耳染嘻嘻",
            "https://s2.loli.net/2021/12/24/oHNTCJY6snleKdX.jpg",
        ) ,
        Item(
            8,
            "超可爱的短甲美甲",
            "#手绘美甲 #短甲美甲 #可爱美甲",
            "https://s2.loli.net/2021/12/24/1ng5L4xRQdtTVfH.jpg",
        ) ,
        Item(
            9,
            "清纯萝莉的锁神婴儿瞳~妈生幼态感满分",
            "这是什么小甜心\n" +
                    "吃可爱多长大的吗？",
            "https://s2.loli.net/2021/12/24/F3Hrm7YSWKq2hz1.jpg",
        ) ,
        Item(
            10,
            "90%的人都用错了！新手正确刷酸 |保姆级教程",
            "今天就来给大家出一篇详细的刷酸笔记，包教会！！",
            "https://s2.loli.net/2021/12/24/H1ERZvyPmpSjAs7.jpg",
        ) ,
        Item(
            11,
            "还有人不知道我的真命美瞳吗？",
            "被问了一万次的olens someday brown",
            "https://s2.loli.net/2021/12/24/PMlDvXNo9IBSEQY.jpg",
        ) ,
        Item(
            12,
            "每天敲爱的洗脸环节！",
            "这个泡泡也太舒服了",
            "https://s2.loli.net/2021/12/24/9xSh1B2dzEQguVI.jpg",
        ) ,
        Item(
            13,
            "别瞎买了！锁si兰蔻菁纯！提亮嘭弹刹不住车",
            "兰蔻菁纯必拥有姓名",
            "https://s2.loli.net/2021/12/24/RojYUlJfcSG2mKz.jpg",
        ) ,
    )


    val tweet = Tweet(
        1,
        "Jetpack compose is the next thing for andorid. Declarative UI is the way to go for all screens.",
        "口红",
        "@verge",
        "12m",
        R.drawable.khcard,
        100,
        12,
        15,
        "Twitter for web"
    )
    val tweetList = listOf(
        tweet,
        tweet.copy(
            id = 2,
            author = "眼影",
            handle = "@google",
            authorImageId = R.drawable.yancard,
//            tweetImageId = R.drawable.eyecard,
            time = "11m"
        ),
        tweet.copy(
            id = 3,
            author = "卸妆",
            handle = "@Amazon",
            authorImageId = R.drawable.xiezhuang,
            time = "1h"
        ),
        tweet.copy(
            id = 4,
            author = "护肤",
            handle = "@Facebook",
            authorImageId = R.drawable.hufu,
            time = "1h"
        ),
        tweet.copy(
            id = 5,
            author = "底妆",
            handle = "@Instagram",
            authorImageId = R.drawable.fendicard,
            //tweetImageId = R.drawable.food15,
            time = "11m"
        ),
        tweet.copy(
            id = 6,
            author = "染发",
            handle = "@Twitter",
            authorImageId = R.drawable.haircard,
            //tweetImageId = R.drawable.food3,
            time = "11m"
        ),
        tweet.copy(
            id = 7,
            author = "美瞳",
            handle = "@Netflix",
            authorImageId = R.drawable.eyecard,
            //tweetImageId = R.drawable.food4,
            time = "11m"
        ),
        tweet.copy(
            id = 8,
            author = "美甲",
            handle = "@Tesla",
            authorImageId = R.drawable.handcard,
            time = "1h"
        )


    )

    val adlist = listOf(
        CarouselItem(
            id = R.drawable.hand1
        ),
        CarouselItem(
            id = R.drawable.hand2
        ),
        CarouselItem(
            id = R.drawable.hand3
        ),
        CarouselItem(
            id = R.drawable.hand4
        ),
        CarouselItem(
            id = R.drawable.hair
        )
    )

    val historyList = listOf(
        "siggi", "连衣裙", "TOP",
        "完美日记", "围巾", "针织帽"
    )

    val discoveryList = listOf(
        "棉服设计感", "冬季针织帽", "针织喇叭裤",
        "日月晶采", "粉色连衣裙", "费尔岛毛衣",
        "套装裙", "啦啦啦", "羽绒服"
    )

    val userList = listOf(
        User(
            R.drawable.user1,
            "papi",
            "638112890",
            240,
            3880,
            concern = true
        ),
        User(
            R.drawable.user1,
            "papi",
            "638112890",
            240,
            3880,
            concern = true
        ),
        User(
            R.drawable.user1,
            "papi",
            "638112890",
            240,
            3880,
            concern = true
        ),
        User(
            R.drawable.user1,
            "papi",
            "638112890",
            240,
            3880,
            concern = true
        ),
        User(
            R.drawable.user1,
            "papi",
            "638112890",
            240,
            3880,
            concern = true
        )
    )

    val goodsList = listOf(
        Goods(
            R.drawable.hand,
            "浮生八记连衣裙",
            230.5f
        ),
        Goods(
            R.drawable.face3,
            "浮生八记连衣裙",
            230.5f
        ),
        Goods(
            R.drawable.post1,
            "浮生八记连衣裙",
            230.5f
        ),
        Goods(
            R.drawable.post1,
            "浮生八记连衣裙",
            230.5f
        ),
        Goods(
            R.drawable.post1,
            "浮生八记连衣裙",
            230.5f
        ),
        Goods(
            R.drawable.post1,
            "浮生八记连衣裙",
            230.5f
        )
    )



}
