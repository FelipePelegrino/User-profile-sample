package com.gmail.devpelegrino.userprofilesample.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gmail.devpelegrino.userprofilesample.ui.theme.UserProfileSampleTheme
import com.gmail.devpelegrino.userprofilesample.ui.theme.bunker

@Composable
fun UserProfileBasicTextField(
    textFieldName: String,
    text: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    errorText: String = "Error occurred at $textFieldName",
    onImeAction: () -> Unit = {},
    onTextChange: (text: String) -> Unit,
    placeholder: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    Column(modifier = modifier) {
        Text(
            text = textFieldName.uppercase(),
            color = if (isError) Color.Red else Color.Gray,
            style = MaterialTheme.typography.labelMedium
        )
        OutlinedTextField(
            value = text,
            isError = isError,
            onValueChange = onTextChange,
            placeholder = {
                if (placeholder != null) {
                    placeholder()
                }
            },
            keyboardOptions = keyboardOptions,
            keyboardActions = KeyboardActions(
                onDone = {
                    onImeAction()
                }
            ),
            visualTransformation = visualTransformation,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = bunker,
                unfocusedContainerColor = bunker,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                errorCursorColor = Color.Red,
                errorIndicatorColor = Color.Red,
                errorContainerColor = bunker
            ),
            textStyle = MaterialTheme.typography.bodyMedium,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
        if (isError) {
            Text(
                text = errorText,
                color = Color.Red,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 4.dp)
            )
        }
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
            placeholder = {
                Text(text = "Test")
            },
            keyboardOptions = defaultKeyboardOptions
        )
    }
}

val defaultKeyboardOptions = KeyboardOptions(
    keyboardType = KeyboardType.Text,
    capitalization = KeyboardCapitalization.Sentences,
    imeAction = ImeAction.Next
)

val nameKeyboardOptions = KeyboardOptions(
    keyboardType = KeyboardType.Text,
    capitalization = KeyboardCapitalization.Words,
    imeAction = ImeAction.Next
)

val emailKeyboardOptions = KeyboardOptions(
    keyboardType = KeyboardType.Email,
    capitalization = KeyboardCapitalization.None,
    imeAction = ImeAction.Next
)

val phoneKeyboardOptions = KeyboardOptions(
    keyboardType = KeyboardType.Number,
    capitalization = KeyboardCapitalization.None,
    imeAction = ImeAction.Next
)

val numberKeyboardOptions = KeyboardOptions(
    keyboardType = KeyboardType.Number,
    capitalization = KeyboardCapitalization.None
)

//TODO:
fun isValidEmail(email: String): Boolean {
    val emailRegex = Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})")
    return emailRegex.matches(email)
}