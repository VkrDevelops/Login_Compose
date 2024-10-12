package com.vkr.simpleloginbywaqar.nav

sealed class NavRoutes {
    sealed class Authenticated(val route: String) : NavRoutes() {
        data object MainRoot : Authenticated(route = "MainRoutes")
        data object Login : Authenticated(route = "Login")
        data object Dashboard : Authenticated(route = "Dashboard/{username}")
    }
}