package com.example.makeupbeauty.data.bean

data class PostDetail(
    var user: String,
    var like_num: Int,
    var title: String,
    var content: String,
    var content_num: Int
)

val testPostDetail = PostDetail(
    user = "用户123",
    like_num = 10,
    title = "Title 标题",
    content = "世界杯是会计师报是就开始打包覅噢回复",
    content_num = 100
)