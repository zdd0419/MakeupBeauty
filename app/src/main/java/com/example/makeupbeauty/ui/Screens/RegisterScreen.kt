package com.example.makeupbeauty.ui.Screens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import com.example.makeupbeauty.component.AnimatedButton
import com.example.makeupbeauty.viewModel.Page
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException

@Composable
fun RegisterPage(
    loading: Boolean = false,
    onPageChange: (Page) -> Unit,
    onDone: (String, String,String) -> Unit
){
    Surface(color = MaterialTheme.colors.background) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            //add Card
            Card(
                modifier = Modifier.background(color = Color.White),
                elevation = 8.dp ,
                shape = MaterialTheme.shapes.medium
            ) {
                val nameText = remember{
                    mutableStateOf("")
                }
                val passwordText = remember{
                    mutableStateOf("")
                }
                val confirmpasswordText = remember{
                    mutableStateOf("")
                }
                var hasError by remember { mutableStateOf(false) }
                var passwordVisualTransformation by remember {
                    mutableStateOf<VisualTransformation>(
                        PasswordVisualTransformation()
                    )
                }
                val passwordInteractionState = remember { MutableInteractionSource() }
                var showPwd by remember {
                    mutableStateOf(true)
                }
                var ConfirmshowPwd by remember {
                    mutableStateOf(true)
                }

                var ConfirmPasswordVisualTransformation by remember {
                    mutableStateOf<VisualTransformation>(
                        PasswordVisualTransformation()
                    )
                }
                val ConfirmPasswordInteractionState = remember { MutableInteractionSource() }

                val emailInteractionState = remember { MutableInteractionSource() }
                // add Column
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    //???????????????
                    item{
                        Spacer(modifier = Modifier.height(60.dp))
                    }
                    item{
                        OutlinedTextField(
                            value = nameText.value,
                            leadingIcon = {
                                Icon(Icons.Default.Email,
                                    contentDescription = "",
                                    tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                                )
                            },
                            maxLines = 1,
                            isError = hasError,
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            label = { Text(text = "User name") },
                            placeholder = { Text(text = "Jane") },
                            onValueChange = {
                                nameText.value = it
                            },
                            interactionSource = emailInteractionState,
                        )
                    }

                    item{
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    item{
                        OutlinedTextField(
                            value = passwordText.value,
                            leadingIcon = {
                                Icon(Icons.Default.Lock,
                                    contentDescription = "",
                                    tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)) },
                            trailingIcon = {
                                if (showPwd) {
                                    Icon(
                                        Icons.Filled.VisibilityOff,
                                        contentDescription = "Check fingerprint",
                                        //tint = Color.Green,
                                        //painter = painterResource(id = R.drawable.eye_hide),
                                        tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
                                        //contentDescription = "",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .clickable(onClick = {showPwd = !showPwd})
                                    )
                                } else {
                                    Icon(
                                        Icons.Filled.Visibility,
                                        tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .clickable(onClick = {showPwd = !showPwd})
                                    )
                                }
                            },
                            maxLines = 1,
                            isError = hasError,
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password,
                                imeAction = ImeAction.Done
                            ),
                            label = { Text(text = "Password") },
                            onValueChange = {
                                passwordText.value = it },
                            interactionSource = passwordInteractionState,
                            visualTransformation = passwordVisualTransformation,
                        )
                    }

                    item{
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    item{
                        OutlinedTextField(
                            value = confirmpasswordText.value,
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Lock,
                                    contentDescription = "",
                                    tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                                )
                            },
                            trailingIcon = {
                                if (ConfirmshowPwd) {
                                    Icon(
                                        Icons.Filled.VisibilityOff,
                                        contentDescription = "Check fingerprint",
                                        tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
                                        modifier = Modifier
                                            .size(30.dp)
                                            .clickable(onClick = {ConfirmshowPwd = !ConfirmshowPwd})
                                    )
                                } else {
                                    Icon(
                                        Icons.Filled.Visibility,
                                        tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .clickable(onClick = {ConfirmshowPwd = !ConfirmshowPwd})
                                    )
                                }
                            },
                            maxLines = 1,
                            isError = hasError,
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password,
                                imeAction = ImeAction.Done
                            ),
                            label = { Text(text = "Confirm Password") },
                            onValueChange = {
                                confirmpasswordText.value = it },
                            interactionSource = ConfirmPasswordInteractionState,
                            visualTransformation = ConfirmPasswordVisualTransformation,
                        )
                    }

                    item{
                        Spacer(modifier = Modifier.height(60.dp))
                    }

                    item{
                        AnimatedButton("??????", nameText, passwordText, onClick = {
                            onDone(nameText.value, passwordText.value,confirmpasswordText.value)
                        })
                    }

                    item{
                        Spacer(modifier = Modifier.height(60.dp))
                    }
                }
            }
        }
    }
}

fun RegisterApi(type:String, email: String, password: String){

//    var params:MutableMap<String,Any> = mutableMapOf<String,Any>()
//    params.set("cellphone","0001211")
//    params.set("country_code","+63")
//    params.set("verification_code","334455")
    val client = OkHttpClient()
    val JSON: MediaType = "application/json".toMediaType()
    val baseUrl = "http://zrp.cool:8000"
    val url = "$baseUrl/register/"

    print(email)
    print(password)

    val json = JSONObject()
    json.put("type", type)
    json.put("name", email)
    json.put("password", password)
//        body ???????????????
    val requestBody: RequestBody = json.toString().toRequestBody(JSON)
    // ??????????????????
//        val requestBody: RequestBody = RequestBody.create(JSON, json.toString())
//        RequestBody.create()


    var builder = Request.Builder()
    builder.url(url)
    builder.addHeader("Content-Type","application/json")
//        .addHeader("??????1","value")
//        .addHeader("??????2","value")
        .post(requestBody)


    client.newCall(builder.build()).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            println("?????????????????????$e")
        }

        override fun onResponse(call: Call, response: Response) {
            var stA = response.body!!.string()
            println("?????????????????? $stA")

//
//            runOnUiThread(){
//                // ?????????????????????UI???
//                textView22!!.text = stA
//            }

        }

    })

}