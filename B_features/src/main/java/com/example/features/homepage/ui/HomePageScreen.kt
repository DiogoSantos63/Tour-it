package com.example.features.homepage.ui

import com.example.features.homepage.ui.compose.GABottomBarNavigation
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.b_features.R
import com.example.features.homepage.ui.compose.GAProfileCircle
import com.example.features.homepage.ui.compose.GAShowProduct

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageScreen() {

    Scaffold(
        containerColor = Color(0xFF313131),
        topBar = {
            Surface(
                color = Color(0xFF313131),
            ) {
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(start = 100.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo_tour_it),
                            contentDescription = null,
                            modifier = Modifier
                                .size(170.dp)
                                .padding(start = 16.dp)
                        )
                        Spacer(modifier = Modifier.width(50.dp))
                        GAProfileCircle(
                            image = R.drawable.sem_t_tulo,
                            modifier = Modifier
                                .padding(16.dp)
                        )
                    }
                }
            }
        },
        content = {
            Column(
                modifier = Modifier.padding(top = 190.dp, start = 16.dp, end = 16.dp)
            ) {
                Column(modifier = Modifier.padding(end = 100.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Welcome",
                            fontSize = 24.sp,
                            color = Color.White
                        )
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append(", ")
                                }
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("user!")
                                }
                            },
                            fontSize = 24.sp,
                            color = Color.White
                        )
                    }
                    Divider(
                        thickness = 4.dp,
                        color = Color.White,
                        modifier = Modifier.padding(end = 130.dp)
                    )
                }
                Spacer(modifier = Modifier.height(60.dp))
                Column {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.KeyboardArrowRight,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                        Text(
                            text = "Near you",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(150.dp))

                        TextButton(
                            onClick = {},
                            content = {
                                Text(
                                    "See All",
                                    fontSize = 16.sp,
                                    color = Color.White
                                )
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    LazyRow {
                        items(3) {
                            GAShowProduct(
                                image = R.drawable.rectangle_18,
                                productName = "O Açude",
                            )
                        }
                    }
                }

                //alterar isto
                Spacer(modifier = Modifier.height(40.dp))
                Column {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                        Text(
                            text = "Promos",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(150.dp))
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    LazyRow {
                        items(3) {
                            GAShowProduct(
                                image = R.drawable.rectangle_18,
                                productName = "O Açude",
                            )
                        }
                    }
                }
            }
        },
        bottomBar = {
            /*Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,

                ) {
                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .background(Color.LightGray, shape = CircleShape)
                )

                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color.Black, shape = CircleShape)
                        .align(Alignment.Center)
                )

                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.Center),
                    tint = Color.White
                )
            }*/
            Surface(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)) {
                GABottomBarNavigation()
            }
        }
    )
}

@Preview
@Composable
fun HomePageScreenPreview() {
    HomePageScreen()
}