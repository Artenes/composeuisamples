package dev.artenes.uidesigns.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "signin") {

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
