package com.vkr.simpleloginbywaqar.ui.data

data class LoginState(
    val emailOrMobile: String = "",
    val password: String = "",
    val isLoginSuccessful: Boolean = false
)