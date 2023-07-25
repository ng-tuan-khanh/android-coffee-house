package com.ngtuankhanh.android.coffeehouse.feature.home.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngtuankhanh.android.coffeehouse.R
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme
import com.ngtuankhanh.android.coffeehouse.ui.theme.typography

enum class ShotOptions {
    SINGLE, DOUBLE
}

enum class SelectOptions {
    STANDARD, PLASTIC
}

enum class SizeOptions {
    SMALL, MEDIUM, BIG
}

enum class IceOptions {
    ICE1, ICE2, ICE3
}

@Composable
fun AmountOption(name: String, counter: MutableState<Int>) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 8.dp,
                end = 8.dp
            )
    ) {
        Text(text = name, style = typography.titleSmall, color = Color(0xFF001833))
        Row(
            modifier = Modifier
                .width(80.dp)
                .height(30.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFFD8D8D8),
                    shape = RoundedCornerShape(percent = 50)
                )
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clickable(onClick = {
                        ++counter.value
                    })
                    .weight(1f)
                    .fillMaxSize()
            ) {

                Text(
                    text = "+",
                    textAlign = TextAlign.Center,
                    style = typography.titleSmall,
                    color = Color(0xFF001833)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {

                Text(
                    text = "${counter.value}",
                    textAlign = TextAlign.Center,
                    style = typography.titleSmall,
                    color = Color(0xFF001833)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clickable(onClick = {
                        if (counter.value > 1) --counter.value
                    })
                    .weight(1f)
                    .fillMaxSize()
            ) {

                Text(
                    text = "-",
                    textAlign = TextAlign.Center,
                    style = typography.titleSmall,
                    color = Color(0xFF001833)
                )
            }
        }
    }
}

@Composable
fun ShotOption(shotOption: MutableState<ShotOptions>) {
    Divider(
        color = Color(0xFFD8D8D8), modifier = Modifier
            .height(2.dp)
            .fillMaxWidth()
    )
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 8.dp,
                end = 8.dp
            )
    ) {
        Text(text = "Shot", style = typography.titleSmall, color = Color(0xFF001833))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(80.dp)
                    .height(30.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFFD8D8D8),
                        shape = RoundedCornerShape(percent = 50)
                    )
                    .clickable(onClick = {
                        shotOption.value = ShotOptions.SINGLE
                    })
            ) {
                Text(
                    text = "Single",
                    textAlign = TextAlign.Center,
                    style = typography.labelMedium,
                    color = if (shotOption.value == ShotOptions.SINGLE) Color(0xFF001833) else Color(
                        0xFFD8D8D8
                    )
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(80.dp)
                    .height(30.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFFD8D8D8),
                        shape = RoundedCornerShape(percent = 50)
                    )
                    .clickable(onClick = {
                        shotOption.value = ShotOptions.DOUBLE
                    })
            ) {
                Text(
                    text = "Double",
                    textAlign = TextAlign.Center,
                    style = typography.labelMedium,
                    color = if (shotOption.value == ShotOptions.DOUBLE) Color(0xFF001833) else Color(
                        0xFFD8D8D8
                    )
                )
            }
        }
    }
}

@Composable
fun SelectOption(selectOption: MutableState<SelectOptions>) {
    Divider(
        color = Color(0xFFD8D8D8), modifier = Modifier
            .height(2.dp)
            .fillMaxWidth()
    )
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 8.dp,
                end = 8.dp
            )
    ) {
        Text(text = "Select", style = typography.titleSmall, color = Color(0xFF001833))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            IconButton(onClick = { selectOption.value = SelectOptions.STANDARD }) {
                Icon(
                    painterResource(id = R.drawable.standardcup),
                    contentDescription = null,
                    tint = if (selectOption.value == SelectOptions.STANDARD) Color(0xFF001833) else Color(
                        0xFFD8D8D8
                    )
                )
            }
            IconButton(onClick = { selectOption.value = SelectOptions.PLASTIC }) {
                Icon(
                    painterResource(id = R.drawable.plasticcup),
                    contentDescription = null,
                    tint = if (selectOption.value == SelectOptions.PLASTIC) Color(0xFF001833) else Color(
                        0xFFD8D8D8
                    )
                )
            }
        }
    }
}

