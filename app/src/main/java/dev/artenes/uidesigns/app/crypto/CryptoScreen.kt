package dev.artenes.uidesigns.app.crypto

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.artenes.uidesigns.R

private sealed class Screen(val route: String, val icon: Int, val label: String) {

    data object Wallet : Screen("wallet", R.drawable.wallet, "Wallet")
    data object Market : Screen("market", R.drawable.market, "Market")
    data object Trade : Screen("trade", R.drawable.trade, "Trade")
    data object Futures : Screen("futures", R.drawable.futures, "Futures")
    data object Profile : Screen("profile", R.drawable.profile, "Profile")

}

private val screens = listOf(
    Screen.Wallet,
    Screen.Market,
    Screen.Trade,
    Screen.Futures,
    Screen.Profile,
)

@Preview
@Composable
fun CryptoScreenPreview() {

    CryptoScreen()

}

@Composable
fun CryptoScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { edges ->

        NavHost(
            navController = navController,
            modifier = Modifier.padding(edges),
            startDestination = Screen.Wallet.route
        ) {

            composable(Screen.Wallet.route) {
                WalletScreen()
            }

            composable(Screen.Market.route) {

            }

            composable(Screen.Trade.route) {

            }

            composable(Screen.Futures.route) {

            }

            composable(Screen.Profile.route) {

            }

        }
    }

}

@Composable
fun BottomNavigationBar(navController: NavController) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination

    NavigationBar(
        containerColor = Color(0xff171a1f)
    ) {

        screens.forEach { screen ->

            NavigationBarItem(
                icon = {
                    Image(
                        painter = painterResource(id = screen.icon),
                        contentDescription = null
                    )
                },
                label = { Text(text = screen.label) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )

        }

    }
}
