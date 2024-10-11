package com.vkr.simpleloginbywaqar.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import com.vkr.simpleloginbywaqar.R
import com.vkr.simpleloginbywaqar.ui.data.LoginState
import com.vkr.simpleloginbywaqar.ui.helpercomposables.EmailTextField
import com.vkr.simpleloginbywaqar.ui.helpercomposables.NormalButton
import com.vkr.simpleloginbywaqar.ui.helpercomposables.PasswordTextField
import com.vkr.simpleloginbywaqar.ui.theme.AppTheme

@Composable
fun LoginFields(
    loginState: LoginState,
    onEmailOrMobileChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSubmit: () -> Unit,
) {
    // Login Inputs Section
    Column(modifier = Modifier.fillMaxWidth()) {
        // Email or Mobile Number
        EmailTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.dimens.paddingLarge),
            value = loginState.emailOrMobile,
            onValueChange = onEmailOrMobileChange,
            label = stringResource(id = R.string.enter_email),
        )

        // Password
        PasswordTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.dimens.paddingLarge),
            value = loginState.password,
            onValueChange = onPasswordChange,
            label = stringResource(id = R.string.enter_password),
            imeAction = ImeAction.Done
        )

        // Login Submit Button
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.dimens.paddingLarge),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.white),
                contentColor = Color.Black
            ),
            onClick = onSubmit,
        ){
            Text(text =  stringResource(id = R.string.login))
        }

    }
}