package com.example.homescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Text
import java.util.Locale
import java.util.Locale.getDefault

@Composable

fun DrawerItem(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit
) {
    Text(text = label.replaceFirstChar { it.titlecase(Locale.getDefault()) },
        modifier = modifier
            .clickable
            { onClick() }
            .padding(16.dp),
        color = Color.Black
    )
}

@Preview(showBackground = true)
@Composable
fun DrawerItemPreview() {
    DrawerItem(label = "upgrade", onClick = {})
}