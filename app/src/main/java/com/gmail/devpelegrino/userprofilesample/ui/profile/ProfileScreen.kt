package com.gmail.devpelegrino.userprofilesample.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.gmail.devpelegrino.userprofilesample.ui.theme.md_theme_dark_primaryContainer
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun ProfileScreen(
    onEditClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = md_theme_dark_primaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onEditClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 36.dp)
        ) {
            Text(text = "Edit")
        }
        Text(
            text = LoremIpsum(
                Random.nextInt(1..10)
            ).values.joinToString(),
            modifier = Modifier.padding(8.dp)
        )
    }
}