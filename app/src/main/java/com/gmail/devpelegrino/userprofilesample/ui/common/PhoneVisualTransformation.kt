package com.gmail.devpelegrino.userprofilesample.ui.common

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class PhoneVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val phoneMask = text.text.mapIndexed { index, c ->
            when (index) {
                0 -> "($c"
                1 -> "$c) "
                6 -> "$c-"
                else -> c
            }
        }.joinToString(separator = "")

        return TransformedText(
            text = AnnotatedString(phoneMask),
            offsetMapping = PhoneOffsetMapping
        )
    }

    object PhoneOffsetMapping : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when {
                offset > 6 -> offset + 4
                offset > 1 -> offset + 3
                offset > 0 -> offset + 1
                else -> offset
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when {
                offset > 6 -> offset - 4
                offset > 1 -> offset - 2
                else -> offset
            }
        }
    }
}
