package com.vkr.simpleloginbywaqar

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.vkr.simpleloginbywaqar.data.Data
import com.vkr.simpleloginbywaqar.nav.NavRoutes
import com.vkr.simpleloginbywaqar.nav.mainNavGraph
import com.vkr.simpleloginbywaqar.network.ApiService
import com.vkr.simpleloginbywaqar.network.Resource
import com.vkr.simpleloginbywaqar.network.VmFactory
import com.vkr.simpleloginbywaqar.ui.dashboard.DashBoardRepo
import com.vkr.simpleloginbywaqar.ui.dashboard.DashboardVM
import com.vkr.simpleloginbywaqar.ui.theme.SimpleLoginByWaqarTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
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