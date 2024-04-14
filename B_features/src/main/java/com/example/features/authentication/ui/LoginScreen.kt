package com.example.features.authentication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController


@Composable
fun LoginScreen(
    navController: NavController,
    navBackStackEntry: NavBackStackEntry
){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "hello")
    }
}