package com.wikicoding.loginexamplecompose.uiscreens

sealed class Screen (val route: String){
    object LoginScreen : Screen("home_screen")
    object DashboardScreen : Screen("dashboard_screen")
}