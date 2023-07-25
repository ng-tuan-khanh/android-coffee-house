package com.ngtuankhanh.android.coffeehouse.feature.home.mycart

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ngtuankhanh.android.coffeehouse.R
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme
import com.ngtuankhanh.android.coffeehouse.ui.theme.typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCart() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {

                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.ArrowBack, contentDescription = null
                        )
                    }
                })
        },
        modifier = Modifier.padding(24.dp)
    ) { contentPadding ->
        Surface(modifier = Modifier.padding(contentPadding)) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 24.dp, start = 24.dp, end = 24.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = "My Cart",
                    style = typography.titleMedium.merge(TextStyle(fontSize = 20.sp)),
                    color = Color(0xFF001833),
                    modifier = Modifier.padding(bottom = 24.dp)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        items(5) {
                            MyCartListItem(id = R.drawable.americano)
                        }
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Total Price",
                            style = typography.titleSmall,
                            color = Color(0x38001833)
                        )
                        Text(
                            text = "$3.00",
                            style = typography.titleLarge,
                            color = Color(0xFF001833)
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,

                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(30.dp))
                            .weight(1f)
                            .fillMaxWidth()
                            .clickable(onClick = {

                            })
                            .background(Color(0xFF324A59))
                            .padding(12.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.buy),
                            contentDescription = null,
                            tint = Color(0xFFFFFFFF)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Checkout",
                            style = typography.titleSmall,
                            color = Color(0xFFFFFFFF)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DetailsPreview() {
    CoffeeHouseTheme() {
        MyCart()
    }
}