package com.ngtuankhanh.android.coffeehouse.feature.home.homepage

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngtuankhanh.android.coffeehouse.R
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme

@Composable
fun CoffeeGridItem(@DrawableRes imageId: Int, coffeeName: String, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .fillMaxSize()
            .background(Color(0xFFF7F8FB))
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .weight(1f)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(imageId),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = coffeeName,
            style = MaterialTheme.typography.titleSmall,
            color = Color(0xFF001833)
        )
    }
}

@Preview
@Composable
fun CoffeeGridItemPreview() {
    CoffeeHouseTheme {
        CoffeeGridItem(
            imageId = R.drawable.americano,
            coffeeName = "Americano",
            modifier = Modifier.fillMaxSize()
        )
    }
}