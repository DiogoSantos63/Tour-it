package com.example.features.authentication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.b_features.R
import com.example.producer.components.GenericButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    navBackStackEntry: NavBackStackEntry
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF313131)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier) {
            Image(
                modifier = Modifier
                    .padding(start = 40.dp)
                    .size(400.dp),
                painter = painterResource(id = R.drawable.logo_tour_it),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(start = 40.dp, end = 40.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    modifier = Modifier
                        .padding(10.dp),
                    text = "Username",
                    color = Color.White
                )
                TextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text("Jonh_Doe", color = Color.Gray) },
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    modifier = Modifier
                        .padding(10.dp),
                    text = "Password",
                    color = Color.White
                )
                TextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text("*********", color = Color.Gray) },
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(70.dp))
                GenericButton("Sign In", 40)
            }
        }
    }
}