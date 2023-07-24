package com.ngtuankhanh.android.coffeehouse.feature.home.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngtuankhanh.android.coffeehouse.R
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Details() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Details") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.ArrowBack, contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painterResource(id = R.drawable.buy), contentDescription = null
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
                Image(
                    painterResource(id = R.drawable.americano),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
                AmountOption(name = "Americano")
                ShotOption()
                HotColdOption()
                SizeOption()
                IceOption()
            }
            Column() {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Total Amount")
                    Text(text = "$3.00")
                }
                Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
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
        Details()
    }
}