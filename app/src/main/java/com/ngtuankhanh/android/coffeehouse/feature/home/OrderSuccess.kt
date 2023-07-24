package com.ngtuankhanh.android.coffeehouse.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngtuankhanh.android.coffeehouse.R
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme

@Composable
fun OrderSuccess() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.takeaway), contentDescription = null)
        }
        Text("Order Success")
        Text("Your order has been placed successfully")
        Text("For more details, go to my orders")
        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text("Track My Order")
        }
    }
}

@Preview
@Composable
fun OrderSuccessPreview() {
    CoffeeHouseTheme {
        OrderSuccess()
    }
}