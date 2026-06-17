package com.santig.ktaller.features.home.presentation.navigation

sealed class HomeNav(val route: String) {
    data object HomeScreen : HomeNav(route = "home")
    data object ConfigurationScreen : HomeNav(route = "configuration")
}