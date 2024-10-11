package com.vkr.simpleloginbywaqar.ui.screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.vkr.simpleloginbywaqar.ui.screens.login.state.LoginState

class LoginViewModel : ViewModel() {
    var loginState = mutableStateOf(LoginState())
        private set
}