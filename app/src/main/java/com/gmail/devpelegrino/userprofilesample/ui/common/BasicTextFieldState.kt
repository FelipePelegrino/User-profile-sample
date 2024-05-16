package com.gmail.devpelegrino.userprofilesample.ui.common

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.setValue

// Baseado no jetSurveyApp
class BasicTextFieldState(
    initialValue: String,
    private val maxLength: Int,
    private val validator: (String) -> Boolean = { true }
) {
    var text: String by mutableStateOf(initialValue)
    internal var isFocusedAtLeastOneTime: Boolean by mutableStateOf(false)
    var isFocused: Boolean by mutableStateOf(false)
    var onTextChanged: (String) -> Unit = {
        if (it.length < maxLength) {
            text = it
        }
    }
    private var displayErrors: Boolean by mutableStateOf(false)

    private val isValid: Boolean
        get() = validator(text)

    fun onFocusChange(focused: Boolean) {
        isFocused = focused
        if (focused) isFocusedAtLeastOneTime = true
    }

    fun enableShowErrors() {
        if (isFocusedAtLeastOneTime) {
            displayErrors = true
        }
    }

    fun showErrors() = !isValid && displayErrors
}

fun textFieldStateSaver(state: BasicTextFieldState) = listSaver<BasicTextFieldState, Any>(
    save = { listOf(it.text, it.isFocusedAtLeastOneTime) },
    restore = {
        state.apply {
            text = it[0] as String
            isFocusedAtLeastOneTime = it[1] as Boolean
        }
    }
)
