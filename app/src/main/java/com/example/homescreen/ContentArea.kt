package com.example.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContentArea(modifier: Modifier = Modifier, destination: Destination) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        destination.icon?.let { icon ->
            Icon(
                modifier = Modifier.size(80.dp),
                imageVector = icon,
                contentDescription = destination.title
            )

            Spacer(modifier = Modifier.height(20.dp))
        }
        Text(text = destination.title, fontSize = 19.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun ContentAreaPreview() {
    ContentArea(destination = Destination.Home)
}