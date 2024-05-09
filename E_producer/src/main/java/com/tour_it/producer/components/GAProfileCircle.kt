package com.tour_it.producer.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.e_producer.R

@Composable
fun GAProfileCircle(image: Int, modifier: Modifier = Modifier) {
    Box {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
    }
}

@Preview
@Composable
fun GAProfileCirclePreview() {
    GAProfileCircle(
        image = R.drawable.sem_t_tulo,
        modifier = Modifier
            .padding(16.dp)
    )
}