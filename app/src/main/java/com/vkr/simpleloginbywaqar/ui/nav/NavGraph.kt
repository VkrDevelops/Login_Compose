package com.vkr.simpleloginbywaqar.ui.nav

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vkr.simpleloginbywaqar.ui.screens.dashboard.DashboardScreen
import com.vkr.simpleloginbywaqar.ui.screens.login.LoginScreen

fun NavGraphBuilder.mainNavGraph(navController: NavController) {
    navigation(
        route = NavRoutes.Authenticated.MainRoot.route,
        startDestination = NavRoutes.Authenticated.Login.route
    ) {
        // Dashboard
        composable(route = NavRoutes.Authenticated.Dashboard.route) {
            DashboardScreen(onNavigateToAuthenticatedRoute = {
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
            LoginScreen {
                navController.navigate(route = NavRoutes.Authenticated.Dashboard.route) {
                    popUpTo(route = NavRoutes.Authenticated.Login.route) {
                        inclusive = false
                    }
                }
            }
        }
    }
}