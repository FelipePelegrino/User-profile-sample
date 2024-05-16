package com.gmail.devpelegrino.userprofilesample.ui.edit

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gmail.devpelegrino.userprofilesample.R
import com.gmail.devpelegrino.userprofilesample.common.PreviewScreen
import com.gmail.devpelegrino.userprofilesample.ui.common.BasicTextField
import com.gmail.devpelegrino.userprofilesample.ui.common.BasicTextFieldState
import com.gmail.devpelegrino.userprofilesample.ui.common.DateVisualTransformation
import com.gmail.devpelegrino.userprofilesample.ui.common.MAX_LENGTH_BIRTHDAY
import com.gmail.devpelegrino.userprofilesample.ui.common.MAX_LENGTH_DEFAULT
import com.gmail.devpelegrino.userprofilesample.ui.common.MAX_LENGTH_EXPERIENCE
import com.gmail.devpelegrino.userprofilesample.ui.common.MAX_LENGTH_PHONE
import com.gmail.devpelegrino.userprofilesample.ui.common.MIN_LENGTH_NAME
import com.gmail.devpelegrino.userprofilesample.ui.common.MIN_LENGTH_PHONE
import com.gmail.devpelegrino.userprofilesample.ui.common.PhoneVisualTransformation
import com.gmail.devpelegrino.userprofilesample.ui.common.defaultKeyboardOptions
import com.gmail.devpelegrino.userprofilesample.ui.common.emailKeyboardOptions
import com.gmail.devpelegrino.userprofilesample.ui.common.isValidBirthday
import com.gmail.devpelegrino.userprofilesample.ui.common.isValidEmail
import com.gmail.devpelegrino.userprofilesample.ui.common.nameKeyboardOptions
import com.gmail.devpelegrino.userprofilesample.ui.common.numberKeyboardOptions
import com.gmail.devpelegrino.userprofilesample.ui.common.phoneKeyboardOptions
import com.gmail.devpelegrino.userprofilesample.ui.theme.UserProfileSampleTheme
import com.gmail.devpelegrino.userprofilesample.ui.theme.bunker
import com.gmail.devpelegrino.userprofilesample.ui.theme.pumpingSpice

