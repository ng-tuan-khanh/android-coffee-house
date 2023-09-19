package com.ngtuankhanh.android.coffeehouse.feature.home.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.testing.TestNavHostController
import com.ngtuankhanh.android.coffeehouse.R
import com.ngtuankhanh.android.coffeehouse.feature.common.BottomNavigationBar
import com.ngtuankhanh.android.coffeehouse.feature.common.BottomNavigationItem
import com.ngtuankhanh.android.coffeehouse.feature.common.CommonViewModel
import com.ngtuankhanh.android.coffeehouse.feature.common.LoyaltyCard
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavHostController, viewModel: CommonViewModel = viewModel()) {
    Scaffold() { contentPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            Column {
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
                            style = MaterialTheme.typography.titleSmall,
                            color = Color(0xFFD8D8D8)
                        )
                        Text(
                            "Anderson",
                            style = MaterialTheme.typography.titleMedium,
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
                val loyaltyCardCounter = viewModel.loyaltyCardCounter.observeAsState()
                LoyaltyCard(
                    numLoyalty = loyaltyCardCounter?.value ?: 0,
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp)
                        .clickable(onClick = {
                            viewModel.resetLoyaltyCardCounter()
                        })
                )
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
                            style = MaterialTheme.typography.titleMedium,
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
                                    imageId = R.drawable.americano,
                                    coffeeName = "Americano",
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable(onClick = {
                                            navController.navigate("details/${R.drawable.americano}/Americano")
                                        })
                                )
                                CoffeeGridItem(
                                    imageId = R.drawable.cappuccino,
                                    coffeeName = "Cappuccino",
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable(onClick = {
                                            navController.navigate("details/${R.drawable.cappuccino}/Cappuccino")
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
                                    imageId = R.drawable.mocha,
                                    coffeeName = "Mocha",
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable(onClick = {
                                            navController.navigate("details/${R.drawable.mocha}/Mocha")
                                        })
                                )
                                CoffeeGridItem(
                                    imageId = R.drawable.flat_white,
                                    coffeeName = "Flat White",
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable(onClick = {
                                            navController.navigate("details/${R.drawable.flat_white}/Flat White")
                                        })
                                )
                            }
                        }
                        BottomNavigationBar(
                            page = BottomNavigationItem.Home,
                            navController = navController
                        )
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