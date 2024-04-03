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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gmail.devpelegrino.userprofilesample.R
import com.gmail.devpelegrino.userprofilesample.common.PreviewScreen
import com.gmail.devpelegrino.userprofilesample.ui.profile.UserProfileBasicTextField
import com.gmail.devpelegrino.userprofilesample.ui.profile.defaultKeyboardOptions
import com.gmail.devpelegrino.userprofilesample.ui.profile.nameKeyboardOptions
import com.gmail.devpelegrino.userprofilesample.ui.theme.UserProfileSampleTheme
import com.gmail.devpelegrino.userprofilesample.ui.theme.bunker
import com.gmail.devpelegrino.userprofilesample.ui.theme.pumpingSpice

@Composable
fun EditScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var role by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var birthday by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(bottom = 16.dp)
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

        UserProfileBasicTextField(
            textFieldName = stringResource(R.string.field_name),
            text = name,
            onTextChange = {
                name = it
            },
            placeholder = {
                if (name.isBlank()) {
                    Text(text = stringResource(R.string.placeholder_name), color = Color.Gray)
                }
            },
            keyboardOptions = nameKeyboardOptions,
            modifier = Modifier.padding(start = 36.dp, top = 36.dp, end = 36.dp)
        )

        UserProfileBasicTextField(
            textFieldName = stringResource(R.string.field_email),
            text = email,
            onTextChange = {
                email = it
            },
            placeholder = {
                if (email.isBlank()) {
                    Text(text = stringResource(R.string.placeholder_email), color = Color.Gray)
                }
            },
            keyboardOptions = defaultKeyboardOptions,
            modifier = Modifier.padding(start = 36.dp, top = 24.dp, end = 36.dp)
        )

        UserProfileBasicTextField(
            textFieldName = stringResource(R.string.field_role),
            text = role,
            onTextChange = {
                role = it
            },
            placeholder = {
                if (role.isBlank()) {
                    Text(text = stringResource(R.string.placeholder_role), color = Color.Gray)
                }
            },
            keyboardOptions = defaultKeyboardOptions,
            modifier = Modifier.padding(start = 36.dp, top = 24.dp, end = 36.dp)
        )

        UserProfileBasicTextField(
            textFieldName = stringResource(R.string.field_phone),
            text = phone,
            onTextChange = {
                phone = it
            },
            placeholder = {
                if (phone.isBlank()) {
                    Text(text = stringResource(R.string.placeholder_phone), color = Color.Gray)
                }
            },
            keyboardOptions = defaultKeyboardOptions,
            modifier = Modifier.padding(start = 36.dp, top = 24.dp, end = 36.dp)
        )

        UserProfileBasicTextField(
            textFieldName = stringResource(R.string.field_birthday),
            text = birthday,
            onTextChange = {
                birthday = it
            },
            placeholder = {
                if (birthday.isBlank()) {
                    Text(text = stringResource(R.string.placeholder_birthday), color = Color.Gray)
                }
            },
            keyboardOptions = defaultKeyboardOptions,
            modifier = Modifier.padding(start = 36.dp, top = 24.dp, end = 36.dp)
        )

        UserProfileBasicTextField(
            textFieldName = stringResource(R.string.field_experience),
            text = experience,
            onTextChange = {
                experience = it
            },
            placeholder = {
                if (experience.isBlank()) {
                    Text(text = stringResource(R.string.placeholder_experience), color = Color.Gray)
                }
            },
            keyboardOptions = defaultKeyboardOptions,
            modifier = Modifier.padding(start = 36.dp, top = 24.dp, end = 36.dp)
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