package com.example.features.searchScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.b_features.R
import com.example.features.searchScreen.compose.ShowProduct
import com.example.producer.components.GABottomBarNavigation
import com.example.producer.components.GATopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    Scaffold(
        containerColor = Color(0xFF313131),
        topBar = {
            GATopBar()
        },
        content = {
            Column(
                modifier = Modifier.padding(top = 164.dp, start = 16.dp, end = 16.dp)
            ) {
                Column(modifier = Modifier.padding(end = 100.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search, contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)) {
                                    append("Search")
                                }
                            },
                            fontSize = 40.sp,
                            color = Color.White
                        )
                    }
                    Divider(
                        thickness = 4.dp,
                        color = Color.White,
                        modifier = Modifier.padding(end = 130.dp)
                    )
                }
                Spacer(modifier = Modifier.height(28.dp))
                repeat(3) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        repeat(3) {
                            ShowProduct(
                                image = R.drawable.rectangle_18,
                                productName = "O Açude",
                                pointsValue = "€€",
                                price = "4.2"
                            )
                        }
                    }
                }
            }
        },
        bottomBar = {
            Surface(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)) {
                GABottomBarNavigation()
            }
        }
    )

}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}