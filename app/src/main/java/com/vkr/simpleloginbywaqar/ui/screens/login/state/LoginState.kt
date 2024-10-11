package com.vkr.simpleloginbywaqar.ui.screens.login.state

data class LoginState(
    val emailOrMobile: String = "",
    val password: String = "",
    val isLoginSuccessful: Boolean = false
)