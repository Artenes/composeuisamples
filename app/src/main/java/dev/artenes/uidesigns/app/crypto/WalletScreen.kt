package dev.artenes.uidesigns.app.crypto

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.artenes.uidesigns.R

private data class Position(
    val icon: Int,
    val name: String,
    val price: String,
    val variation: String,
    val amount: String,
    val rate: String
)

private val positions = listOf(
    Position(
        icon = R.drawable.bitcoin,
        name = "Bitcoin",
        price = "$27,130",
        variation = "+2,35%",
        amount = "0.1912343BTC",
        rate = "$3,124.22"
    ),
    Position(
        icon = R.drawable.etherium,
        name = "Etherium",
        price = "$45,325",
        variation = "-1.23%",
        amount = "0.232452ETH",
        rate = "$2,134.34"
    ),
    Position(
        icon = R.drawable.trox,
        name = "Tron",
        price = "$12,230",
        variation = "+0,35%",
        amount = "0.54221TROX",
        rate = "$1,138.99"
    ),
    Position(
        icon = R.drawable.trox,
        name = "Tron",
        price = "$12,230",
        variation = "+0,35%",
        amount = "0.54221TROX",
        rate = "$1,138.99"
    ),
    Position(
        icon = R.drawable.etherium,
        name = "Etherium",
        price = "$45,325",
        variation = "-1.23%",
        amount = "0.232452ETH",
        rate = "$2,134.34"
    ),
)

@Preview
@Composable
private fun WalletScreenPreview() {

    WalletScreen()

}

@Composable
fun WalletScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff171e2f))
            .padding(horizontal = 10.dp)
            .padding(top = 30.dp)
    ) {

        SearchBar()

        Text(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth(),
            text = "Total balance",
            fontSize = 20.sp,
            color = Color(0xff5a5f70),
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            fontSize = 40.sp,
            text = "$18,548.12",
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {

            Action(
                icon = R.drawable.add,
                label = "Buy",
                modifier = Modifier.weight(0.2f)
            )

            Action(
                icon = R.drawable.minus,
                label = "Sell",
                modifier = Modifier.weight(0.2f)
            )

            Action(
                icon = R.drawable.swap,
                label = "Swap",
                modifier = Modifier.weight(0.2f)
            )

            Action(
                icon = R.drawable.deposit,
                label = "Deposit",
                modifier = Modifier.weight(0.2f)
            )

            Action(
                icon = R.drawable.withdraw,
                label = "Withdraw",
                modifier = Modifier.weight(0.2f)
            )

        }

        LazyColumn(
            modifier = Modifier.padding(top = 40.dp)
        ) {

            items(
                count = positions.size,
                key = { index -> index }
            ) { index ->

                val position = positions[index]

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp)
                        .background(
                            color = Color(0xff272d3a),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        modifier = Modifier.padding(end = 10.dp),
                        painter = painterResource(id = position.icon),
                        contentDescription = null
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Text(
                                modifier = Modifier.weight(1f),
                                text = position.name,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = position.amount,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )

                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 5.dp)
                        ) {

                            Text(
                                modifier = Modifier.padding(end = 10.dp),
                                text = position.price,
                                color = Color.White
                            )

                            Text(
                                modifier = Modifier.weight(1f),
                                text = position.variation,
                                color = if (position.variation.startsWith("+")) Color(0xff6e9b7d) else Color(
                                    0xff7b2122
                                )
                            )

                            Text(
                                text = position.rate,
                                color = Color.White
                            )

                        }

                    }

                }

            }

        }

    }

}

@Composable
private fun SearchBar() {

    var search by remember {
        mutableStateOf("")
    }

    Row {

        IconButton(
            onClick = { },
            modifier = Modifier.padding(5.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.bell),
                contentDescription = null,
                tint = Color.White
            )
        }

        TextField(
            modifier = Modifier.weight(1f),
            value = search,
            onValueChange = { search = it },
            placeholder = {
                Text(
                    text = "Search anything",
                    color = Color(0xff555c6a)
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = null,
                    tint = Color.White
                )
            },
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xff2e3441),
                focusedContainerColor = Color(0xff2e3441),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White
            )
        )

        IconButton(
            modifier = Modifier.padding(5.dp),
            onClick = { }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = null,
                tint = Color.White
            )
        }

    }

}

@Composable
private fun Action(
    modifier: Modifier = Modifier,
    icon: Int,
    label: String
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Box(
            modifier = Modifier
                .background(
                    color = Color(0xff5e75ea),
                    shape = CircleShape
                )
                .size(60.dp),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
            )

        }

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = label,
            color = Color.White
        )

    }

}