package com.gmail.devpelegrino.userprofilesample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gmail.devpelegrino.userprofilesample.ui.UserProfileAppState
import com.gmail.devpelegrino.userprofilesample.ui.profile.EditScreen
import com.gmail.devpelegrino.userprofilesample.ui.profile.ProfileScreen

const val PROFILE_ROUTE = "profile_route"
const val EDIT_PROFILE_ROUTE = "edit_profile_route"

@Composable
fun UserProfileNavHost(
    appState: UserProfileAppState,
    modifier: Modifier = Modifier,
    startDestination: String = PROFILE_ROUTE,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = PROFILE_ROUTE) {
            ProfileScreen(onEditClick = navController::navigateToEdit)
        }
        composable(route = EDIT_PROFILE_ROUTE) {
            EditScreen()
        }
    }
}

fun NavController.navigateToEdit(navOptions: NavOptions? = null) {
    navigate(EDIT_PROFILE_ROUTE, navOptions)
}