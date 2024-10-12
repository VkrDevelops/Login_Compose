package com.vkr.simpleloginbywaqar.nav

import android.util.Log
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.vkr.simpleloginbywaqar.ui.dashboard.DashboardScreen
import com.vkr.simpleloginbywaqar.ui.login.LoginScreen

fun NavGraphBuilder.mainNavGraph(navController: NavController) {
    navigation(
        route = NavRoutes.Authenticated.MainRoot.route,
        startDestination = NavRoutes.Authenticated.Login.route
    ) {
        // Dashboard
        composable(
            route = NavRoutes.Authenticated.Dashboard.route,
            arguments = listOf(navArgument("username") { type = NavType.StringType })
        ) { backStack ->
            DashboardScreen(
                backStack.arguments?.getString("username")!!,
                onNavigateToAuthenticatedRoute = {
                    Log.d("waqar", "mainNavGraph: dashBoard CallBack")
                    navController.navigate(route = NavRoutes.Authenticated.Login.route) {
                        popUpTo(route = NavRoutes.Authenticated.Dashboard.route) {
                            inclusive = true
                        }
                    }
                })
        }

        // Login
        composable(route = NavRoutes.Authenticated.Login.route) {
            LoginScreen { username ->
                navController.navigate(
                    route = NavRoutes.Authenticated.Dashboard.route.replace("{username}", username)
                ) {
                    popUpTo(route = NavRoutes.Authenticated.Login.route) {
                        inclusive = false
                    }
                }
            }
        }
    }
}