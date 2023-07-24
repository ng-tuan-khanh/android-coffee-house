package com.ngtuankhanh.android.coffeehouse.feature.home.homepage

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
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
import com.ngtuankhanh.android.coffeehouse.ui.theme.typography

@Composable
fun CoffeeGridItem(@DrawableRes id: Int, name: String, modifier: Modifier) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .fillMaxSize()
            .background(Color(0xFFF7F8FB))
    ) {
        Box(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 16.dp, start = 20.dp, end = 20.dp)
                .weight(1f)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = name,
            style = typography.titleSmall,
            color = Color(0xFF001833)
        )
    }
}

@Preview
@Composable
fun CoffeeGridItemPreview() {
    CoffeeHouseTheme {
        CoffeeGridItem(
            id = R.drawable.americano,
            name = "Americano",
            modifier = Modifier.fillMaxSize()
        )
    }
}