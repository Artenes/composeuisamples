package dev.artenes.uidesigns.app.crypto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.artenes.uidesigns.R

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
            onClick = {  }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = null,
                tint = Color.White
            )
        }

    }

}