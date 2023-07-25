package com.ngtuankhanh.android.coffeehouse.feature.home.homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.testing.TestNavHostController
import com.ngtuankhanh.android.coffeehouse.R
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme
import com.ngtuankhanh.android.coffeehouse.ui.theme.typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavHostController) {
    val numLoyalty = rememberSaveable { mutableStateOf(4) }
    Scaffold() { contentPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            Column() {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 24.dp,
                            bottom = 16.dp, start = 24.dp, end = 24.dp
                        )
                ) {
                    Column() {
                        Text(
                            "Good morning",
                            style = typography.titleSmall,
                            color = Color(0xFFD8D8D8)
                        )
                        Text(
                            "Anderson",
                            style = typography.titleMedium,
                            color = Color(0xFF001833)
                        )
                    }
                    Row() {
                        IconButton(onClick = {
                            navController.navigate("my_cart")
                        }) {
                            Icon(
                                painterResource(id = R.drawable.buy),
                                contentDescription = null,
                                tint = Color(0xFF001833)
                            )
                        }
                        IconButton(onClick = {
                            navController.navigate("profile")
                        }) {
                            Icon(
                                painterResource(id = R.drawable.profile),
                                contentDescription = null,
                                tint = Color(0xFF001833)
                            )
                        }
                    }
                }
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFF324A59),
                    modifier = Modifier.padding(start = 24.dp, end = 24.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                            .background(color = Color.Transparent)
                            .padding(16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp)
                        ) {
                            Text(
                                text = "Loyalty card",
                                style = typography.titleSmall,
                                color = Color(0xFFD8D8D8)
                            )
                            Text(
                                text = "${numLoyalty.value} / 8",
                                style = typography.titleSmall,
                                color = Color(0xFFD8D8D8)
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .clip(shape = RoundedCornerShape(12.dp))
                                .background(Color(0xFFFFFFFF))
                                .padding(top = 12.dp)
                        ) {
                            (1..8).forEach { index ->
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxWidth()
                                ) {
                                    Image(
                                        painterResource(id = R.drawable.coffeecup),
                                        contentDescription = null,
                                        colorFilter = if (index > numLoyalty.value) ColorFilter.tint(
                                            Color(0xFFD8D8D8)
                                        ) else null
                                    )
                                }
                            }
                        }
                    }
                }
                Surface(
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                    color = Color(0xFF324A59),
                    modifier = Modifier.padding(top = 32.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(24.dp),
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxSize()
                            .background(color = Color.Transparent)
                    ) {
                        Text(
                            text = "Choose your coffee",
                            style = typography.titleMedium,
                            color = Color(0xFFD8D8D8)
                        )
                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxSize()
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(16.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                            ) {
                                CoffeeGridItem(
                                    id = R.drawable.americano,
                                    name = "Americano",
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable(onClick = {
                                            navController.navigate("details")
                                        })
                                )
                                CoffeeGridItem(
                                    id = R.drawable.cappuccino,
                                    name = "Cappuccino",
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable(onClick = {
                                            navController.navigate("details")
                                        })
                                )
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(16.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                            ) {
                                CoffeeGridItem(
                                    id = R.drawable.mocha,
                                    name = "Mocha",
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable(onClick = {
                                            navController.navigate("details")
                                        })
                                )
                                CoffeeGridItem(
                                    id = R.drawable.flatwhite,
                                    name = "Flat White",
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable(onClick = {
                                            navController.navigate("details")
                                        })
                                )
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp)
                                .clip(shape = RoundedCornerShape(20.dp))
                                .background(Color(0xFFFFFFFF))
                        ) {
                            IconButton(onClick = {}) {
                                Icon(
                                    painterResource(id = R.drawable.shop),
                                    contentDescription = null,
                                    tint = Color(0xFF324A59)
                                )
                            }
                            IconButton(onClick = {}) {
                                Icon(
                                    painterResource(id = R.drawable.gift),
                                    contentDescription = null,
                                    tint = Color(0xFFD8D8D8)
                                )
                            }
                            IconButton(onClick = {}) {
                                Icon(
                                    painterResource(id = R.drawable.bill),
                                    contentDescription = null,
                                    tint = Color(0xFFD8D8D8)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomePagePreview() {
    CoffeeHouseTheme {
        HomePage(navController = TestNavHostController(LocalContext.current))
    }
}