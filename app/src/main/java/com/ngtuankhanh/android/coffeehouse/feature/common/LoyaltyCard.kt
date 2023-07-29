package com.ngtuankhanh.android.coffeehouse.feature.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngtuankhanh.android.coffeehouse.R
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme

@Composable
fun LoyaltyCard(modifier: Modifier = Modifier) {
    val numLoyalty = rememberSaveable { mutableStateOf(4) }
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF324A59),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .background(color = Color.Transparent)
                .padding(24.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            ) {
                Text(
                    text = "Loyalty card",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color(0xFFD8D8D8)
                )
                Text(
                    text = "${numLoyalty.value} / 8",
                    style = MaterialTheme.typography.titleSmall,
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
}

@Preview
@Composable
fun LoyaltyCardPreview() {
    CoffeeHouseTheme {
        LoyaltyCard()
    }
}