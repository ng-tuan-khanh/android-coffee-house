package com.ngtuankhanh.android.coffeehouse.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.testing.TestNavHostController
import com.ngtuankhanh.android.coffeehouse.ui.theme.CoffeeHouseTheme
import com.ngtuankhanh.android.coffeehouse.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Profile",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFF001833)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = Color(0xFF001833)
                        )
                    }
                })
        }
    ) { contentPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 24.dp, start = 24.dp, end = 24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .clip(shape = CircleShape)
                            .background(Color(0xFFF7F8FB))
                            .padding(8.dp)
                    ) {
                        Icon(
                            painterResource(id = R.drawable.profile),
                            contentDescription = null,
                            tint = Color(0xFF324A59)
                        )
                    }
                    Column(modifier = Modifier.padding(start = 14.dp)) {
                        Text(
                            "Full name",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0x38001833)
                        )
                        Text(
                            "Anderson",
                            style = MaterialTheme.typography.titleLarge.merge(TextStyle(fontSize = 14.sp)),
                            color = Color(0xFF324A59)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .clip(shape = CircleShape)
                            .background(Color(0xFFF7F8FB))
                            .padding(8.dp)
                    ) {
                        Icon(
                            painterResource(id = R.drawable.telephone),
                            contentDescription = null,
                            tint = Color(0xFF324A59)
                        )
                    }
                    Column(modifier = Modifier.padding(start = 14.dp)) {
                        Text(
                            "Phone number",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0x38001833)
                        )
                        Text(
                            "+60134589525",
                            style = MaterialTheme.typography.titleLarge.merge(TextStyle(fontSize = 14.sp)),
                            color = Color(0xFF324A59)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .clip(shape = CircleShape)
                            .background(Color(0xFFF7F8FB))
                            .padding(8.dp)
                    ) {
                        Icon(
                            painterResource(id = R.drawable.mail),
                            contentDescription = null,
                            tint = Color(0xFF324A59)
                        )
                    }
                    Column(modifier = Modifier.padding(start = 14.dp)) {
                        Text(
                            "Email",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0x38001833)
                        )
                        Text(
                            "Anderson@email.com",
                            style = MaterialTheme.typography.titleLarge.merge(TextStyle(fontSize = 14.sp)),
                            color = Color(0xFF324A59)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .clip(shape = CircleShape)
                            .background(Color(0xFFF7F8FB))
                            .padding(8.dp)
                    ) {
                        Icon(
                            painterResource(id = R.drawable.location),
                            contentDescription = null,
                            tint = Color(0xFF324A59)
                        )
                    }
                    Column(modifier = Modifier.padding(start = 14.dp)) {
                        Text(
                            "Address",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0x38001833)
                        )
                        Text(
                            "3 Addersion Court\n" +
                                    "Chino Hills, HO56824, United States",
                            style = MaterialTheme.typography.titleLarge.merge(TextStyle(fontSize = 14.sp)),
                            color = Color(0xFF324A59)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProfilePreview() {
    CoffeeHouseTheme() {
        Profile(navController = TestNavHostController(LocalContext.current))
    }
}