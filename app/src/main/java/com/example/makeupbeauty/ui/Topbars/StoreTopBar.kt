package com.example.makeupbeauty

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
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
import androidx.core.content.ContextCompat.startActivity
import com.example.makeupbeauty.commodityDetail.productDetailActivity
import com.example.makeupbeauty.commodityDetail.shoppingCarActivity
import com.example.makeupbeauty.ui.CustomerService.CustomerServiceActivity

@Composable
fun StoreTopbar() {
    TopAppBar(
        content = {
            val context = LocalContext.current;
            IconButton(
                modifier = Modifier.padding(start = 8.dp),
                onClick = { }) {
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
            Surface(modifier = Modifier.weight(1f)) {
                SearchSection()
            }
            Spacer(modifier = Modifier.width(12.dp))
            IconButton(
                modifier = Modifier.padding(start = 16.dp, end = 2.dp),
                onClick = { context.startActivity(shoppingCarActivity.newIntent(context))}) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    tint = MaterialTheme.colors.primary,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                )
            }
            IconButton(
                modifier = Modifier.padding(start = 2.dp, end = 8.dp),
                onClick = { context.startActivity(CustomerServiceActivity.newIntent(context))}) {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_connect_without_contact_24),
                    tint = MaterialTheme.colors.primary,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                )
            }
        },
        backgroundColor = MaterialTheme.colors.background
    )

}
@Preview(showBackground = true)
@Composable fun PreviewStoreTopbar() {
    StoreTopbar()
}