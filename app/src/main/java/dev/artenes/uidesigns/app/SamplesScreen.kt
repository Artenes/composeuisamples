package dev.artenes.uidesigns.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun SamplesScreenPreview() {

    SamplesScreen {

    }

}

@Composable
fun SamplesScreen(navigateTo: (String) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        SampleButton(
            navigateTo,
            route = "mortgage",
            label = "Mortgage sample"
        )

        SampleButton(
            navigateTo,
            route = "dashboard",
            label = "Dashboard sample"
        )

        SampleButton(
            navigateTo,
            route = "signin",
            label = "SignIn sample"
        )

        SampleButton(
            navigateTo,
            route = "signup",
            label = "SignUp sample"
        )

        SampleButton(
            navigateTo,
            route = "crypto",
            label = "Crypto sample"
        )

        SampleButton(
            navigateTo,
            route = "age",
            label = "Age Calculator sample"
        )

    }

}

@Composable
private fun SampleButton(
    navigateTo: (String) -> Unit,
    route: String,
    label: String
) {

    Button(
        onClick = { navigateTo(route) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .padding(top = 24.dp)
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = label,
            fontWeight = FontWeight.Bold
        )
    }

}