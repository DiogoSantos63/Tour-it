package com.tour_it.features.authentication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.tour_it.features.authentication.AuthenticationViewModel
import com.tour_it.producer.components.GenericButton
import com.tour_it.producer.navigation.NavigationItem
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    navController: NavController,
    navBackStackEntry: NavBackStackEntry,
) {
    var email by remember { mutableStateOf("")}
    var passWord by remember { mutableStateOf("") }

    val viewModel: AuthenticationViewModel = getViewModel()
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
                painter = painterResource(id = com.example.e_producer.R.drawable.logo_tour_it),
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
                    value = email,
                    onValueChange = {
                        email = it
                        viewModel.updateEmail(it)
                    },
                    placeholder = { Text("Jonh_Doe", color = Color.Gray) },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {  viewModel.updateEmail(email) }),
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
                    value = passWord,
                    onValueChange = {
                        passWord = it
                        viewModel.updatePassWord(it)
                    },
                    placeholder = { Text("*********", color = Color.Gray) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {  viewModel.updatePassWord(passWord) }),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Don't have an account?",
                        color = Color.White
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .clickable { navController.navigate(NavigationItem.SignUpScreen.route) },
                        text = "Sign up",
                        color = Color(0xFFFF9000)
                    )
                }
                Spacer(modifier = Modifier.height(70.dp))
                GenericButton(
                    label = "Sign In",
                    size = 40,
                    onClick = {
                        viewModel.onSignInClick { _, _ ->
                            navController.popBackStack(NavigationItem.SignInScreen.route, true)
                            navController.navigate(NavigationItem.HomePageScreen.route)
                        }
                    }
                )
            }
        }
    }
}