package com.tour_it.features.productScreen.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.b_features.R

@Composable
fun ShowProduct(
    image: Int,
    productName: String,
    pointsValue: String,
    price: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = productName,
            color = Color.White
        )
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(20))
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = pointsValue,
                color = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = price,
                color = Color.White
            )
        }

    }

}

@Preview
@Composable
fun ShowProductPreview() {
    ShowProduct(
        image = R.drawable.rectangle_18,
        productName = "O Açude",
        pointsValue = "€€",
        price = "4.2"
    )
}