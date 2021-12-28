package com.example.makeupbeauty.ui.Screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.AnimatedButton
import com.example.makeupbeauty.ui.MainActivity
import com.example.makeupbeauty.ui.theme.MakeupBeautyTheme
import com.example.makeupbeauty.viewModel.LoginOrRegistViewModel
import com.example.makeupbeauty.viewModel.Page
import com.example.makeupbeauty.viewModel.PostViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.InternalCoroutinesApi


class LoginScreen : ComponentActivity() {
    companion object {
        fun newIntent(context: Context) =
            Intent(context, LoginScreen::class.java).apply { putExtra("LoginScreen", true) }
    }

    @ExperimentalPagerApi
    @InternalCoroutinesApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
            val context = LocalContext.current
            val viewModel = LoginOrRegistViewModel(context)
            val page by viewModel.page.observeAsState(Page.SIGN_IN)
            val loading by viewModel.loading.observeAsState(false)
            MakeupBeautyTheme() {
                Crossfade(page) {
                    when (it) {
                        Page.SIGN_IN -> {
                            LoginPage(loading, viewModel.changePage){ name: String, password: String ->
                                viewModel.signIn(name, password)
                                postViewModel.myName = name
                            }
                        }
                        Page.SIGN_UP -> {
                            RegisterPage(loading, viewModel.changePage){ name: String, password: String,confirmedPassword: String ->
                                viewModel.signUp(name, password,confirmedPassword)
                                postViewModel.myName = name
                            }
                        }
                        Page.SIGNED_IN->{
                            context.startActivity(MainActivity.newIntent(context))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LoginPage(
    loading: Boolean = false,
    onPageChange: (Page) -> Unit,
    onDone: (String, String) -> Unit
) {
    val nameText = remember { mutableStateOf("") }
    val passwordText = remember { mutableStateOf("") }
    var hasError by remember { mutableStateOf(false) }
    val pwdVisualTransformation = PasswordVisualTransformation()
    var passwordVisibility by remember {mutableStateOf(true)}
    val transformation = if (passwordVisibility) pwdVisualTransformation else VisualTransformation.None

    val passwordInteractionState = remember { MutableInteractionSource() }
    val emailInteractionState = remember { MutableInteractionSource() }
    val primaryColor = MaterialTheme.colors.primary
    val annotatedString = remember {
        AnnotatedString.Builder("Don't have an account? Register")
            .apply {
                addStyle(style = SpanStyle(color = primaryColor), 23, 31)
            }
    }
    // A surface container using the 'background' color from the theme
    Surface(color = MaterialTheme.colors.background) {
        LoginHeader()
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            // add Column
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                //添加文本框
                item {Spacer(modifier = Modifier.height(140.dp))}
                item {Spacer(modifier = Modifier.height(50.dp))}
                item {
                    OutlinedTextField(
                        value = nameText.value,
                        leadingIcon = {
                            Icon(
                                Icons.Default.ManageAccounts,
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

                item {
                    Spacer(modifier = Modifier.height(8.dp))
                }

                item {
                    OutlinedTextField(
                        value = passwordText.value,
                        leadingIcon = {
                            Icon(
                                Icons.Default.Lock,
                                contentDescription = "",
                                tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                            )
                        },
                        trailingIcon = {
                            if (passwordVisibility) {
                                Icon(
                                    Icons.Filled.VisibilityOff,
                                    contentDescription = "Check fingerprint",
                                    tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clickable(onClick = {
                                            passwordVisibility = !passwordVisibility
                                        })
                                )
                            } else {
                                Icon(
                                    Icons.Filled.Visibility,
                                    tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clickable(onClick = {
                                            passwordVisibility = !passwordVisibility
                                        })
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
                            passwordText.value = it
                        },
                        interactionSource = passwordInteractionState,
                        visualTransformation = transformation,
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
                item {

                    AnimatedButton("登录", nameText, passwordText,
                        onClick = {
                            onDone(nameText.value, passwordText.value)
//                            loginApi("login", emailText.value, passwordText.value)
                        })
                }
                item {
                    Spacer(modifier = Modifier.height(10.dp))
                }
                item {
                    Text(text = "忘记密码", color = Color.Gray, fontSize = 10.sp)
                }
                item {
                    Spacer(modifier = Modifier.height(100.dp))
                }
                item {
                    Box(modifier = Modifier.padding(vertical = 10.dp)) {
                        Spacer(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(Color.LightGray)
                        )
                    }
                }

                item {
                    Text(
                        text = annotatedString.toAnnotatedString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .padding(vertical = 16.dp)
                            .clickable(enabled = !loading) {
                                onPageChange(Page.SIGN_UP)
                            },
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Stable
class QureytoImageShapes(var hudu: Float = 100f) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path()
        path.moveTo(0f, 0f)
        path.lineTo(0f, size.height - hudu)
        path.quadraticBezierTo(size.width / 2f, size.height, size.width, size.height - hudu)
        path.lineTo(size.width, 0f)
        path.close()
        return Outline.Generic(path)
    }
}

@Preview(name = "login")
@Composable
fun LoginHeader() {
    val imageBitmap: ImageBitmap = ImageBitmap.imageResource(R.drawable.head)
    val delectedIcon: ImageBitmap = ImageBitmap.imageResource(R.drawable.logotest)
    Box(contentAlignment = Alignment.Center) {
        Image(
            bitmap = imageBitmap,
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .clip(QureytoImageShapes(160f))
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(0.dp)
                .clip(CircleShape)
                .background(Color(206, 236, 250, 121))
                .width(130.dp)
                .height(130.dp)
        ) {
            Image(
                bitmap = delectedIcon,
                contentDescription = "w",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .background(color = Color(0XFF0DBEBF), shape = CircleShape)
                    .padding(3.dp)
                    .clip(
                        CircleShape
                    )
                    .shadow(elevation = 150.dp, clip = true)
            )
        }
    }
}