@Composable
fun SizeOption(sizeOption: MutableState<SizeOptions>) {
    Divider(
        color = Color(0xFFD8D8D8), modifier = Modifier
            .height(2.dp)
            .fillMaxWidth()
    )
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 8.dp,
                end = 8.dp
            )
    ) {
        Text(text = "Size", style = typography.titleSmall, color = Color(0xFF001833))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            IconButton(onClick = { sizeOption.value = SizeOptions.SMALL }) {
                Icon(
                    painterResource(id = R.drawable.smallsize),
                    contentDescription = null,
                    tint = if (sizeOption.value == SizeOptions.SMALL) Color(0xFF001833) else Color(
                        0xFFD8D8D8
                    )
                )
            }
            IconButton(onClick = { sizeOption.value = SizeOptions.MEDIUM }) {
                Icon(
                    painterResource(id = R.drawable.mediumsize),
                    contentDescription = null,
                    tint = if (sizeOption.value == SizeOptions.MEDIUM) Color(0xFF001833) else Color(
                        0xFFD8D8D8
                    )
                )
            }
            IconButton(onClick = { sizeOption.value = SizeOptions.BIG }) {
                Icon(
                    painterResource(id = R.drawable.bigsize),
                    contentDescription = null,
                    tint = if (sizeOption.value == SizeOptions.BIG) Color(0xFF001833) else Color(
                        0xFFD8D8D8
                    )
                )
            }
        }
    }
}

@Composable
fun IceOption(iceOption: MutableState<IceOptions>) {
    Divider(
        color = Color(0xFFD8D8D8), modifier = Modifier
            .height(2.dp)
            .fillMaxWidth()
    )
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 8.dp,
                end = 8.dp
            )
    ) {
        Text(text = "Ice", style = typography.titleSmall, color = Color(0xFF001833))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            IconButton(onClick = { iceOption.value = IceOptions.ICE1 }) {
                Icon(
                    painterResource(id = R.drawable.ice1),
                    contentDescription = null,
                    tint = if (iceOption.value == IceOptions.ICE1) Color(0xFF001833) else Color(
                        0xFFD8D8D8
                    )
                )
            }
            IconButton(onClick = { iceOption.value = IceOptions.ICE2 }) {
                Icon(
                    painterResource(id = R.drawable.ice2),
                    contentDescription = null,
                    tint = if (iceOption.value == IceOptions.ICE2) Color(0xFF001833) else Color(
                        0xFFD8D8D8
                    )
                )
            }
            IconButton(onClick = { iceOption.value = IceOptions.ICE3 }) {
                Icon(
                    painterResource(id = R.drawable.ice3),
                    contentDescription = null,
                    tint = if (iceOption.value == IceOptions.ICE3) Color(0xFF001833) else Color(
                        0xFFD8D8D8
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AmountOptionPreview() {
    CoffeeHouseTheme {
        val counter = rememberSaveable { mutableStateOf(1) }
        AmountOption(name = "Americano", counter = counter)
    }
}

@Preview(showBackground = true)
@Composable
fun ShotOptionPreview() {
    CoffeeHouseTheme {
        val shotOption = rememberSaveable { mutableStateOf(ShotOptions.SINGLE) }
        ShotOption(shotOption = shotOption)
    }
}

@Preview(showBackground = true)
@Composable
fun SelectOptionPreview() {
    CoffeeHouseTheme {
        val selectOption = rememberSaveable { mutableStateOf(SelectOptions.STANDARD) }
        SelectOption(selectOption = selectOption)
    }
}

@Preview(showBackground = true)
@Composable
fun SizeOptionPreview() {
    CoffeeHouseTheme {
        val sizeOption = rememberSaveable { mutableStateOf(SizeOptions.SMALL) }
        SizeOption(sizeOption = sizeOption)
    }
}

@Preview(showBackground = true)
@Composable
fun IceOptionPreview() {
    CoffeeHouseTheme {
        val iceOption = rememberSaveable { mutableStateOf(IceOptions.ICE1) }
        IceOption(iceOption = iceOption)
    }
}