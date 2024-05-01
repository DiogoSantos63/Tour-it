package com.tour_it.features.productScreen.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectDate(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.DateRange, contentDescription = null,
                    modifier = Modifier.padding(4.dp)
                )
                TextField(
                    value = "12/05", onValueChange = {},
                    modifier = Modifier
                        .size(width = 110.dp, height = 50.dp),
                    textStyle = TextStyle(fontSize = 16.sp),
                )
            }
            Divider(
                color = Color.Black,
                modifier = Modifier
                    .padding(20.dp)
                    .size(width = 1.dp, height = 28.dp)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.DateRange, contentDescription = null,
                    modifier = Modifier.padding(end = 4.dp)
                )
                TextField(
                    value = "20/05", onValueChange = {},
                    modifier = Modifier
                        .size(width = 110.dp, height = 50.dp)
                        .background(color = Color.Green),
                    textStyle = TextStyle(fontSize = 16.sp)
                )
            }
        }
    }
}

@Preview
@Composable
fun SelectDatePreview() {
    SelectDate()
}
