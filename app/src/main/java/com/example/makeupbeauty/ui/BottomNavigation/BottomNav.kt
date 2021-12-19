package com.example.makeupbeauty.BottomNavigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.makeupbeauty.ui.Screens.*

//底部导航
@ExperimentalAnimationApi
@Composable
fun BottomNavigation(
    navController: NavController
) {
    val items = NavigationItem.Items.list
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if(currentRoute == "PostActivity")
        return ;

    Row(
        modifier= Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement =Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ){
        items.forEach{
            item->
            BottomNavigationItem(item = item, isSelected = currentRoute == item.id,
            onClick =  {
                navController.navigate(item.id) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
            })
        }
    }
}



@ExperimentalAnimationApi
@Composable
fun BottomNavigationItem(item: NavigationItem, isSelected:Boolean, onClick:()->Unit){
    val background=if(isSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
    val contentColor=if(isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground

    Box(modifier= Modifier
        .clip(CircleShape)
        .clickable(onClick = onClick)){
        Row(
          modifier=Modifier.padding(12.dp),
              verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ){
            Icon(imageVector = item.icon, contentDescription = null,tint=contentColor
            )
            AnimatedVisibility(visible = isSelected) {
                Text(text=item.title,
                    color=contentColor
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
@Preview
fun prev2(){
BottomNavigationItem(item = NavigationItem.Home, isSelected = true) {

}}
