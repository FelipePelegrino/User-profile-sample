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
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
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
fun BasicTextField(
    textFieldName: String,
    state: BasicTextFieldState,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
    errorText: String = "Error occurred at $textFieldName",
    onImeAction: () -> Unit = {},
    placeholder: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    Column(modifier = modifier.onFocusChanged { focusState ->
        state.onFocusChange(focusState.isFocused)
        if (!focusState.isFocused) {
            state.enableShowErrors()
        }
    }) {
        Text(
            text = textFieldName.uppercase(),
            color = if (state.showErrors()) Color.Red else Color.Gray,
            style = MaterialTheme.typography.labelMedium
        )
        OutlinedTextField(
            value = state.text,
            isError = state.showErrors(),
            onValueChange = state.onTextChanged,
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
        if (state.showErrors()) {
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
private fun BasicTextFieldPreview() {
    val testState by remember {
        mutableStateOf(BasicTextFieldState(
            initialValue = "",
            maxLength = 10,
            validator = { s: String ->
                s.isNotEmpty() && s.length > 2
            }
        ))
    }
    UserProfileSampleTheme {
        BasicTextField(
            textFieldName = "Test",
            state = testState,
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

fun isValidEmail(email: String): Boolean {
    val emailRegex = Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})")
    return emailRegex.matches(email)
}

fun isValidBirthday(birthday: String): Boolean {
    val birthdayRegex = Regex("""^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[0-2])\d{4}$""")
    return birthdayRegex.matches(birthday)
}