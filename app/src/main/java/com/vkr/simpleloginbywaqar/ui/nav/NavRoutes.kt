package com.vkr.simpleloginbywaqar.ui.nav

sealed class NavRoutes {
    sealed class Authenticated(val route: String) : NavRoutes() {
        data object MainRoots : Authenticated(route = "MainRoutes")
        data object Login : Authenticated(route = "Login")
        data object Dashboard : Authenticated(route = "Dashboard")
    }
}