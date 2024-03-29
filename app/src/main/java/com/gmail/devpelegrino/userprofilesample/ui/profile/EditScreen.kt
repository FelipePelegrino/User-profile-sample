package com.gmail.devpelegrino.userprofilesample.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.gmail.devpelegrino.userprofilesample.ui.theme.md_theme_dark_secondaryContainer
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun EditScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = md_theme_dark_secondaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Edit")
        Text(
            text = LoremIpsum(
                Random.nextInt(1..100)
            ).values.joinToString(),
            modifier = Modifier.padding(8.dp)
        )
    }
}