package com.example.homescreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

@Composable
fun Navigation(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destination.Home.path
    ) {
        navigation(
            startDestination = Destination.Feed.path,
            route = Destination.Home.path
        )
        {
            composable(route = Destination.Feed.path) {
                ContentArea(
                    modifier = Modifier.fillMaxSize(),
                    destination = Destination.Feed
                )
            }
            composable(route = Destination.Contacts.path) {
                ContentArea(
                    modifier = Modifier.fillMaxSize(),
                    destination = Destination.Contacts
                )
            }
            composable(route = Destination.Calendar.path) {
                ContentArea(
                    modifier = Modifier.fillMaxSize(),
                    destination = Destination.Calendar
                )
            }
            composable(route = Destination.Settings.path) {
                ContentArea(
                    modifier = Modifier.fillMaxSize(),
                    destination = Destination.Settings
                )
            }
            composable(route = Destination.Upgrade.path){
                ContentArea(
                    modifier = Modifier.fillMaxSize(),
                    destination = Destination.Upgrade
                )
            }
        }
    }
}