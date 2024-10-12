package com.vkr.simpleloginbywaqar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.vkr.simpleloginbywaqar.ui.nav.NavRoutes
import com.vkr.simpleloginbywaqar.ui.nav.mainNavGraph
import com.vkr.simpleloginbywaqar.ui.theme.SimpleLoginByWaqarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleLoginByWaqarTheme {
                SimpleLoginByWaqarTheme {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        MainAppNavHost()
    }

}

@Composable
fun MainAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavRoutes.Authenticated.MainRoot.route
    ) {
        // Authenticated user flow screens
        mainNavGraph(navController = navController)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleLoginByWaqarTheme {
        MainApp()
    }
}