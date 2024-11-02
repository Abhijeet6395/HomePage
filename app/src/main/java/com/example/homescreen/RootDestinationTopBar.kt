package com.example.homescreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootDestinationTopBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    openDrawer: () -> Unit,
    showSnackBar: (message: String) -> Unit
) {
    val snackBarMessage= stringResource(R.string.not_available_yet)
    TopAppBar(
        modifier = modifier,
        title = { Text(text = Destination.Home.title) },
        navigationIcon = {
            IconButton(onClick = {
                openDrawer()
            }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(R.string.cd_open_menu)
                )
            }
        },
        actions = {
            if (currentDestination != Destination.Feed) {
                IconButton(onClick = {
                    showSnackBar(snackBarMessage)
                }) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = stringResource(R.string.cd_more_information)
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Blue)
    )
}