package com.example.producer.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.e_producer.R


@Composable
fun GATopBar() {
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
}

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
fun GATopBarPreview() {
    GATopBar()
}