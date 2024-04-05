package com.gmail.devpelegrino.userprofilesample.ui.common

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class DateVisualTransformation : VisualTransformation {

    /*
    * 05042024
    * 05/04/2024
    * */

    override fun filter(text: AnnotatedString): TransformedText {
        val dateMask = text.text.mapIndexed { index, c ->
            when (index) {
                1 -> "$c/"
                3 -> "$c/"
                else -> c
            }
        }.joinToString(separator = "")

        return TransformedText(
            text = AnnotatedString(dateMask),
            offsetMapping = VisualOffsetMapping
        )
    }

    object VisualOffsetMapping : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when {
                offset > 3 -> offset + 2
                offset > 1 -> offset + 1
                else -> offset
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when {
                offset > 3 -> offset - 2
                offset > 1 -> offset - 1
                else -> offset
            }
        }
    }
}
