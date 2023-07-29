package com.ngtuankhanh.android.coffeehouse.feature

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ngtuankhanh.android.coffeehouse.feature.home.OrderSuccess
import com.ngtuankhanh.android.coffeehouse.feature.home.Profile
import com.ngtuankhanh.android.coffeehouse.feature.home.details.Details
import com.ngtuankhanh.android.coffeehouse.feature.home.homepage.HomePage
import com.ngtuankhanh.android.coffeehouse.feature.home.mycart.MyCart
import com.ngtuankhanh.android.coffeehouse.feature.rewards.Rewards
import com.ngtuankhanh.android.coffeehouse.feature.trackorders.MyOrder

@Composable
fun CoffeeHouseApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_page") {
        composable("home_page") {
            HomePage(navController = navController)
        }
        composable("rewards") {
            Rewards(navController = navController)
        }
        composable("my_order") {
            MyOrder(navController = navController)
        }
        composable("details") {
            Details(navController = navController)
        }
        composable("my_cart") {
            MyCart(navController = navController)
        }
        composable("order_success") {
            OrderSuccess(navController = navController)
        }
        composable("profile") {
            Profile(navController = navController)
        }
    }
}