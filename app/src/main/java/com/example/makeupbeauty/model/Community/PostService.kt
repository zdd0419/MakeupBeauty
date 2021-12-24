package com.example.makeupbeauty.model.Community

import com.example.makeupbeauty.data.PostResponse
import com.example.makeupbeauty.data.bean.Post
import com.example.makeupbeauty.data.bean.PostDetail
import retrofit2.http.GET
import retrofit2.http.Query

interface PostService {
    @GET("http://omdbapi.com/")
    suspend fun getPosts(): PostResponse<List<Post>>

    @GET("http://omdbapi.com/")
    suspend fun getPostById(
        @Query("id") id: String,
    ): PostResponse<PostDetail>
}