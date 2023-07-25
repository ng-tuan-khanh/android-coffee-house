package com.ngtuankhanh.android.coffeehouse.feature.home.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ngtuankhanh.android.coffeehouse.R
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme
import com.ngtuankhanh.android.coffeehouse.ui.theme.poppinsFamily
import com.ngtuankhanh.android.coffeehouse.ui.theme.typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Details(coffeeName: String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Details",
                            style = typography.titleMedium,
                            color = Color(0xFF001833)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = Color(0xFF001833)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painterResource(id = R.drawable.buy),
                            contentDescription = null,
                            tint = Color(0xFF001833)
                        )
                    }
                })
        },
        modifier = Modifier.padding(24.dp)
    ) { contentPadding ->
        Surface(modifier = Modifier.padding(contentPadding)) {

            val counter = rememberSaveable { mutableStateOf(1) }
            val shotOption = rememberSaveable { mutableStateOf(ShotOptions.SINGLE) }
            val selectOption = rememberSaveable { mutableStateOf(SelectOptions.STANDARD) }
            val sizeOption = rememberSaveable { mutableStateOf(SizeOptions.SMALL) }
            val iceOption = rememberSaveable { mutableStateOf(IceOptions.ICE1) }

            // TODO: Fix totalAmount render problem
            /*val totalAmount = rememberSaveable(counter, shotOption, sizeOption) {
                derivedStateOf {
                    val shot = when (shotOption.value) {
                        ShotOptions.SINGLE -> 1f
                        ShotOptions.DOUBLE -> 2f
                    }
                    val size = when (sizeOption.value) {
                        SizeOptions.SMALL -> 1f
                        SizeOptions.MEDIUM -> 1.5f
                        SizeOptions.BIG -> 2f
                    }
                    (size + shot) * counter.value
                }
            }*/
            val totalAmount = rememberSaveable { mutableStateOf(0f) }

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
                    .fillMaxSize()
            ) {
                Column() {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    ) {
                        Image(
                            painterResource(id = R.drawable.americano),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    AmountOption(name = coffeeName, counter = counter)
                    ShotOption(shotOption = shotOption)
                    SelectOption(selectOption = selectOption)
                    SizeOption(sizeOption = sizeOption)
                    IceOption(iceOption = iceOption)
                }
                Column() {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp)
                    ) {
                        Text(
                            text = "Total Amount",
                            fontFamily = poppinsFamily,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 0.sp,
                            color = Color(0xFF001833)
                        )
                        Text(
                            text = "$${totalAmount.value}",
                            fontFamily = poppinsFamily,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 0.sp,
                            color = Color(0xFF001833)
                        )
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(30.dp))
                            .fillMaxWidth()
                            .clickable(onClick = {

                            })
                            .background(Color(0xFF324A59))
                            .padding(12.dp)
                    ) {
                        Text(
                            text = "Add to cart",
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
        Details("Americano")
    }
}