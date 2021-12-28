package com.example.makeupbeauty.viewModel

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ellison.composemovie.util.Utils
import kotlinx.coroutines.launch
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException

class LoginOrRegistViewModel(
    private val context: Context,
) : ViewModel() {

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?> = _error

    private val _page = MutableLiveData(Page.SIGN_IN)
    val page: LiveData<Page> = _page

    val userInfo: SharedPreferences = context.getSharedPreferences("userInfo", Activity.MODE_PRIVATE)
    var editor: SharedPreferences.Editor = userInfo.edit()

    fun removeError() {
        _error.value = null
    }

    val changePage: (Page) -> Unit = {
        _page.value = it
    }

    fun signUp(name: String, password: String, confirmedPassword: String) = launchDataLoad {
        //validate inputs
        validNameOrThrow(name)
        validPasswordOrThrow(password)
        if (confirmedPassword != password) throw IllegalArgumentException("The password do not match")
        //sign up
        signUpWithEmail(name, password)
        //notify user is signed in
    }

    fun signIn(email: String, password: String)= launchDataLoad {
        //validate inputs
        validNameOrThrow(email)
        validPasswordOrThrow(password)
        signInWithName(email, password)
    }

    private fun launchDataLoad(block: suspend () -> Unit) = viewModelScope.launch {
        if (Utils.ensureNetworkAvailable(context, true)) {
            _loading.postValue(true)
            try {
                block()
            } catch (e: Exception) {
                Toast.makeText(context,e.localizedMessage, Toast.LENGTH_LONG).show()
            }
            _loading.postValue(false)
        } else {
            _error.postValue("You are offline, please check your internet connection.")
        }
    }

    private fun validNameOrThrow(name: String) {
        if (name.length > 15){
            throw Exception("The name should shorter than 15")
        }
    }

    fun validPasswordOrThrow(password: String) {
        if (password.length < 6) throw Exception("Password should be at least 6 characters")
    }

    private fun signInWithName(name: String, password: String): Unit {
        //调用http接口
        val client = OkHttpClient()
        val JSON: MediaType = "application/json".toMediaType()
        val baseUrl = "http://zrp.cool:8000"
        val url = "$baseUrl/login/"

//        print(name)
//        print(password)

        val json = JSONObject()
        json.put("type", "login")
        json.put("name", name)
        json.put("password", password)
        val requestBody: RequestBody = json.toString().toRequestBody(JSON)

        var builder = Request.Builder()
        builder.url(url)
        builder.addHeader("Content-Type", "application/json")
            .post(requestBody)

        client.newCall(builder.build()).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("————失败了$e")
                Toast.makeText(context,"please check network connection", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call, response: Response) {
                var stA = response.body!!.string()
                println("————成功 $stA")
                if (stA.equals("{\"non_field_errors\":[\"用户名不存在\"]}")) {
                    Toast.makeText(context,"username does not exist", Toast.LENGTH_LONG).show()
                }else if(stA.equals("{\"non_field_errors\":[\"用户名或者密码错误\"]}")){
                    Toast.makeText(context,"username or password incorrect", Toast.LENGTH_LONG).show()
                }else{
                    editor.putString("username", name)
                    _page.postValue(Page.SIGNED_IN)
                    editor.commit()
                }
            }

        })
    }

    fun signUpWithEmail(name: String, password: String): Unit {
        //调用http接口
        val client = OkHttpClient()
        val JSON: MediaType = "application/json".toMediaType()
        val baseUrl = "http://zrp.cool:8000"
        val url = "$baseUrl/register/"

//        print(email)
//        print(password)

        val json = JSONObject()
        json.put("type", "register")
        json.put("name", name)
        json.put("password", password)
//        body 里添加参数
        val requestBody: RequestBody = json.toString().toRequestBody(JSON)


        var builder = Request.Builder()
        builder.url(url)
        builder.addHeader("Content-Type","application/json")
            .post(requestBody)


        client.newCall(builder.build()).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Toast.makeText(context,"用户名不存在或密码错误", Toast.LENGTH_LONG).show()
                println("————失败了$e")
            }

            override fun onResponse(call: Call, response: Response) {
                var stA = response.body!!.string()
                println("————成功 $stA")
                if (stA.equals("{\"non_field_errors\":[\"用户名不存在\"]}")) {
                    Toast.makeText(context,"用户名不存在或密码错误", Toast.LENGTH_LONG).show()
                }else{
                    editor.putString("username", name)
                    _page.postValue(Page.SIGNED_IN)
                    editor.commit()
                }
            }

        })

    }
}

enum class Page { SIGN_UP, SIGN_IN,SIGNED_IN }
