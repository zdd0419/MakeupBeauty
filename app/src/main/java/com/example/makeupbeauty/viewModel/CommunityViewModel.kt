package com.example.makeupbeauty.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ellison.composemovie.util.Utils
import com.example.makeupbeauty.R
import com.example.makeupbeauty.data.bean.Post
import com.example.makeupbeauty.data.bean.PostDetail
import com.example.makeupbeauty.model.Community.RemotePostData

class CommunityViewModel(application: Application) : AndroidViewModel(application) {
    private val remotePostData = RemotePostData.getInstance(application.applicationContext)

    private var postsLiveData = MutableLiveData<List<Post>>()
    private var postDetailLiveData = MutableLiveData<PostDetail>()

    val posts: LiveData<List<Post>> = postsLiveData
    val postDetail: LiveData<PostDetail> = postDetailLiveData

    suspend fun getPosts() {
        // Utils.logDebug(Utils.TAG_SEARCH, "MovieModel searchMoviesComposeCoroutines with keyWord:$keyWorld")
        if (!Utils.ensureNetworkAvailable(getApplication())) return

        val gotPosts = remotePostData?.getPosts()?.res
//        Utils.logDebug(
//            Utils.TAG_SEARCH,
//            "MovieModel searchMoviesCoroutines gotMovies:$gotMovies"
//        )

        if (gotPosts != null)
            postsLiveData.value = gotPosts!!
        else
            Toast.makeText(getApplication(), "Error", Toast.LENGTH_SHORT)
                .show()
    }

    suspend fun getPostById(id: String) {
        Utils.logDebug(Utils.TAG_SEARCH, "MovieModel getMovieComposeCoroutines with id:$id")
        if (!Utils.ensureNetworkAvailable(getApplication())) return

        val gotPostDetail = remotePostData?.getPostById(id)
        // Utils.logDebug(Utils.TAG_SEARCH, "MovieModel getMovieComposeCoroutines movie:$gotMovie")

        if (gotPostDetail != null)
            postDetailLiveData.value = gotPostDetail.res!!
        else
            Toast.makeText(getApplication(), "Error", Toast.LENGTH_SHORT)
                .show()
    }
}
