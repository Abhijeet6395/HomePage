package com.example.homescreen


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.homescreen.ui.theme.HomeScreenTheme
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val snackBarHostState = remember { SnackbarHostState() }
    val snackBarMessage = stringResource(R.string.not_available_yet)
    val currentDestination by remember(navBackStackEntry) {
        derivedStateOf {
            navBackStackEntry.value?.destination?.route?.let {
                Destination.fromString(it)
            } ?: run {
                Destination.Home
            }
        }
    }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                modifier = Modifier.fillMaxWidth(),
                onNavigationSelected = { destination ->
                    navController.navigate(destination.path)
                    coroutineScope.launch {
                        drawerState.close()
                    }
                },
                onLogout = { }
            )
        }
    ) {
        Scaffold(
            modifier = modifier,
            topBar = {
                DestinationTopBar(
                    destination = currentDestination,
                    onNavigateUp = {
                        navController.popBackStack()
                    },
                    onOpenDrawer = {
                        coroutineScope.launch { drawerState.open() }
                    },
                    showSnackBar = { message ->
                        coroutineScope.launch {
                            snackBarHostState.showSnackbar(
                                message = message,
                                duration = SnackbarDuration.Short
                            )
                        }
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    //handle Click
                }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(R.string.cd_create_item)
                    )
                    //add content for my Fab
                }
            },
            bottomBar = {
                BottomNavigationBar(currentDestination = currentDestination,
                    onNavigate = {
                        navController.navigate(it) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    })
            }
        ) {
            Navigation(
                modifier = modifier,
                navController = navController
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreenTheme {
        Home()
    }
}