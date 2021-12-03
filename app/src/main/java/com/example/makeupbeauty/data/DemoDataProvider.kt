package com.example.makeupbeauty.data
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.models.CarouselItem
import com.example.makeupbeauty.component.models.RecommendItem


object DemoDataProvider {

    val itemList = listOf(
        RecommendItem(
            1,
            "美妆1",
            "好看的妆容",
            R.drawable.face1
        ),
        RecommendItem(
            2,
            "美妆2",
            "好看的妆容",
            R.drawable.face2
        ),
        RecommendItem(
            3,
            "美妆3",
            "好看的妆容",
            R.drawable.face3
        ),
        RecommendItem(
            4,
            "发色1",
            "好看的发色",
            R.drawable.hair1
        ),
        RecommendItem(
            5,
            "发色2",
            "好看的发色",
            R.drawable.hair2
        ),
        RecommendItem(
            6,
            "发色3",
            "好看的发色",
            R.drawable.hair3
        ),
        RecommendItem(
            7,
            "美甲1",
            "好看的美甲",
            R.drawable.hand1
        ),
        RecommendItem(
            8,
            "美甲2",
            "好看的美甲",
            R.drawable.hand2
        ),
        RecommendItem(
            9,
            "美甲3",
            "好看的美甲",
            R.drawable.hand3
        ),
        RecommendItem(
            10,
            "美甲4",
            "好看的美甲g",
            R.drawable.hand4
        )

    )

    val item = RecommendItem(
        1,
        "Awesome List Item",
        "Very awesome list item has very awesome subtitle. This is bit long",
        R.drawable.hair3
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


}