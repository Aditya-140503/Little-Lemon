package com.littlelemon.littlelemon

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destination.Onboarding.route) {
        composable(Destination.Onboarding.route) {
            Onboarding(navController = navController)
        }
        composable(Destination.Home.route) {
            Home(navController = navController)
        }
        composable(Destination.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
    }
}



