package com.example.makeupbeauty.data

data class PostResponse<T> (
    var TotalResults: String = "0",
    var Response: String = "false",
    var Error: String = "null",
    var res: T
)