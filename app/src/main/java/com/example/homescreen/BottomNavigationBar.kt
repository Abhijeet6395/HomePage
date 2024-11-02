package com.example.homescreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    onNavigate: (destination: Destination) -> Unit
) {
    BottomNavigation(modifier = modifier) {
        listOf(
            Destination.Feed,
            Destination.Contacts,
            Destination.Calendar
        ).forEach {
            BottomNavigationItem(selected = currentDestination.path == it.path,
                onClick = { onNavigate(it) },
                icon = {
                    it.icon?.let { image ->
                        Icon(
                            imageVector = image,
                            contentDescription = it.path
                        )
                    }
                }, label = {
                    Text(text = it.title)
                }
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(modifier = Modifier.fillMaxWidth(), currentDestination = Destination.Feed, onNavigate = {})
}