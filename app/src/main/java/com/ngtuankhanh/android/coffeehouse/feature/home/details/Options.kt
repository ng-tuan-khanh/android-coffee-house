package com.ngtuankhanh.android.coffeehouse.feature.home.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme

@Composable
fun AmountOption(name: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 8.dp,
                end = 8.dp
            )
        ) {
            Text(text = name)
        }
        Divider(
            color = Color.Cyan, modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun ShotOption() {
    Divider(
        color = Color.Cyan, modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
    )
    Row(
        modifier = Modifier.padding(
            top = 16.dp,
            bottom = 16.dp,
            start = 8.dp,
            end = 8.dp
        )
    ) {
        Text(text = "Shot")
    }
    Divider(
        color = Color.Cyan, modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
    )
}

@Composable
fun HotColdOption() {
    Divider(
        color = Color.Cyan, modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
    )
    Row(
        modifier = Modifier.padding(
            top = 16.dp,
            bottom = 16.dp,
            start = 8.dp,
            end = 8.dp
        )
    ) {
        Text(text = "Select")
    }
    Divider(
        color = Color.Cyan, modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
    )
}

@Composable
fun SizeOption() {
    Divider(
        color = Color.Cyan, modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
    )
    Row(
        modifier = Modifier.padding(
            top = 16.dp,
            bottom = 16.dp,
            start = 8.dp,
            end = 8.dp
        )
    ) {
        Text(text = "Size")
    }
    Divider(
        color = Color.Cyan, modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
    )
}

@Composable
fun IceOption() {
    Divider(
        color = Color.Cyan, modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
    )
    Row(
        modifier = Modifier.padding(
            top = 16.dp,
            bottom = 16.dp,
            start = 8.dp,
            end = 8.dp
        )
    ) {
        Text(text = "Ice")
    }
}

@Preview
@Composable
fun AmountOptionPreview() {
    CoffeeHouseTheme {
        AmountOption(name = "Americano")
    }
}

@Preview
@Composable
fun ShotOptionPreview() {
    CoffeeHouseTheme {
        ShotOption()
    }
}

@Preview
@Composable
fun HotColdOptionPreview() {
    CoffeeHouseTheme {
        HotColdOption()
    }
}

@Preview
@Composable
fun SizeOptionPreview() {
    CoffeeHouseTheme {
        SizeOption()
    }
}

@Preview
@Composable
fun IceOptionPreview() {
    CoffeeHouseTheme {
        IceOption()
    }
}