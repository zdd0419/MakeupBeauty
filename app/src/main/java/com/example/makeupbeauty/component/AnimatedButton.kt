package com.example.makeupbeauty.component

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class ButtonState{
    Normal, Pressed
}

@Composable
fun AnimatedButton(btnText: String, emailText: MutableState<String>, passwordText: MutableState<String>){
    val buttonState = remember {
        mutableStateOf(ButtonState.Normal)
    }
    
    val transition = updateTransition(targetState = buttonState, label = "ButtonTransition")

    val duration = 600

    val buttonBackgroundColor: Color by transition.animateColor(
        transitionSpec = { tween(duration)},
        label = "Button Background Color"
    ) { it ->
        when(it.value){
            ButtonState.Normal-> Color.Blue
            ButtonState.Pressed-> Color.Gray
        }
    }

    val buttonWidth: Dp by transition.animateDp(
        transitionSpec = { tween(duration)},
        label = "Button Width"
    ) { it ->
        when(it.value){
            ButtonState.Normal -> 350.dp
            ButtonState.Pressed -> 60.dp
        }
    }

    val buttonShape: Dp by transition.animateDp(
        transitionSpec = { tween(duration)},
        label = "Button Shape"
    ) { it ->
        when(it.value){
            ButtonState.Normal -> 4.dp
            ButtonState.Pressed -> 100.dp
        }
    }

    Button(
        modifier = Modifier
            .width(buttonWidth)
            .height(46.dp),
        shape = RoundedCornerShape(buttonShape),
        enabled = emailText.value.isNotBlank() && passwordText.value.isNotBlank(),
        onClick = {
            buttonState.value = if (buttonState.value == ButtonState.Normal){
                ButtonState.Pressed
            } else{
                ButtonState.Normal
            }
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = buttonBackgroundColor,
            disabledBackgroundColor = Color.Blue.copy(0.5f)
        )
    ){
        if(buttonState.value == ButtonState.Normal){
            Text(text = btnText, color = Color.White)
        }else{
            CircularProgressIndicator(
                color = Color.White,
                strokeWidth = 2.dp,
                modifier = Modifier.size(24.dp, 24.dp)
            )
        }
    }
}