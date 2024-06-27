package dev.artenes.uidesigns.app.mortgage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.CurrencyPound
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.artenes.uidesigns.R

@Preview
@Composable
fun MortgageScreen() {

    val scrollState = rememberScrollState()

    var amount by remember {
        mutableStateOf("")
    }
    var term by remember {
        mutableStateOf("")
    }
    var rate by remember {
        mutableStateOf("")
    }
    var type by remember {
        mutableIntStateOf(-1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {

        Text(
            text = "Mortgage Calculator",
            color = Color(0xff133040),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 30.dp, start = 25.dp)
        )

        Text(
            text = "Clear All",
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .padding(top = 5.dp, start = 25.dp)
                .clickable {
                    amount = ""
                    term = ""
                    rate = ""
                    type = -1
                },
            color = Color(0xff56636b)
        )

        Text(
            text = "Mortgage Amount",
            modifier = Modifier.padding(start = 25.dp, top = 25.dp),
            color = Color(0xff56636b),
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                .fillMaxWidth(),
            value = amount,
            onValueChange = { amount = it },
            leadingIcon = {
                Icon(
                    modifier = Modifier
                        .background(Color(0xffe3f4fe))
                        .padding(10.dp)
                        .padding(vertical = 4.dp),
                    imageVector = Icons.Filled.CurrencyPound,
                    contentDescription = null,
                    tint = Color(0xff133040)
                )
            }
        )

        Text(
            text = "Mortgage Term",
            modifier = Modifier.padding(start = 25.dp, top = 25.dp),
            color = Color(0xff56636b),
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                .fillMaxWidth(),
            value = term,
            onValueChange = { term = it },
            trailingIcon = {
                Box(
                    modifier = Modifier
                        .background(Color(0xffe3f4fe))
                        .padding(vertical = 15.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "years",
                        color = Color(0xff133040),
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        )

        Text(
            text = "Interest Rate",
            modifier = Modifier.padding(start = 25.dp, top = 25.dp),
            color = Color(0xff56636b),
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                .fillMaxWidth(),
            value = rate,
            onValueChange = { rate = it },
            trailingIcon = {
                Icon(
                    modifier = Modifier
                        .background(Color(0xffe3f4fe))
                        .padding(10.dp)
                        .padding(vertical = 4.dp),
                    imageVector = Icons.Filled.Percent,
                    contentDescription = null,
                    tint = Color(0xff133040)
                )
            }
        )

        Text(
            text = "Mortgage Type",
            modifier = Modifier.padding(start = 25.dp, top = 25.dp),
            color = Color(0xff56636b),
        )

        Row(
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .padding(top = 10.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFb5b2b8),
                    shape = RoundedCornerShape(5.dp)
                )
                .fillMaxWidth()
                .clickable { type = 1 },
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(selected = type == 1, onClick = { type = 1 })
            Text(
                text = "Repayment",
                fontWeight = FontWeight.Bold,
                color = Color(0xff133040)
            )
        }

        Row(
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .padding(top = 10.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFb5b2b8),
                    shape = RoundedCornerShape(5.dp)
                )
                .fillMaxWidth()
                .clickable { type = 2 },
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(selected = type == 2, onClick = { type = 2 })
            Text(
                text = "Interest Only",
                fontWeight = FontWeight.Bold,
                color = Color(0xff133040)
            )
        }

        Button(
            modifier = Modifier
                .padding(horizontal = 25.dp, vertical = 25.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xffdada33)
            ),
            onClick = { }
        ) {
            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Calculate,
                    contentDescription = null,
                    tint = Color(0xff133040),
                    modifier = Modifier.padding(end = 10.dp)
                )
                Text(
                    text = "Calculate Repayments",
                    color = Color(0xff133040),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Column(
            modifier = Modifier.background(Color(0xff133040))
        ) {

            Image(
                painter = painterResource(id = R.drawable.voice_call),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(top = 25.dp)
            )
            Text(
                text = "Results shown here",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Complete the form and click \"calculate repayments\" to see what your monthly repayments woudl be.",
                color = Color(0xff9dbacc),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(vertical = 20.dp),
                textAlign = TextAlign.Center
            )

        }

    }

}