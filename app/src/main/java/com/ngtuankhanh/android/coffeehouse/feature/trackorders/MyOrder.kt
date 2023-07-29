package com.ngtuankhanh.android.coffeehouse.feature.trackorders

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.testing.TestNavHostController
import com.ngtuankhanh.android.coffeehouse.feature.common.BottomNavigationBar
import com.ngtuankhanh.android.coffeehouse.feature.common.BottomNavigationItem
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MyOrder(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "My Order",
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
                val pagerState = rememberPagerState()
                HorizontalPager(
                    pageCount = 2,
                    state = pagerState,
                    pageSpacing = 24.dp,
                    modifier = Modifier.weight(1f)
                ) { page ->
                    val textColor = if (page == 0) {
                        Color(0xFF324A59)
                    } else {
                        Color(0x80324A59)
                    }
                    Column() {
                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .weight(1f)
                                    .height(IntrinsicSize.Min)
                                    .padding(horizontal = 24.dp)
                            ) {
                                Text(
                                    text = "On going",
                                    style = MaterialTheme.typography.titleSmall,
                                    color = if (page == 0) {
                                        Color(0xFF001833)
                                    } else {
                                        Color(0x80001833)
                                    },
                                    maxLines = 1,
                                    overflow = TextOverflow.Visible,
                                    modifier = Modifier.padding(bottom = 16.dp)
                                )
                                if (page == 0) {
                                    Divider(
                                        color = Color(0xFF001833), modifier = Modifier
                                            .height(2.dp)
                                    )
                                }
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .weight(1f)
                                    .height(IntrinsicSize.Min)
                                    .padding(horizontal = 24.dp)
                            ) {
                                Text(
                                    text = "History",
                                    style = MaterialTheme.typography.titleSmall,
                                    color = if (page == 1) {
                                        Color(0xFF001833)
                                    } else {
                                        Color(0x80001833)
                                    },
                                    maxLines = 1,
                                    overflow = TextOverflow.Visible,
                                    modifier = Modifier.padding(bottom = 16.dp)
                                )
                                if (page == 1) {
                                    Divider(
                                        color = Color(0xFF001833), modifier = Modifier
                                            .height(2.dp)
                                    )
                                }
                            }
                        }
                        Divider(
                            color = Color(0xFFD8D8D8), modifier = Modifier
                                .height(2.dp)
                                .fillMaxWidth()
                        )

                        Box(
                            modifier = Modifier
                                .padding(top = 32.dp, bottom = 16.dp)
                        ) {
                            LazyColumn(
                                verticalArrangement = Arrangement.spacedBy(24.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                items(10) {
                                    MyOrderItem(
                                        textColor = textColor
                                    )
                                }
                            }
                        }
                    }
                }
                BottomNavigationBar(
                    page = BottomNavigationItem.MyOrder,
                    navController = navController
                )
            }
        }
    }
}

@Preview
@Composable
fun MyOrderPreview() {
    CoffeeHouseTheme() {
        MyOrder(navController = TestNavHostController(LocalContext.current))
    }
}