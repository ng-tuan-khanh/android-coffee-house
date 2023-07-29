package com.ngtuankhanh.android.coffeehouse.feature.rewards

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ngtuankhanh.android.coffeehouse.feature.home.details.ShotOptions
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme

@Composable
fun HistoryRewardsItem() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                bottom = 16.dp
            )
    ) {
        Column() {
            Text(text = "Americano", style = MaterialTheme.typography.labelMedium, color = Color(0xFF001833))
            Text(text =  "24 June | 12:30 PM", style = MaterialTheme.typography.labelSmall, color = Color(0x38324A59))
        }
        Text(
            text = "+ 12 pts",
            style = MaterialTheme.typography.titleMedium.merge(TextStyle(fontSize = 16.sp)),
            color = Color(0xFF001833)
        )
    }
    Divider(
        color = Color(0xFFD8D8D8), modifier = Modifier
            .height(2.dp)
            .fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun HistoryRewardsItemPreview() {
    CoffeeHouseTheme() {
        HistoryRewardsItem()
    }
}