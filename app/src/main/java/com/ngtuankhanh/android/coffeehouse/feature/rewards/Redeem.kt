package com.ngtuankhanh.android.coffeehouse.feature.rewards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.testing.TestNavHostController
import com.ngtuankhanh.android.coffeehouse.R
import com.ngtuankhanh.android.coffeehouse.feature.common.CommonViewModel
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Redeem(navController: NavHostController, viewModel: CommonViewModel = viewModel()) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Redeem",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFF001833)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = Color(0xFF001833)
                        )
                    }
                })
        }
    ) { contentPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 24.dp, start = 24.dp, end = 24.dp)
            ) {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(32.dp)) {
                    item {
                        RedeemItem(
                            imageId = R.drawable.americano,
                            coffeeName = "Americano",
                            points = 1350,
                            onClick = {
                                if (viewModel.rewardPoints.value!! > 1350) {
                                    viewModel.rewardPointsUsed.value = 1350
                                    navController.navigate("details/${R.drawable.americano}/Americano?discount=${4.99f}")
                                }
                            }
                        )
                    }
                    item {
                        RedeemItem(
                            imageId = R.drawable.cappuccino,
                            coffeeName = "Cappuccino",
                            points = 1500,
                            onClick = {
                                if (viewModel.rewardPoints.value!! > 1500) {
                                    viewModel.rewardPointsUsed.value = 1500
                                    navController.navigate("details/${R.drawable.cappuccino}/Cappuccino?discount=${4.99f}")
                                }
                            }
                        )
                    }
                    item {
                        RedeemItem(
                            imageId = R.drawable.mocha,
                            coffeeName = "Mocha",
                            points = 1600,
                            onClick = {
                                if (viewModel.rewardPoints.value!! > 1600) {
                                    viewModel.rewardPointsUsed.value = 1600
                                    navController.navigate("details/${R.drawable.mocha}/Mocha?discount=${4.99f}")
                                }
                            }
                        )
                    }
                    item {
                        RedeemItem(
                            imageId = R.drawable.flat_white,
                            coffeeName = "Flat White",
                            points = 1450,
                            onClick = {
                                if (viewModel.rewardPoints.value!! > 1450) {
                                    viewModel.rewardPointsUsed.value = 1450
                                    navController.navigate("details/${R.drawable.flat_white}/Flat White?discount=${4.99f}")
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun RedeemPreview() {
    CoffeeHouseTheme() {
        Redeem(navController = TestNavHostController(LocalContext.current))
    }
}