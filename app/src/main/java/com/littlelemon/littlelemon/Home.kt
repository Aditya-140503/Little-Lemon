package com.littlelemon.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

// Home.kt
@Composable
fun Home(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Logo in the center
        Image(
            painter = painterResource(id = R.drawable.logo), // Replace with your logo resource
            contentDescription = "Logo"
        )

        // Profile icon as a button
        Image(
            painter = painterResource(id = R.drawable.profile), // Replace with your profile icon resource
            contentDescription = "Profile",
            modifier = Modifier.clickable {
                navController.navigate(Destination.ProfileScreen.route)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    Home(navController = rememberNavController())
}
