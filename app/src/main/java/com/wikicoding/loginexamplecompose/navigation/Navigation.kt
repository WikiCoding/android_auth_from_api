package com.wikicoding.loginexamplecompose.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wikicoding.loginexamplecompose.uiscreens.DashBoardScreenView
import com.wikicoding.loginexamplecompose.uiscreens.LoginScreen
import com.wikicoding.loginexamplecompose.uiscreens.Screen
import com.wikicoding.loginexamplecompose.viewmodel.MainViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(
    navHostController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel = viewModel()
) {
    NavHost(navController = navHostController, startDestination = Screen.LoginScreen.route) {
        composable(Screen.LoginScreen.route) {
            LoginScreen(navHostController = navHostController, mainViewModel = mainViewModel)
        }

        composable(Screen.DashboardScreen.route) {
            DashBoardScreenView(navHostController = navHostController, mainViewModel = mainViewModel)
        }
    }
}