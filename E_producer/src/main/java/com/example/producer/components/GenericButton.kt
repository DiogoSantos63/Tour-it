package com.example.producer.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.producer.theme.montserrat

@Composable
fun GenericButton(label: String, size: Int){
    Row {
        Text(
            modifier = Modifier,
            text = label,
            style = TextStyle(
                fontFamily = montserrat,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = size.sp
            )
        )
        Spacer(modifier = Modifier
            .weight(1F))
        Button(
            modifier = Modifier
                .then(Modifier.size(70.dp))
                .border(1.dp, Color.White, CircleShape),
            onClick = { /*TODO*/ },
            colors=  ButtonDefaults.buttonColors(containerColor = Color.White),
        ) {
            Icon(
                Icons.Filled.ArrowForward,
                contentDescription = "Go",
                modifier = Modifier
                    .size(90.dp),
                tint = Color.Black
            )
        }
    }
}