package com.ngtuankhanh.android.coffeehouse.feature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ngtuankhanh.android.coffeehouse.R
import com.ngtuankhanh.android.coffeehouse.feature.common.CommonViewModel
import com.ngtuankhanh.android.coffeehouse.feature.home.OrderSuccess
import com.ngtuankhanh.android.coffeehouse.feature.home.Profile
import com.ngtuankhanh.android.coffeehouse.feature.home.details.Details
import com.ngtuankhanh.android.coffeehouse.feature.home.homepage.HomePage
import com.ngtuankhanh.android.coffeehouse.feature.home.mycart.MyCart
import com.ngtuankhanh.android.coffeehouse.feature.rewards.Redeem
import com.ngtuankhanh.android.coffeehouse.feature.rewards.Rewards
import com.ngtuankhanh.android.coffeehouse.feature.trackorders.MyOrder

@Composable
fun CoffeeHouseApp() {
    val navController = rememberNavController()

    val viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
        "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
    }

    NavHost(navController = navController, startDestination = "home_page") {
        composable("home_page") {
            CompositionLocalProvider(LocalViewModelStoreOwner provides viewModelStoreOwner) {
                HomePage(navController = navController)
            }
        }
        composable("rewards") {
            CompositionLocalProvider(LocalViewModelStoreOwner provides viewModelStoreOwner) {
                Rewards(navController = navController)
            }
        }
        composable("my_order") {
            CompositionLocalProvider(LocalViewModelStoreOwner provides viewModelStoreOwner) {
                MyOrder(navController = navController)
            }
        }
        composable(
            route = "details/{imageId}/{coffeeName}?discount={discount}",
            arguments = listOf(
                navArgument("imageId") { type = NavType.IntType },
                navArgument("coffeeName") { type = NavType.StringType },
                navArgument("discount") { type = NavType.FloatType; defaultValue = 0f })
        ) { backStackEntry ->
            CompositionLocalProvider(LocalViewModelStoreOwner provides viewModelStoreOwner) {

                val imageId =
                    backStackEntry.arguments?.getInt("imageId") ?: R.drawable.americano
                val coffeeName = backStackEntry.arguments?.getString("coffeeName") ?: "Americano"
                val discount = backStackEntry.arguments?.getFloat("discount") ?: 0f
                Details(
                    imageId = imageId,
                    coffeeName = coffeeName,
                    discount = discount,
                    navController = navController
                )
            }
        }
        composable("my_cart") {
            CompositionLocalProvider(LocalViewModelStoreOwner provides viewModelStoreOwner) {
                MyCart(navController = navController)
            }
        }
        composable("order_success") {
            OrderSuccess(navController = navController)
        }
        composable("profile") {
            Profile(navController = navController)
        }
        composable("redeem") {
            CompositionLocalProvider(LocalViewModelStoreOwner provides viewModelStoreOwner) {
                Redeem(navController = navController)
            }
        }
    }
}