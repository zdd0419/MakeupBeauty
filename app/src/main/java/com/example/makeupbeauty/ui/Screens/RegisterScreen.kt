package com.example.makeupbeauty.ui.Screens


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import com.example.makeupbeauty.component.AnimatedButton
import com.example.makeupbeauty.ui.theme.MakeupBeautyTheme

class RegisterScreen: ComponentActivity() {
    companion object{
        fun newIntent(context: Context) =
            Intent(context, RegisterScreen::class.java).apply { putExtra("RegisterScreen",true) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Register()
            }
        }
    }
}

@Composable
fun Register(){
    Surface(color = MaterialTheme.colors.background) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            //add Card
            Card(
                modifier = Modifier.background(color = Color.White),
                elevation = 8.dp ,
                shape = MaterialTheme.shapes.medium
            ) {
                val emailText = remember{
                    mutableStateOf("")
                }
                val passwordText = remember{
                    mutableStateOf("")
                }
                val ConfirmpasswordText = remember{
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
                val primaryColor = MaterialTheme.colors.primary
//                            val annotatedString = remember {
//                                AnnotatedString.Builder("Don't have an account? Register")
//                                    .apply {
//                                        addStyle(style = SpanStyle(color = primaryColor), 23, 31)
//                                    }
//                            }

                // add Column
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    //添加文本框
//                                item{
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logotest),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .size(100.dp)
//                                            .clip(CircleShape)
//                                    )
//                                }
                    item{
                        Spacer(modifier = Modifier.height(60.dp))
                    }
                    item{
                        OutlinedTextField(
                            value = emailText.value,
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
                            label = { Text(text = "Email address") },
                            placeholder = { Text(text = "abc@gmail.com") },
                            onValueChange = {
                                emailText.value = it
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
                            placeholder = { Text(text = "12334444") },
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
                            value = ConfirmpasswordText.value,
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Lock,
                                    //ImageBitmap.imageResource(id = R.drawable.baseline_fingerprint_black_24dp)
                                    contentDescription = "",
                                    tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                                )
                            },
                            trailingIcon = {
                                if (ConfirmshowPwd) {
                                    Icon(
                                        Icons.Filled.VisibilityOff,
                                        contentDescription = "Check fingerprint",
                                        //tint = Color.Green,
                                        //painter = painterResource(id = R.drawable.eye_hide),
                                        tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
                                        //contentDescription = "",
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
                            placeholder = { Text(text = "12334444") },
                            onValueChange = {
                                ConfirmpasswordText.value = it },
                            interactionSource = ConfirmPasswordInteractionState,
                            visualTransformation = ConfirmPasswordVisualTransformation,
                        )
                    }

                    item{
                        Spacer(modifier = Modifier.height(60.dp))
                    }

                    item{
                        AnimatedButton("注册", emailText, passwordText)
                    }

                    item{
                        Spacer(modifier = Modifier.height(60.dp))
                    }
//                                item{
//                                    Box(modifier = Modifier.padding(vertical = 10.dp)) {
//                                        Spacer(
//                                            modifier = Modifier
//                                                .align(Alignment.Center)
//                                                .height(1.dp)
//                                                .fillMaxWidth()
//                                                .background(Color.LightGray)
//                                        )
//                                    }
//                                }
//                                item{
//                                    Text(
//                                        text = annotatedString.toAnnotatedString(),
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .padding(vertical = 16.dp)
//                                            .clickable(onClick = {}),
//                                        textAlign = TextAlign.Center
//                                    )
//                                }
                }
            }
        }
    }
}