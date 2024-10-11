package com.vkr.simpleloginbywaqar.ui.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vkr.simpleloginbywaqar.ui.screens.dashboard.DashboardScreen
import com.vkr.simpleloginbywaqar.ui.screens.login.LoginScreen

fun NavGraphBuilder.mainNavGraph(navController: NavController) {
    navigation(
        route = NavRoutes.Authenticated.MainRoots.route,
        startDestination = NavRoutes.Authenticated.Login.route
    ) {
        // Dashboard
        composable(route = NavRoutes.Authenticated.Dashboard.route) {
            DashboardScreen(onNavigateBack = {}, onNavigateToHomeRoute = {})
        }

        // Login
        composable(route = NavRoutes.Authenticated.Login.route) {
            LoginScreen {}
        }
    }
}