package dev.artenes.uidesigns.app.dashboard

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.artenes.uidesigns.app.SamplesScreen
import dev.artenes.uidesigns.app.mortgage.MortgageScreen

@Composable
fun MainNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "samples") {

        composable("samples") {

            SamplesScreen {
                navController.navigate(it)
            }

        }

        composable("mortgage") {

            MortgageScreen()

        }

        composable("dashboard") {

            DashboardScreen(
                goToLogIn = {
                    navController.navigate("signin")
                }
            )

        }

        composable("signin") {

            SignInScreen(
                goToDashboard = {
                    navController.navigate("dashboard")
                },
                goToSignUp = {
                    navController.navigate("signup")
                }
            )

        }

        composable("signup") {

            SignUpScreen(
                goToDashboard = {
                    navController.navigate("dashboard")
                },
                goToSignIn = {
                    navController.navigate("signin")
                }
            )

        }

    }
}
