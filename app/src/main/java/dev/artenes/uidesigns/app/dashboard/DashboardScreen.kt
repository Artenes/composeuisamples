package dev.artenes.uidesigns.app.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import dev.artenes.uidesigns.R

@Preview
@Composable
private fun DashboardScreenPreview() {

    DashboardScreen(
        goToLogIn = {}
    )

}

@Composable
fun DashboardScreen(
    goToLogIn: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFF8EEEC)
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ConstraintLayout {

            val (topImg, profile, logout) = createRefs()

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(245.dp)
                .constrainAs(topImg) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFEA6D35),
                            Color(0xFF3B608C)
                        )
                    ),
                    shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)
                )
            )

            IconButton(
                onClick = goToLogIn,
                modifier = Modifier
                    .constrainAs(logout) {
                        end.linkTo(parent.end)
                    }
                    .padding(top = 10.dp, end = 10.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Logout,
                    contentDescription = null,
                    tint = Color.White,
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 70.dp)
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier
                        .height(100.dp)
                        .padding(start = 14.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Hello",
                        color = Color.White,
                        fontSize = 18.sp
                    )

                    Text(
                        text = "David Friedman",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 14.dp)
                    )

                }
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clickable { }
                )

            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(20.dp))
                    .background(color = Color.White, shape = RoundedCornerShape(20.dp))
                    .constrainAs(profile) {
                        top.linkTo(topImg.bottom)
                        bottom.linkTo(topImg.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {

                ActionButton(
                    icon = R.drawable.video_call,
                    label = "Video call"
                )

                ActionButton(
                    icon = R.drawable.notification,
                    label = "Notification"
                )

                ActionButton(
                    icon = R.drawable.voice_call,
                    label = "Voice call"
                )

            }

        }

        var text by rememberSaveable {
            mutableStateOf("")
        }
        TextField(
            value = text,
            onValueChange = { newValue ->
                text = newValue
            },
            label = {
                Text(text = "Searching for...")
            },
            trailingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(43.dp)
                        .padding(end = 6.dp)
                )
            },
            shape = RoundedCornerShape(50.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedTextColor = Color(0xFF5E5E5E),
                unfocusedLabelColor = Color(0XFF5E5E5E)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .padding(horizontal = 24.dp)
                .shadow(3.dp, shape = RoundedCornerShape(50.dp))
                .background(Color.White)
        )

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .padding(horizontal = 24.dp)
                .shadow(3.dp, shape = RoundedCornerShape(25.dp))
                .height(145.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0XFF4C6184),
                            Color(0XFFF9C177)
                        )
                    )
                )
        ) {

            val (img, text1, text2) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.constrainAs(img) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
            )

            Text(
                text = "To Get Unlimited",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .constrainAs(text1) {
                        top.linkTo(parent.top)
                        end.linkTo(img.start)
                        start.linkTo(parent.start)
                    }
            )

            Text(
                text = "Upgrade Your Account",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .constrainAs(text2) {
                        top.linkTo(text1.bottom)
                        end.linkTo(text1.end)
                        start.linkTo(text1.start)
                    }
            )

        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 24.dp)
        ) {

            LinkButton(
                modifier = Modifier.weight(0.25f),
                icon = R.drawable.ic_1,
                label = "Inbox"
            )

            LinkButton(
                modifier = Modifier.weight(0.25f),
                icon = R.drawable.ic_2,
                label = "Maps"
            )

            LinkButton(
                modifier = Modifier.weight(0.25f),
                icon = R.drawable.ic_3,
                label = "Chats"
            )

            LinkButton(
                modifier = Modifier.weight(0.25f),
                icon = R.drawable.ic_4,
                label = "Reports"
            )

        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 24.dp)
        ) {

            LinkButton(
                modifier = Modifier.weight(0.25f),
                icon = R.drawable.ic_5,
                label = "Calendar"
            )

            LinkButton(
                modifier = Modifier.weight(0.25f),
                icon = R.drawable.ic_6,
                label = "Tips"
            )

            LinkButton(
                modifier = Modifier.weight(0.25f),
                icon = R.drawable.ic_7,
                label = "Settings"
            )

            LinkButton(
                modifier = Modifier.weight(0.25f),
                imageModifier = Modifier.padding(vertical = 16.dp),
                icon = R.drawable.ic_8,
                label = "More"
            )

        }

    }

}

@Composable
fun ActionButton(
    icon: Int,
    label: String
) {

    Column(
        modifier = Modifier
            .padding(top = 12.dp, bottom = 12.dp, end = 8.dp, start = 8.dp)
            .size(90.dp)
            .background(
                color = Color(0XFFFFE0C8),
                shape = RoundedCornerShape(20.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
        )

        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            color = Color(0XFFC77710)
        )

    }

}

@Composable
fun LinkButton(
    modifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier,
    icon: Int,
    label: String
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 4.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(16.dp)
                .then(imageModifier)
        )

        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp),
            color = Color(0xFF2E3D6D)
        )

    }

}