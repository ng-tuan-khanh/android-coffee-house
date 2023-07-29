package com.ngtuankhanh.android.coffeehouse.feature.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.testing.TestNavHostController
import com.ngtuankhanh.android.coffeehouse.R
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .border(width = 2.dp, color = Color(0xFFF4F5F7), shape = RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
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

@Preview
@Composable
fun BottomNavigationBarPreview() {
    CoffeeHouseTheme() {
        BottomNavigationBar(navController = TestNavHostController(LocalContext.current))
    }
}