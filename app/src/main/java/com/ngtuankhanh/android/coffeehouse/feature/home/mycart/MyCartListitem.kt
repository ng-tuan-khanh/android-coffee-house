package com.ngtuankhanh.android.coffeehouse.feature.home.mycart

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun MyCartListItem(@DrawableRes id: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(Color(0xFFF7F8FB))
            .padding(16.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            Image(
                painterResource(id = id),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(2f)
                .fillMaxSize()
        ) {
            Column(modifier = Modifier
                .weight(3f)
                .width(IntrinsicSize.Min)) {
                Text(
                    text = "Americano",
                    style = typography.labelMedium,
                    color = Color(0xFF001833),
                    maxLines = 1,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
                Text(
                    text = "single|iced|medium|full ice",
                    style = typography.labelSmall,
                    color = Color(0x91000000),
                    maxLines = 1,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
                Text(text = "x 1", style = typography.labelMedium, color = Color(0x91000000))
            }
            Box(
                contentAlignment = Alignment.CenterEnd, modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(2f)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "$3.0",
                    style = typography.titleMedium,
                    color = Color(0xFF001833),
                    maxLines = 1,
                )
            }
        }
    }
}

@Preview
@Composable
fun MyCartListItemPreview() {
    CoffeeHouseTheme() {
        MyCartListItem(id = R.drawable.americano)
    }
}