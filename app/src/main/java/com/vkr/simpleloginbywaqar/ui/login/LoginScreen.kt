package com.vkr.simpleloginbywaqar.ui.login

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.size.Scale
import com.vkr.simpleloginbywaqar.helpercomposables.MediumTitleText
import com.vkr.simpleloginbywaqar.ui.theme.AppTheme
import com.vkr.simpleloginbywaqar.R
import com.vkr.simpleloginbywaqar.helpercomposables.TitleText
import com.vkr.simpleloginbywaqar.ui.theme.SimpleLoginByWaqarTheme

@Composable
fun LoginScreen(
    onNavigateToAuthenticatedRoute: (String) -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
                .imePadding()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Main card Content for Login
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(AppTheme.dimens.paddingLarge)
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = AppTheme.dimens.paddingLarge)
                        .padding(bottom = AppTheme.dimens.paddingExtraLarge)
                ) {
                    // Heading Text
                    MediumTitleText(
                        modifier = Modifier
                            .padding(top = AppTheme.dimens.paddingLarge)
                            .fillMaxWidth(),
                        text = stringResource(id = R.string.app_name),
                        textAlign = TextAlign.Center
                    )

                    // Login Logo
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(128.dp)
                            .padding(top = AppTheme.dimens.paddingSmall),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(data = R.drawable.ic_login)
                            .crossfade(enable = true)
                            .scale(Scale.FILL)
                            .build(),
                        contentDescription = stringResource(id = R.string.login)
                    )

                    // Heading Login
                    TitleText(
                        modifier = Modifier.padding(top = AppTheme.dimens.paddingLarge),
                        text = stringResource(id = R.string.login)
                    )

                    // Login Inputs Composable
                    LoginFields(
                        email = email,
                        password = password,
                        onEmailOrMobileChange = { inputString ->
                            email = inputString
                        },
                        onPasswordChange = { inputString ->
                            password = inputString

                        },
                        onSubmit = {
                            if (email.isNotEmpty() && password.isNotEmpty()) {
                                onNavigateToAuthenticatedRoute.invoke(email)
                            } else {
                                Toast.makeText(
                                    context, "Please Enter Email & Password.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    SimpleLoginByWaqarTheme {
        LoginScreen {}
    }
}