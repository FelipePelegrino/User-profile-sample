package com.gmail.devpelegrino.userprofilesample.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gmail.devpelegrino.userprofilesample.ui.navigation.UserProfileNavHost

@Composable
fun UserProfileApp(appState: UserProfileAppState) {
    Surface(
        tonalElevation = 0.dp,
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize(),
    ) {
        CompositionLocalProvider(LocalAbsoluteTonalElevation provides 0.dp) {
            Row(
                Modifier
                    .fillMaxSize()
                    .safeDrawingPadding()
            ) {
                UserProfileNavHost(
                    appState = appState
                )
            }
        }
    }
}