package com.example.makeupbeauty.ui.Screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Grade
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.makeupbeauty.ui.theme.MakeupBeautyTheme

//class Evaluate : ComponentActivity(){
//    companion object{
//        fun newIntent(context: Context) =
//            Intent(context, Evaluate::class.java).apply { putExtra("Evaluate",true) }
//    }
//    override fun onCreate(savedInstanceState: Bundle?){
//        super.onCreate(savedInstanceState)
//        setContent{
//            MakeupBeautyTheme{
//                Surface(color = MaterialTheme.colors.background){
//                    ShowDialog()
//                }
//            }
//        }
//
//    }
//
//}

@Composable
fun ShowDialog(
    alertDialog: MutableState<Boolean>,
//    title: String,
//    content: String,
//    cancelString: String,
//    confirmString: String,
//    onConfirmListener: () -> Unit
) {
    if (!alertDialog.value) return
    val buttonHeight = 45.dp
    Dialog(onDismissRequest = {
        alertDialog.value = false
    }) {
        Card(shape = RoundedCornerShape(10.dp)) {
            val emailText = remember{
                mutableStateOf("")
            }
            var hasError by remember { mutableStateOf(false) }
            val emailInteractionState = remember { MutableInteractionSource() }
            val checkedState = remember { mutableStateOf(0) }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Row() {
                    Text(text = "描述相符", fontSize = 20.sp)
                }

                // 五颗星星
                Row() {
                    Row() {
                        IconToggleButton(
                            checked = (checkedState.value >= 1),
                            onCheckedChange = {
                                checkedState.value = 1
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Grade,
                                contentDescription = "Favorite",
                                tint = if (checkedState.value >= 1) {
                                    Color.Yellow
                                } else {
                                    Color.Gray
                                }
                            )
                        }
                        IconToggleButton(
                            checked = (checkedState.value >= 2),
                            onCheckedChange = {
                                checkedState.value = 2
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Grade,
                                contentDescription = "Favorite",
                                tint = if (checkedState.value >= 2) {
                                    Color.Yellow
                                } else {
                                    Color.Gray
                                }
                            )
                        }
                        IconToggleButton(
                            checked = (checkedState.value >= 3),
                            onCheckedChange = {
                                checkedState.value = 3
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Grade,
                                contentDescription = "Favorite",
                                tint = if (checkedState.value >= 3) {
                                    Color.Yellow
                                } else {
                                    Color.Gray
                                }
                            )
                        }
                        IconToggleButton(
                            checked = (checkedState.value >= 4),
                            onCheckedChange = {
                                checkedState.value = 4
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Grade,
                                contentDescription = "Favorite",
                                tint = if (checkedState.value >= 4) {
                                    Color.Yellow
                                } else {
                                    Color.Gray
                                }
                            )
                        }
                        IconToggleButton(
                            checked = (checkedState.value >= 5),
                            onCheckedChange = {
                                checkedState.value = 5
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = "Favorite",
                                tint = if (checkedState.value >= 5) {
                                    Color.Yellow
                                } else {
                                    Color.Gray
                                }
                            )
                        }
                    }
                }
                
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Spacer(modifier = Modifier.width(4.dp))
                    OutlinedTextField(
                        value = emailText.value,
//                    leadingIcon = {
//                        Icon(
//                            Icons.Default.Email,
//                            contentDescription = "",
//                            tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
//                        )
////                                        FaIcon(
////                                            faIcon = FaIcons.Envelope,
////                                            tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
////                                        )
//                    },
                        //trailingIcon = { Icon(Icons.Default.Email, contentDescription = "")},
                        maxLines = 5,
                        isError = hasError,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        label = { Text(text = "输入评价…") },
                        placeholder = { Text(text = "输入评价…") },
                        onValueChange = {
                            emailText.value = it
                        },
                        interactionSource = emailInteractionState,
                    )
                }


                Row {
                    TextButton(
                        modifier = Modifier
                            .weight(1f)
                            .height(buttonHeight),
                        onClick = {
                            alertDialog.value = false
                        }
                    ) {
                        Text(text = "确认发布", fontSize = 15.sp)
                    }
                }

                Row() {
                    Text(
                        text = "跳过，不评价",
                        Modifier
                            .height(10.dp)
                            .clickable { },
                        Color.Gray,
                        fontSize = 7.sp)
                }

                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}