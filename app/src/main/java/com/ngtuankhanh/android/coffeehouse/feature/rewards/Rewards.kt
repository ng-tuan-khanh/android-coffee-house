package com.ngtuankhanh.android.coffeehouse.feature.rewards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun Rewards(navController: NavHostController, viewModel: CommonViewModel = viewModel()) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Rewards",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFF001833)
                    )
                }
            )
        }
    ) { contentPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 24.dp, start = 24.dp, end = 24.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    val rewardPoints = viewModel.rewardPoints.observeAsState()
                    val loyaltyCardCounter = viewModel.loyaltyCardCounter.observeAsState()
                    LoyaltyCard(numLoyalty = loyaltyCardCounter.value ?: 0)
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFF324A59),
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(24.dp)
                                .fillMaxWidth()
                        ) {
                            Column() {
                                Text(
                                    text = "My Points: ",
                                    style = MaterialTheme.typography.titleSmall,
                                    color = Color(0xFFD8D8D8)
                                )
                                Text(
                                    text = "${rewardPoints?.value ?: 0}",
                                    style = MaterialTheme.typography.titleMedium.merge(
                                        TextStyle(
                                            fontSize = 24.sp
                                        )
                                    ),
                                    color = Color(0xFFD8D8D8)
                                )
                            }
                            Surface(
                                shape = RoundedCornerShape(5.dp),
                                color = Color(0x30A2CDE9),
                                onClick = {
                                    navController.navigate("redeem")
                                }
                            ) {
                                Text(
                                    text = "Redeem drinks",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color(0xFFD8D8D8),
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        }
                    }
                }
                Text(
                    text = "History Rewards",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color(0xFF324A59),
                    modifier = Modifier.padding(top = 24.dp)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = 16.dp)
                ) {
                    val historyRewards = viewModel.historyRewards.observeAsState()
                    LazyColumn() {
                        items(historyRewards.value?.size ?: 0) { index ->
                            val historyReward = historyRewards.value?.get(index)
                            historyReward?.let {
                                HistoryRewardsItem(
                                    coffeeName = it.coffeeName,
                                    points = it.points
                                )
                            }
                        }
                    }
                }
                BottomNavigationBar(
                    page = BottomNavigationItem.Rewards,
                    navController = navController
                )
            }
        }
    }
}

@Preview
@Composable
fun RewardsPreview() {
    CoffeeHouseTheme() {
        Rewards(navController = TestNavHostController(LocalContext.current))
    }
}