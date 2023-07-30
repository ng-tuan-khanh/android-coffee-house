package com.ngtuankhanh.android.coffeehouse.feature.home.details

import androidx.annotation.DrawableRes
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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.testing.TestNavHostController
import com.ngtuankhanh.android.coffeehouse.R
import com.ngtuankhanh.android.coffeehouse.feature.common.CommonViewModel
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ngtuankhanh.android.coffeehouse.feature.common.MyCartItem
import com.ngtuankhanh.android.coffeehouse.ui.theme.typography
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Details(
    @DrawableRes imageId: Int,
    coffeeName: String,
    navController: NavHostController,
    discount: Float,
    viewModel: CommonViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Details",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFF001833),
                        textAlign = TextAlign.Center
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
                },
                actions = {
                    IconButton(onClick = {
                        navController.navigate("my_cart") {
                            popUpTo(navController.graph.startDestinationId)
                        }
                    }) {
                        Icon(
                            painterResource(id = R.drawable.buy),
                            contentDescription = null,
                            tint = Color(0xFF001833)
                        )
                    }
                })
        }
    ) { contentPadding ->
        Surface(modifier = Modifier.padding(contentPadding)) {

            val counter = rememberSaveable { mutableStateOf(1) }
            val shotOption = rememberSaveable { mutableStateOf(ShotOptions.SINGLE) }
            val selectOption = rememberSaveable { mutableStateOf(HotColdOptions.HOT) }
            val sizeOption = rememberSaveable { mutableStateOf(SizeOptions.SMALL) }
            val iceOption = rememberSaveable { mutableStateOf(IceOptions.LESS_ICE) }
            val totalAmount = rememberSaveable(counter.value, shotOption.value, sizeOption.value) {
                counter.value * (when (shotOption.value) {
                    ShotOptions.SINGLE -> 1f
                    ShotOptions.DOUBLE -> 2f
                } * when (sizeOption.value) {
                    SizeOptions.SMALL -> 1f
                    SizeOptions.MEDIUM -> 1.5f
                    SizeOptions.BIG -> 2f
                } * 5.0f)
            }

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 24.dp, start = 24.dp, end = 24.dp)
            ) {
                Column() {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    ) {
                        Image(
                            painterResource(id = imageId),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    AmountOption(name = coffeeName, counter = counter)
                    ShotOption(shotOption = shotOption)
                    HotColdOption(selectOption = selectOption)
                    SizeOption(sizeOption = sizeOption)
                    IceOption(iceOption = iceOption)
                }
                Column() {
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "- $${discount}",
                            style = typography.titleLarge.merge(TextStyle(fontSize = 16.sp)),
                            color = Color(0xFFA83E32)
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp)
                    ) {
                        Text(
                            text = "Total Amount",
                            style = typography.titleLarge.merge(TextStyle(fontSize = 16.sp)),
                            color = Color(0xFF001833)
                        )
                        Text(
                            text = "$${totalAmount}",
                            style = typography.titleLarge.merge(TextStyle(fontSize = 16.sp)),
                            color = Color(0xFF001833)
                        )
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(30.dp))
                            .fillMaxWidth()
                            .clickable(onClick = {
                                navController.navigate("my_cart") {
                                    popUpTo(navController.graph.startDestinationId)
                                }
                                viewModel.addMyCartItem(
                                    MyCartItem(
                                        imageId = imageId,
                                        coffeeName = coffeeName,
                                        counter = counter.value,
                                        shotOption = when (shotOption.value) {
                                            ShotOptions.SINGLE -> "Single"
                                            ShotOptions.DOUBLE -> "Double"
                                        },
                                        selectOption = when (selectOption.value) {
                                            HotColdOptions.HOT -> "Hot"
                                            HotColdOptions.COLD -> "Cold"
                                        },
                                        sizeOption = when (sizeOption.value) {
                                            SizeOptions.SMALL -> "Small"
                                            SizeOptions.MEDIUM -> "Medium"
                                            SizeOptions.BIG -> "Big"
                                        },
                                        iceOption = when (iceOption.value) {
                                            IceOptions.LESS_ICE -> "Less ice"
                                            IceOptions.ICE -> "Ice"
                                            IceOptions.FULL_ICE -> "Full ice"
                                        },
                                        totalAmount = ((totalAmount - discount) * 100.0f).roundToInt() / 100.0f
                                    )
                                )
                                if (discount > 0f) {
                                    viewModel.reduceRewardPointsUsed()
                                }
                            })
                            .background(Color(0xFF324A59))
                            .padding(12.dp)
                    ) {
                        Text(
                            text = "Add to cart",
                            style = MaterialTheme.typography.titleSmall,
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
        Details(
            imageId = R.drawable.americano,
            coffeeName = "Americano",
            discount = 0f,
            navController = TestNavHostController(LocalContext.current)
        )
    }
}