package com.example.makeupbeauty

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeupbeauty.Search.SearchActivity

val searchText = mutableStateOf("")

@Composable
fun DefaultTopbar() {
    val context = LocalContext.current;
    TopAppBar(
        content = {
            IconButton(
                modifier = Modifier.padding(start = 8.dp),
                onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_account_circle_24),
                    tint = MaterialTheme.colors.primary,
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Surface(modifier = Modifier
                .padding(end = 10.dp)
                .weight(1f)
                .clickable { context.startActivity(SearchActivity.newIntent(context)) })
            {
                SearchSection()
            }
        },
        backgroundColor = MaterialTheme.colors.background
    )

}

@Composable
fun SearchSection() {
    val context = LocalContext.current;
    TextField(
        value = searchText.value,
        onValueChange = {
            searchText.value = it
        },
        placeholder = {
            Text(text = "Search here...", color = Color(0xFF666666), fontSize = 15.sp)
        },
        modifier = Modifier
            .height(48.dp)
            .background(Color(0xFFD0D0D0), shape = CircleShape),
        shape = CircleShape,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(245,245,245),
            cursorColor = Color.Black,
            disabledLabelColor = Color(0xFFDDDDDD),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        textStyle = TextStyle(fontSize = 15.sp),
        singleLine = true,
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_search_24),
                contentDescription = null,
                tint = MaterialTheme.colors.primary,
                modifier = Modifier.clickable { context.startActivity(SearchActivity.newIntent(context)) }
            )
        },
    )
}

@Preview(showBackground = true)
@Composable fun PreviewDefaultTopbar() {
    DefaultTopbar()
}