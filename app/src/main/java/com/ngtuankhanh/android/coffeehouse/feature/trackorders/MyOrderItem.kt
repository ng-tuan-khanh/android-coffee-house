package com.ngtuankhanh.android.coffeehouse.feature.trackorders

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme

@Composable
fun MyOrderItem(textColor: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.align(alignment = Alignment.TopStart)
        ) {
            Text(
                text = "24 June | 12:30 PM",
                style = MaterialTheme.typography.labelSmall,
                color = Color(0x38324A59)
            )
            Text(
                text = "Cappuccino",
                style = MaterialTheme.typography.labelSmall,
                color = textColor,
            )
            Text(
                text = "3 Addersion Court Chino Hills, HO56824, United States",
                style = MaterialTheme.typography.labelSmall,
                color = textColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Text(
            text = "$3.00",
            style = MaterialTheme.typography.titleMedium,
            color = textColor,
            modifier = Modifier.align(alignment = Alignment.TopEnd)
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
fun MyOrderItemPreview() {
    CoffeeHouseTheme() {
        MyOrderItem(Color(0xFF324A59))
    }
}
