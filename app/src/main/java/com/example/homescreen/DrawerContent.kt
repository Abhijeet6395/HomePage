package com.example.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material3.Text
import com.example.homescreen.ui.theme.HomeScreenTheme

@Composable
fun DrawerContent(
    modifier: Modifier = Modifier,
    onNavigationSelected: (destination: Destination) -> Unit,
    onLogout: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = Color.White)
    ) {
        Text(
            modifier = Modifier.padding(20.dp),
            text = stringResource(R.string.label_name),
            color = Color.Red,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            modifier = Modifier.padding(20.dp),
            text = stringResource(R.string.label_email),
            color = Color.Red,
            fontSize = 16.sp
        )
        Divider(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .background(color = Color.Magenta)
        )
        DrawerItem(
            modifier = Modifier
                .background(color = Color.Magenta)
                .fillMaxWidth(),
            label = Destination.Upgrade.path
        ) {
            onNavigationSelected(Destination.Upgrade)
        }
        DrawerItem(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Magenta),
            label = Destination.Settings.path
        ) {
            onNavigationSelected(Destination.Settings)
        }
        DrawerItem(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Magenta),
            label = stringResource(R.string.log_out)
        ) {
            onLogout()
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerContentPreview() {
    HomeScreenTheme {
        Column {
            DrawerContent(onNavigationSelected = {},
                onLogout = {}
            )
        }
    }
}