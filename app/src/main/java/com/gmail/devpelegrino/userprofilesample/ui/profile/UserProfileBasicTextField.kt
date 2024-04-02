package com.gmail.devpelegrino.userprofilesample.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gmail.devpelegrino.userprofilesample.ui.theme.UserProfileSampleTheme
import com.gmail.devpelegrino.userprofilesample.ui.theme.bunker

@Composable
fun UserProfileBasicTextField(
    textFieldName: String,
    text: String,
    keyboardOptions: KeyboardOptions,
    onTextChange: (text: String) -> Unit,
    modifier: Modifier = Modifier,
    placeHolder: @Composable (() -> Unit)? = null
) {
    Column(modifier = modifier) {
        Text(
            text = textFieldName.uppercase(),
            color = Color.Gray,
            style = MaterialTheme.typography.labelMedium
        )
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            placeholder = {
                if (placeHolder != null) {
                    placeHolder()
                }
            },
            keyboardOptions = keyboardOptions,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = bunker,
                unfocusedContainerColor = bunker,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            textStyle = MaterialTheme.typography.bodyMedium,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
    }
}

@Preview
@Composable
private fun UserProfileBasicTextFieldPreview() {
    var text by remember { mutableStateOf("") }
    UserProfileSampleTheme {
        UserProfileBasicTextField(
            textFieldName = "Test",
            text = text,
            onTextChange = {
                text = it
            },
            placeHolder = {
                Text(text = "Test")
            },
            keyboardOptions = defaultKeyboardOptions
        )
    }
}

val nameKeyboardOptions = KeyboardOptions(
    keyboardType = KeyboardType.Text,
    capitalization = KeyboardCapitalization.Words
)

val defaultKeyboardOptions = KeyboardOptions(
    keyboardType = KeyboardType.Text,
    capitalization = KeyboardCapitalization.Sentences
)