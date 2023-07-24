package com.ngtuankhanh.android.coffeehouse.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngtuankhanh.android.coffeehouse.R
import com.ngtuankhanh.android.coffeehouse.feature.home.details.AmountOption
import com.ngtuankhanh.android.coffeehouse.feature.home.details.HotColdOption
import com.ngtuankhanh.android.coffeehouse.feature.home.details.IceOption
import com.ngtuankhanh.android.coffeehouse.feature.home.details.ShotOption
import com.ngtuankhanh.android.coffeehouse.feature.home.details.SizeOption
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCart() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "My Cart") },
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
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {
            Column() {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.Gray))
                Spacer(modifier = Modifier.height(50.dp))
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.Gray))
                Spacer(modifier = Modifier.height(50.dp))
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.Gray))
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Text(text = "Total Price")
                    Text(text = "$3.00")
                }
                Button(
                    onClick = {}, modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Text(text = "Add to cart")
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