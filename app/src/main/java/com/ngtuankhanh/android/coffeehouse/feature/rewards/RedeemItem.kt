package com.ngtuankhanh.android.coffeehouse.feature.rewards

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngtuankhanh.android.coffeehouse.R
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme

@Composable
fun RedeemItem() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .width(70.dp)
                .height(50.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.americano),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .weight(1f)
                .fillMaxWidth()
        ) {
            Text(
                text = "Americano",
                style = MaterialTheme.typography.titleSmall,
                color = Color(0xFF324A59),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Valid until 04.07.21",
                style = MaterialTheme.typography.labelSmall,
                color = Color(0x80324A59),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(50))
                .clickable(onClick = {
                })
                .background(Color(0xFF324A59))
                .padding(top = 8.dp, bottom = 8.dp, start = 12.dp, end = 12.dp)
        ) {
            Text(
                text = "1340 pts",
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFFFFFFFF)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRedeemItem() {
    CoffeeHouseTheme() {
        RedeemItem()
    }
}