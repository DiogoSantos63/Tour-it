package com.tour_it.features.cart.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.b_features.R

@Composable
fun CartCompose(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .background(color = Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.hotel_vila_),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 84.dp, height = 74.dp)
            )
            Spacer(modifier = Modifier.width(24.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Hotel Vila Galé",
                    fontWeight = FontWeight.Bold,
                )
                Text(text = "R. Abel Dias Urbano")
                Text(text = "12-05 to 13-05")
            }

            Spacer(modifier = Modifier.width(28.dp))

            Text(
                text = "120€",
                fontWeight = FontWeight.Bold,
            )

        }}

}

@Preview
@Composable
fun CartComposePreview() {
    CartCompose()
}