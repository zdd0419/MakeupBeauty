package com.example.makeupbeauty.model.Community

import android.content.Context
import com.ellison.composemovie.util.Utils
import com.example.makeupbeauty.data.PostResponse
import com.example.makeupbeauty.data.bean.Post
import com.example.makeupbeauty.data.bean.PostDetail
import com.example.makeupbeauty.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemotePostData private constructor(context: Context) : PostService {
    private val postInterface: PostService
    private val context: Context

    override suspend fun getPosts(): PostResponse<List<Post>> {
        // Utils.logDebug(Utils.TAG_NETWORK, "searchMoviesByCoroutines:$keyWorld")
        return postInterface.getPosts()
    }

    override suspend fun getPostById(postID: String): PostResponse<PostDetail> {
        // Utils.logDebug(Utils.TAG_NETWORK, "getMovieByCoroutines:$movieID")
        return postInterface.getPostById(postID)
    }

    companion object {
        @Volatile
        private var sInstance: RemotePostData? = null

        fun getInstance(context: Context): RemotePostData? {
            if (sInstance == null) {
                synchronized(RemotePostData::class.java) {
                    if (sInstance == null) {
                        sInstance = RemotePostData(context)
                    }
                }
            }
            return sInstance
        }
    }

    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.OMDB_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        postInterface = retrofit.create(RemotePostData::class.java)
        this.context = context
    }
}