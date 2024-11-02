package com.example.homescreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(val path: String, val icon: ImageVector? = null, val title: String,val isRootDestination: Boolean = true) {
    data object Home : Destination("home", title = "Home")
    data object Feed : Destination("feed", Icons.Default.List, title = "Feed")
    data object Contacts : Destination("contacts", Icons.Default.Person, title = "Contacts")
    data object Calendar : Destination("calendar", Icons.Default.DateRange, title = "Calendar")
    data object Settings:Destination("settings", Icons.Default.Settings,title = "Settings", isRootDestination = false)
    data object Upgrade:Destination("upgrade",Icons.Default.Warning, title = "Upgrade",isRootDestination = false)

    companion object{
        fun fromString(route: String?): Destination{
            return when(route) {
                Feed.path -> Feed
                Contacts.path -> Contacts
                Calendar.path -> Calendar
                Settings.path -> Settings
                Upgrade.path -> Upgrade

                else->Home
            }
        }
    }
}