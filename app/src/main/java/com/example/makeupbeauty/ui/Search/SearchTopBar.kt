package com.example.makeupbeauty.Search

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.example.makeupbeauty.SearchSection
import com.example.makeupbeauty.R
import com.example.makeupbeauty.searchText
import com.example.makeupbeauty.viewModel.PostViewModel

val searchTextInside = mutableStateOf("")


@Composable
fun SearchTopBar(onClick:()->Unit = {}, navController: NavController) {
    TopAppBar(
        title = {
            Surface(modifier = Modifier) {

                Row() {
                    SearchTextField()
                    SearchButton(navController)
                }


            }
        },
        navigationIcon = {
            IconButton(onClick = { onClick }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        },
        backgroundColor = MaterialTheme.colors.background
    )
}


@Composable
fun SearchButton(navController: NavController) {
    val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
    Box(modifier = Modifier.fillMaxWidth()){
        OutlinedButton(
            onClick = {
                postViewModel.searchtext = searchTextInside.value
                searchTextInside.value = ""
                navController.navigate("result")
                      },
            shape = RoundedCornerShape(50),
            border = BorderStroke(1.dp, Color.Red),
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = Color.Transparent,
                contentColor = Color.Red
            ),
            modifier = Modifier
                .width(80.dp)
                .align(Alignment.Center)
                .height(45.dp)
                .clickable {

                    navController.navigate("result")
                }
        ){
            Text(
                text = "??????",
                fontSize = 12.sp)
        }
    }
}


@Composable
fun SearchTextField() {
    TextField(
        value = searchTextInside.value,
        onValueChange = {
            searchTextInside.value = it
        },
        placeholder = {
            Text(text = "Search here...", color = Color(0xFF666666), fontSize = 15.sp)
        },
        modifier = Modifier
            .height(48.dp)
            .width(220.dp)
            .background(Color(0xFFD0D0D0), shape = CircleShape),
        shape = CircleShape,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFFDDDDDD),
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
                tint = Color(0xFFec8aa4)
            )
        }
    )
}


@Preview(showBackground = true)
@Composable
fun previewSearch() {
    SearchTopBar(navController = rememberNavController())
}