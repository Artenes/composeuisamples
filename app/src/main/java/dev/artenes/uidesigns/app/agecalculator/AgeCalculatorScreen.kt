package dev.artenes.uidesigns.app.agecalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
private fun AgeCalculatorScreenPreview() {
    AgeCalculatorScreen()
}

//https://www.frontendmentor.io/challenges/age-calculator-app-dF9DFFpj-Q
@Composable
fun AgeCalculatorScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xfff0f0f0))
            .padding(top = 80.dp)
            .padding(horizontal = 20.dp)
    ) {

        Column(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 20.dp,
                        bottomEnd = 60.dp
                    )
                )
                .padding(top = 40.dp, bottom = 40.dp)
                .padding(horizontal = 30.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                DateInput(
                    label = "day",
                    value = "24"
                )

                DateInput(
                    label = "month",
                    value = "09"
                )

                DateInput(
                    label = "year",
                    value = "1984"
                )


            }

            DividerButton(
                modifier = Modifier.padding(top = 30.dp),
                onClick = {}
            )

            DateResult(
                value = "38",
                label = "years"
            )

            DateResult(
                value = "3",
                label = "months"
            )

            DateResult(
                value = "26",
                label = "days"
            )

        }

    }

}

@Composable
private fun DateInput(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
) {

    Column(
        modifier = modifier
    ) {

        Text(
            text = label.uppercase(),
            letterSpacing = 3.sp,
            fontSize = 12.sp,
            fontWeight = FontWeight.Black,
            color = Color(0xff7a7a7a),
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(top = 5.dp)
                .width(80.dp),
            value = value,
            onValueChange = {},
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedBorderColor = Color(0xff969696).copy(alpha = 0.5f),
                unfocusedBorderColor = Color(0xff969696).copy(alpha = 0.5f),
            ),
            textStyle = LocalTextStyle.current.copy(
                fontWeight = FontWeight.Black,
                fontSize = 18.sp
            )
        )

    }

}

@Composable
private fun DividerButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {

        HorizontalDivider()

        Box(
            modifier = Modifier
                .size(60.dp)
                .background(color = Color(0xff864cff), shape = CircleShape)
                .clickable(onClick = onClick),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = Icons.Filled.ArrowDownward,
                contentDescription = null,
                tint = Color.White
            )
        }


    }

}

@Composable
private fun DateResult(
    value: String,
    label: String
) {

    Row {
        Text(
            text = value,
            color = Color(0xff844dff),
            fontWeight = FontWeight.Black,
            fontSize = 60.sp,
            fontStyle = FontStyle.Italic
        )
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = label,
            fontWeight = FontWeight.Black,
            fontSize = 60.sp,
            fontStyle = FontStyle.Italic
        )
    }

}