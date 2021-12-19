package com.example.makeupbeauty.Screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
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
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.AnimatedButton
import com.example.makeupbeauty.ui.theme.MakeupBeautyTheme


class LoginScreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MakeupBeautyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginPage()
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        //add Card
//                        Card(
//                            modifier = Modifier.background(color = Color.White),
//                            elevation = 8.dp ,
//                            shape = MaterialTheme.shapes.medium
//                        ) {
                            val emailText = remember{
                                mutableStateOf("")
                            }
                            val passwordText = remember{
                                mutableStateOf("")
                            }
                            var hasError by remember { mutableStateOf(false) }
                            val pwdVisualTransformation = PasswordVisualTransformation()
                            var showPwd by remember {
                                mutableStateOf(true)
                            }

                            val transformation = if (showPwd) pwdVisualTransformation else VisualTransformation.None

                            val passwordInteractionState = remember { MutableInteractionSource() }
                            val emailInteractionState = remember { MutableInteractionSource() }
                            val primaryColor = MaterialTheme.colors.primary
                            val annotatedString = remember {
                                AnnotatedString.Builder("Don't have an account? Register")
                                    .apply {
                                        addStyle(style = SpanStyle(color = primaryColor), 23, 31)
                                    }
                            }
//                            val colors = TextFieldDefaults.outlinedTextFieldColors(
//                                    focusedBorderColor = Color.Black,
//                                    unfocusedBorderColor = Color.Gray,
//                                    cursorColor = Color.Gray
//                                )

                            // add Column
                            LazyColumn(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier.padding(horizontal = 16.dp)
                            ) {
                                //添加文本框
                                item{
                                    Spacer(modifier = Modifier.height(140.dp))
                                }
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
                                    Spacer(modifier = Modifier.height(50.dp))
                                }
                                item{
                                    //                                Text(
//                                    text = "电子邮件",
//                                    color = Color.Black,
//                                    modifier = Modifier.fillMaxWidth(0.85f),
//                                    textAlign = TextAlign.Left
//                                )
//                                MyTextField(
//                                    value = emailText.value,
//                                    colors = colors,
//                                    trailingIcon = Icons.Default.Email,
//                                    trailingtintIcon = Color.Black,
//                                    modifier = Modifier.fillMaxWidth(0.85f),
//                                    keyboardOptions = KeyboardOptions(
//                                        keyboardType = KeyboardType.Email
//                                    ),
//                                    onValueChange = {
//                                        emailText.value = it
//                                    }
//                                )
                                    OutlinedTextField(
                                        value = emailText.value,
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.Email,
                                                contentDescription = "",
                                                tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                                            )
//                                        FaIcon(
//                                            faIcon = FaIcons.Envelope,
//                                            tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
//                                        )
                                        },
                                        //trailingIcon = { Icon(Icons.Default.Email, contentDescription = "")},
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
//                                    Text(
//                                    text = "密码",
//                                    color = Color.Black,
//                                    modifier = Modifier.fillMaxWidth(0.85f),
//                                    textAlign = TextAlign.Left
//                                    )
//                                MyTextField(
//                                    value = passwordText.value,
//                                    colors = colors,
//                                    trailingIcon = Icons.Default.Lock,
//                                    trailingtintIcon = Color.Black,
//                                    modifier = Modifier.fillMaxWidth(0.85f),
//                                    keyboardOptions = KeyboardOptions(
//                                        keyboardType = KeyboardType.Password
//                                    ),
//                                    visualTransformation = PasswordVisualTransformation(),
//                                    onValueChange = {
//                                        passwordText.value = it
//                                    }
//                                )
                                    OutlinedTextField(
                                        value = passwordText.value,
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.Lock,
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
//                                                    Icon(Icons.Default.Lock,
//                                                        contentDescription = "",
//                                                        tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
//                                                        modifier = Modifier.clickable(onClick = {
//                                                            passwordVisualTransformation =
//                                                                if (passwordVisualTransformation != VisualTransformation.None) {
//                                                                    VisualTransformation.None
//                                                                } else {
//                                                                    PasswordVisualTransformation()
//                                                                }
//                                                        }))
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
                                        //visualTransformation = passwordVisualTransformation,
                                        visualTransformation = transformation,
                                    )
                                }

                                item{
                                    Spacer(modifier = Modifier.height(16.dp))
                                }
                                item{
                                    //添加按钮
//                                Button(
//                                    onClick = { /*TODO*/ },
//                                    colors = ButtonDefaults.buttonColors(
//                                            backgroundColor = Color.Blue,
//                                            disabledBackgroundColor = Color.Blue.copy(0.5f)
//                                    ),
//                                    modifier = Modifier
//                                        .height(46.dp)
//                                        .width(280.dp),
//                                    enabled = emailText.value.isNotBlank() && passwordText.value.isNotBlank(),
//                                    shape = MaterialTheme.shapes.medium
//                                ) {
//                                    Text(text = "登录", color = Color.White)
//                                }
                                    AnimatedButton("登录", emailText, passwordText)
                                }

                                item{
                                    Spacer(modifier = Modifier.height(10.dp))
                                }
                                item{
                                    Text(text = "忘记密码", color = Color.Gray, fontSize = 10.sp)
                                }
                                item{
                                    Spacer(modifier = Modifier.height(100.dp))
                                }
                                item{
                                    Box(modifier = Modifier.padding(vertical = 10.dp)) {
                                        Spacer(
                                            modifier = Modifier
                                                .align(Alignment.Center)
                                                .height(1.dp)
                                                .fillMaxWidth()
                                                .background(Color.LightGray)
                                        )
//                                    Text(
//                                        text = "",
//                                        color = Color.LightGray,
//                                        modifier = Modifier
//                                            .align(Alignment.Center)
//                                            .background(MaterialTheme.colors.background)
//                                            .padding(horizontal = 16.dp)
//                                    )
                                    }
                                }
                                item{
                                    Text(
                                        text = annotatedString.toAnnotatedString(),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .align(Alignment.BottomCenter)
                                            .padding(vertical = 16.dp)
                                            .clickable(onClick = {}),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    //}
}

//@Composable
//fun LoginPage() {
//    val imageBitmap: ImageBitmap = ImageBitmap.imageResource(R.drawable.head_god)
//    //val delectedIcon: ImageBitmap = ImageBitmap.imageResource(R.drawable.eye_hide)
//    Box(contentAlignment = Alignment.Center) {
//        Image(
//            bitmap = imageBitmap,
//            contentDescription = "",
//            contentScale= ContentScale.FillWidth,
//            modifier = Modifier.fillMaxWidth().height(280.dp).clip(QureytoImageShapes(160f))
//        )
//        //Image(bitmap = delectedIcon, contentDescription = "")
//    }
//}

@Stable
class QureytoImageShapes(var hudu: Float = 100f) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path()
        path.moveTo(0f, 0f)
        path.lineTo(0f, size.height-hudu)
        path.quadraticBezierTo(size.width/2f, size.height, size.width, size.height-hudu)
        path.lineTo(size.width,0f)
        path.close()
        return Outline.Generic(path)
    }
}

@Preview(name = "login")
@Composable
fun LoginPage() {
    val imageBitmap: ImageBitmap = ImageBitmap.imageResource(R.drawable.head)
    val delectedIcon: ImageBitmap = ImageBitmap.imageResource(R.drawable.logotest)
    Box(contentAlignment = Alignment.Center) {
        Image(
            bitmap = imageBitmap,
            contentDescription = "",
            contentScale=ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth().height(230.dp).clip(QureytoImageShapes(160f))
        )
        Box(
            contentAlignment=Alignment.Center,
            modifier = Modifier
                .padding(0.dp)
                .clip(CircleShape)
                .background(Color(206, 236, 250,121))
                .width(130.dp)
                .height(130.dp)
        ){
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