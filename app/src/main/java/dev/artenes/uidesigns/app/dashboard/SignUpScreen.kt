package dev.artenes.uidesigns.app.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.artenes.uidesigns.R

@Preview
@Composable
private fun SignUpScreenPreview() {

    SignUpScreen(
        goToDashboard = {},
        goToSignIn = {}
    )

}

@Composable
fun SignUpScreen(
    goToDashboard: () -> Unit,
    goToSignIn: () -> Unit
) {

    var email by rememberSaveable {
        mutableStateOf("")
    }

    var name by rememberSaveable {
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
            contentDescription = null
        )

        Text(
            text = "Create",
            color = Color(0XFF3b608c),
            modifier = Modifier.padding(top = 16.dp, start = 24.dp),
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = "Account",
            color = Color(0XFF3b608c),
            modifier = Modifier.padding(start = 24.dp),
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold
        )

        LoginInput(
            value = name,
            onChange = { newValue -> name = newValue },
            icon = R.drawable.name,
            label = "Name"
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

        Text(
            text = "Already have an account? Log in",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .clickable(onClick = goToSignIn),
            textAlign = TextAlign.Center,
            color = Color(0XFF3B608C)
        )

    }

}

@Composable
fun LoginInput(
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    iconPadding: Dp = 3.dp,
    value: String,
    onChange: (String) -> Unit,
    icon: Int,
    label: String
) {

    TextField(
        value = value,
        onValueChange = onChange,
        leadingIcon = {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(43.dp)
                    .padding(start = 6.dp)
                    .padding(iconPadding)
            )
        },
        label = {
            Text(text = label)
        },
        keyboardOptions = keyboardOptions,
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            focusedTextColor = Color(0xFF5E5E5E),
            unfocusedLabelColor = Color(0XFF5E5E5E)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .padding(top = 16.dp)
            .background(color = Color.White, shape = CircleShape)
    )

}

@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    icon: Int,
    label: String
) {
    Button(
        onClick = { },
        modifier = Modifier
            .padding(vertical = 10.dp)
            .padding(end = 8.dp)
            .height(55.dp)
            .shadow(elevation = 1.dp, shape = RoundedCornerShape(10.dp))
            .then(modifier),
        border = BorderStroke(
            width = 1.dp,
            color = Color(0XFF4D4D4D)
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xfff8eeec)
        ),
        shape = RoundedCornerShape(10.dp),
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f),
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .width(25.dp)
                    .clickable { }
            )

        }

        Column(
            modifier = Modifier
                .padding(start = 14.dp)
                .weight(0.7f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = label,
                color = Color(0XFF2F4F86),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

        }

    }
}