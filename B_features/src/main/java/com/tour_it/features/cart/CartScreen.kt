package com.tour_it.features.cart

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_producer.R
import com.tour_it.features.cart.compose.CartCompose
import com.tour_it.producer.components.GAProfileCircle

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen() {
    Scaffold(
        containerColor = Color(0xFF313131),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF313131)
                ),
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.logo_tour_it),
                        contentDescription = null,
                        modifier = Modifier
                            .size(170.dp)
                            .padding(top = 16.dp, start = 16.dp)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        GAProfileCircle(
                            image = R.drawable.sem_t_tulo,
                            modifier = Modifier
                                .padding(16.dp)
                        )
                    }
                },
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(top = 80.dp)
                    .padding(horizontal = 16.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                        )
                        Text(
                            text = "Cart",
                            fontSize = 24.sp,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.width(140.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Total:",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "205€",
                            fontSize = 24.sp,
                            color = Color.White
                        )
                    }
                }
                Divider(
                    thickness = 4.dp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(end = 270.dp, top = 4.dp)
                )
                Spacer(modifier = Modifier.height(28.dp))
                CartCompose()
                Spacer(modifier = Modifier.height(8.dp))
                CartCompose()
                Spacer(modifier = Modifier.height(8.dp))
                CartCompose()
                Spacer(modifier = Modifier.height(40.dp))

                Row {
                    Column {
                        Text(text = "Promo code", fontSize = 12.sp, color = Color.White)
                        Spacer(modifier = Modifier.height(12.dp))

                        Box(
                            modifier = Modifier
                                .background(Color.White)
                                .size(width = 154.dp, height = 27.dp)
                        ) {
                            TextField(
                                value = "",
                                onValueChange = {},
                                modifier = Modifier
                                    .size(width = 154.dp, height = 24.dp)
                            )

                        }
                    }
                    Spacer(modifier = Modifier.width(40.dp))

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "You will earn", fontSize = 12.sp, color = Color.White)
                        Spacer(modifier = Modifier.height(12.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "25 Points",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(35.dp))

                Divider(
                    thickness = 2.dp,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

        },
        bottomBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(vertical = 50.dp)
                    .padding(start = 50.dp)
            ) {
                Text(
                    text = "Payment",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(40.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .background(color = Color.White, shape = CircleShape)
                ) {
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
                }
            }

        }
    )

}


@Preview
@Composable
fun CartScreenPreview() {
    CartScreen()
}
