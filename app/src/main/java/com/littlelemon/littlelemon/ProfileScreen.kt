package com.littlelemon.littlelemon

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)

    // Retrieve user information from SharedPreferences
    var firstName by remember { mutableStateOf(sharedPreferences.getString("first_name", "") ?: "") }
    var lastName by remember { mutableStateOf(sharedPreferences.getString("last_name", "") ?: "") }
    var email by remember { mutableStateOf(sharedPreferences.getString("email", "") ?: "") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .height(100.dp)
                .padding(bottom = 16.dp)
                .width(250.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Personal Information",
            fontSize = 22.sp,
            modifier = Modifier.padding(top = 32.dp, bottom = 32.dp)
        )

        // First Name Input
        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it }, // Allow editing the first name
            label = { Text("First Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Last Name Input
        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it }, // Allow editing the last name
            label = { Text("Last Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email Input
        OutlinedTextField(
            value = email,
            onValueChange = { email = it }, // Allow editing the email
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
        )

        Spacer(modifier = Modifier.height(64.dp))

        // Logout Button
        Button(
            onClick = {
                // Clear user data from SharedPreferences
                with(sharedPreferences.edit()) {
                    clear()
                    apply()
                }
                // Navigate back to Onboarding screen
                navController.navigate(Destination.Onboarding.route) {
                    popUpTo(Destination.Onboarding.route) { inclusive = true }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4CE14)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 26.dp)
        ) {
            Text(text = "Log out", color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(navController = rememberNavController())
}
