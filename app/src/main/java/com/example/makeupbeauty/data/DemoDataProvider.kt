package com.example.makeupbeauty.data
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
        Item(
            1,
            "美妆1",
            "好看的妆容",
            R.drawable.face1
        ),
        Item(
            2,
            "美妆2",
            "好看的妆容",
            R.drawable.face2
        ),
        Item(
            3,
            "美妆3",
            "好看的妆容",
            R.drawable.face3
        ),
        Item(
            4,
            "发色1",
            "好看的发色",
            R.drawable.hair1
        ),
        Item(
            5,
            "发色2",
            "好看的发色",
            R.drawable.hair2
        ),
        Item(
            6,
            "发色3",
            "好看的发色",
            R.drawable.hair3
        ),
        Item(
            7,
            "美甲1",
            "好看的美甲",
            R.drawable.hand1
        ),
        Item(
            8,
            "美甲2",
            "好看的美甲",
            R.drawable.hand2
        ),
        Item(
            9,
            "美甲3",
            "好看的美甲",
            R.drawable.hand3
        ),
        Item(
            10,
            "美甲4",
            "好看的美甲g",
            R.drawable.hand4
        ) ,

        )

    val item = Item(
        1,
        "Awesome List Item",
        "Very awesome list item has very awesome subtitle. This is bit long",
        R.drawable.hair3
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
//            tweetImageId = R.drawable.food15,
            time = "11m"
        ),
        tweet.copy(
            id = 6,
            author = "染发",
            handle = "@Twitter",
            authorImageId = R.drawable.haircard,
//            tweetImageId = R.drawable.food3,
            time = "11m"
        ),
        tweet.copy(
            id = 7,
            author = "美瞳",
            handle = "@Netflix",
            authorImageId = R.drawable.eyecard,
//            tweetImageId = R.drawable.food4,
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
        "棉服设计感小众", "冬季针织帽", "针织喇叭裤",
        "日月晶采眼影", "粉色连衣裙", "费尔岛毛衣",
        "高级感套装裙", "啦啦啦", "羽绒服"
    )

    val userList = listOf(
        User(
            R.drawable.avatar,
            "papi",
            "638112890",
            240,
            3880,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "papi",
            "638112890",
            240,
            3880,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "papi",
            "638112890",
            240,
            3880,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "papi",
            "638112890",
            240,
            3880,
            concern = true
        ),
        User(
            R.drawable.avatar,
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