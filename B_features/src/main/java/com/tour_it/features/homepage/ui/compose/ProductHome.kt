package com.tour_it.features.homepage.ui.compose

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.b_features.R

@Composable
fun ProductHome(
    image: Int,
    productName: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .size(height = 88.dp, width = 96.dp)
                .clip(RoundedCornerShape(20))
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = productName,
            color = Color.White
        )

    }
}

@Preview
@Composable
fun ProductHomePreview() {
    ProductHome(
        image = R.drawable.rectangle_18,
        productName = "O Açude",
    )
}