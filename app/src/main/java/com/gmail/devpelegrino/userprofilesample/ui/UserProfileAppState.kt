package com.gmail.devpelegrino.userprofilesample.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gmail.devpelegrino.userprofilesample.ui.navigation.PROFILE_ROUTE
import com.gmail.devpelegrino.userprofilesample.ui.navigation.TopLevelDestination

@Composable
fun rememberUserProfileAppState(
    navController: NavHostController = rememberNavController(),
): UserProfileAppState {
    return remember(navController) {
        UserProfileAppState(
            navController = navController
        )
    }
}

@Stable
class UserProfileAppState(
    val navController: NavHostController,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            PROFILE_ROUTE -> TopLevelDestination.PROFILE
            else -> null
        }
}