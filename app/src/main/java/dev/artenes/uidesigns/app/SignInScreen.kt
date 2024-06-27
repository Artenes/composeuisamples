package dev.artenes.uidesigns.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.artenes.uidesigns.R

@Preview
@Composable
fun SignInScreenPreview() {

    SignInScreen(
        goToSignUp = {},
        goToDashboard = {}
    )

}

@Composable
fun SignInScreen(
    goToDashboard: () -> Unit,
    goToSignUp: () -> Unit
) {

    var email by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0XFFF8EEEC))
    ) {

        Image(
            painter = painterResource(id = R.drawable.top_background1),
            contentDescription = null,
        )

        Text(
            text = "Welcome",
            color = Color(0XFFEa6D35),
            modifier = Modifier.padding(start = 24.dp),
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = "Back",
            color = Color(0XFFEa6D35),
            modifier = Modifier.padding(start = 24.dp),
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold
        )

        LoginInput(
            value = email,
            onChange = { newValue -> email = newValue },
            icon = R.drawable.email,
            label = "Email"
        )

        LoginInput(
            value = password,
            onChange = { newValue -> password = newValue },
            icon = R.drawable.password,
            label = "Password",
            iconPadding = 6.dp,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Image(
            painter = painterResource(id = R.drawable.btn_arraw1),
            contentDescription = null,
            modifier = Modifier
                .width(80.dp)
                .padding(top = 24.dp)
                .align(Alignment.End)
                .padding(end = 24.dp)
                .clickable(onClick = goToDashboard)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .padding(horizontal = 24.dp)
        ) {

            LoginButton(
                modifier = Modifier.weight(0.5f),
                icon = R.drawable.google,
                label = "Google"
            )

            LoginButton(
                modifier = Modifier.weight(0.5f),
                icon = R.drawable.facebook,
                label = "Facebook"
            )

        }

        Text(
            text = "Are you a new user? Register",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .clickable(onClick = goToSignUp),
            textAlign = TextAlign.Center,
            color = Color(0XFF3B608C)
        )

    }

}