@Composable
fun EditScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    //TODO: create editScreenViewModel
    val context = LocalContext.current
    val nameState by remember {
        mutableStateOf(BasicTextFieldState(
            initialValue = "",
            maxLength = MAX_LENGTH_DEFAULT,
            validator = { s: String ->
                s.isNotEmpty() && s.length > MIN_LENGTH_NAME
            }
        ))
    }
    val emailState by remember {
        mutableStateOf(BasicTextFieldState(
            initialValue = "",
            maxLength = MAX_LENGTH_DEFAULT,
            validator = { s: String ->
                s.isNotEmpty() && isValidEmail(s)
            }
        ))
    }
    val roleState by remember {
        mutableStateOf(BasicTextFieldState(
            initialValue = "",
            maxLength = MAX_LENGTH_DEFAULT,
            validator = { _: String ->
                true
            }
        ))
    }
    val phoneState by remember {
        mutableStateOf(BasicTextFieldState(
            initialValue = "",
            maxLength = MAX_LENGTH_PHONE,
            validator = { s: String ->
                s.length > MIN_LENGTH_PHONE
            }
        ))
    }
    val birthdayState by remember {
        mutableStateOf(BasicTextFieldState(
            initialValue = "",
            maxLength = MAX_LENGTH_BIRTHDAY,
            validator = { s: String ->
                s.isNotEmpty() && isValidBirthday(s)
            }
        ))
    }
    val experienceState by remember {
        mutableStateOf(BasicTextFieldState(
            initialValue = "",
            maxLength = MAX_LENGTH_EXPERIENCE,
            validator = { s: String ->
                s.isNotEmpty()
            }
        ))
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        IconButton(
            onClick = { onBackClick() },
            modifier = Modifier
                .padding(top = 24.dp, start = 24.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                tint = pumpingSpice,
                contentDescription = stringResource(R.string.description_go_back),
                modifier = Modifier.size(28.dp)
            )
        }

        Text(
            text = stringResource(R.string.button_edit),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 24.dp, start = 36.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 36.dp, top = 20.dp)
                .clickable {
                    //TODO: buscar imagem na galeria/camera
                    Toast
                        .makeText(context, "Teste click row", Toast.LENGTH_SHORT)
                        .show()
                }
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(color = bunker, shape = RoundedCornerShape(80.dp))
                    .size(120.dp)
            ) {
                Image(
                    imageVector = Icons.Default.Person,
                    colorFilter = ColorFilter.tint(Color.Gray),
                    contentDescription = null,
                    modifier = Modifier
                        .size(72.dp)
                )
            }
            Text(
                style = MaterialTheme.typography.headlineSmall,
                text = stringResource(R.string.text_profile_image),
                color = pumpingSpice,
                modifier = Modifier.padding(16.dp)
            )
        }

        BasicTextField(
            textFieldName = stringResource(R.string.field_name),
            state = nameState,
            placeholder = {
                if (nameState.text.isBlank()) {
                    Text(text = stringResource(R.string.placeholder_name), color = Color.Gray)
                }
            },
            errorText = stringResource(R.string.error_name_message),
            keyboardOptions = nameKeyboardOptions,
            modifier = Modifier.padding(start = 36.dp, top = 24.dp, end = 36.dp)
        )

        BasicTextField(
            textFieldName = stringResource(R.string.field_email),
            state = emailState,
            placeholder = {
                if (emailState.text.isBlank()) {
                    Text(text = stringResource(R.string.placeholder_email), color = Color.Gray)
                }
            },
            errorText = stringResource(R.string.error_email_message),
            keyboardOptions = emailKeyboardOptions,
            modifier = Modifier.padding(start = 36.dp, top = 24.dp, end = 36.dp)
        )

        BasicTextField(
            textFieldName = stringResource(R.string.field_role),
            state = roleState,
            placeholder = {
                if (roleState.text.isBlank()) {
                    Text(text = stringResource(R.string.placeholder_role), color = Color.Gray)
                }
            },
            keyboardOptions = defaultKeyboardOptions,
            modifier = Modifier.padding(start = 36.dp, top = 24.dp, end = 36.dp)
        )

        BasicTextField(
            textFieldName = stringResource(R.string.field_phone),
            state = phoneState,
            placeholder = {
                if (phoneState.text.isBlank()) {
                    Text(text = stringResource(R.string.placeholder_phone), color = Color.Gray)
                }
            },
            errorText = stringResource(id = R.string.error_phone_message),
            keyboardOptions = phoneKeyboardOptions,
            visualTransformation = PhoneVisualTransformation(),
            modifier = Modifier.padding(start = 36.dp, top = 24.dp, end = 36.dp)
        )

        BasicTextField(
            textFieldName = stringResource(R.string.field_birthday),
            state = birthdayState,
            placeholder = {
                if (birthdayState.text.isBlank()) {
                    Text(text = stringResource(R.string.placeholder_birthday), color = Color.Gray)
                }
            },
            errorText = stringResource(id = R.string.error_birthday_message),
            keyboardOptions = numberKeyboardOptions.copy(
                imeAction = ImeAction.Next
            ),
            visualTransformation = DateVisualTransformation(),
            modifier = Modifier.padding(start = 36.dp, top = 24.dp, end = 36.dp)
        )

        BasicTextField(
            textFieldName = stringResource(R.string.field_experience),
            state = experienceState,
            placeholder = {
                if (experienceState.text.isBlank()) {
                    Text(text = stringResource(R.string.placeholder_experience), color = Color.Gray)
                }
            },
            errorText = stringResource(id = R.string.error_experience_message),
            keyboardOptions = numberKeyboardOptions.copy(
                imeAction = ImeAction.Done
            ),
            onImeAction = {
                          //TODO:
//                viewModel.save()
            },
            modifier = Modifier.padding(start = 36.dp, top = 24.dp, end = 36.dp)
        )

        Button(
            onClick = {
                /*
                * TODO: add saving animation
                *  success animation
                *  error animation
                * */
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = pumpingSpice,
                contentColor = Color.White
            ),
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .heightIn(min = 120.dp)
                .fillMaxWidth()
                .padding(bottom = 24.dp, top = 36.dp, start = 36.dp, end = 36.dp)
        ) {
            Text(text = stringResource(id = R.string.button_save), fontSize = 20.sp)
        }
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