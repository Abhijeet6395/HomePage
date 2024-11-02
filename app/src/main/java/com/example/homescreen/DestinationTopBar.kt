package com.example.homescreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable

fun DestinationTopBar(
    modifier: Modifier = Modifier,
    destination: Destination,
    onNavigateUp: () -> Unit,
    onOpenDrawer: () -> Unit,
    showSnackBar:(message:String)-> Unit
){
    if (destination.isRootDestination) {
        RootDestinationTopBar(
            modifier,
            currentDestination = destination,
            openDrawer = onOpenDrawer,
            showSnackBar = showSnackBar,

            )
    }else{
        ChildDestinationTopBar(
            modifier,
            onNavigateUp,
            destination.title
        )
    }
}