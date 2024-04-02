package com.gmail.devpelegrino.userprofilesample.ui.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gmail.devpelegrino.userprofilesample.R
import com.gmail.devpelegrino.userprofilesample.common.PreviewScreen
import com.gmail.devpelegrino.userprofilesample.ui.theme.UserProfileSampleTheme
import com.gmail.devpelegrino.userprofilesample.ui.theme.pumpingSpice

@Composable
fun EditScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        IconButton(
            onClick = { onBackClick() },
            modifier = Modifier
                .padding(top = 24.dp, start = 24.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                tint = pumpingSpice,
                contentDescription = stringResource(R.string.go_back_description),
                modifier = Modifier.size(28.dp)
            )
        }
        Text(
            text = stringResource(R.string.button_edit),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 24.dp, start = 36.dp)
        )
    }
}

@PreviewScreen
@Composable
private fun EditScreenPreview() {
    UserProfileSampleTheme {
        EditScreen(
            onBackClick = {}
        )
    }
}