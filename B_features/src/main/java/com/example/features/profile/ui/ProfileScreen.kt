package com.example.features.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.b_features.R
import com.example.producer.components.GenericButton
import com.example.producer.theme.montserrat

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF313131))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(40.dp),
                imageVector = Icons.Default.ArrowBack,
                tint = Color.White,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.weight(1F))
            Icon(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .size(100.dp),
                tint = Color.White,
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = "Settings",
                color = Color.White
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "username",
                    style = TextStyle(
                        fontFamily = montserrat,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(18.dp),
                        painter = painterResource(id = R.drawable.baseline_diamond_24),
                        tint = Color.White,
                        contentDescription = null
                    )
                    Text(
                        text = "120 Points",
                        style = TextStyle(
                            fontFamily = montserrat,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 55.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        modifier = Modifier.size(45.dp),
                        painter = painterResource(id = R.drawable.baseline_library_books_24),
                        tint = Color.White,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "My bookings",
                        style = TextStyle(
                            fontFamily = montserrat,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                    )
                }
                Divider(
                    color = Color.Gray,
                    thickness = 5.dp,
                    modifier = Modifier
                        .width(150.dp)
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                )
            }
        }
        Spacer(modifier = Modifier.weight(1F))
        Row (
            modifier = Modifier
                .padding(start = 35.dp, end = 35.dp, bottom = 55.dp)
        ){
            GenericButton(label = "Log Out", size = 45)
        }
    }
}