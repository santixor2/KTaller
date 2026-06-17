package com.santig.ktaller.features.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.santig.ktaller.features.home.presentation.screen.ConfigurationScreen
import com.santig.ktaller.features.home.presentation.screen.HomeScreen

fun NavGraphBuilder.homeGraph(
    navController: NavHostController
) {
    composable(route = HomeNav.HomeScreen.route) {
        HomeScreen(navController = navController)
    }
    composable(route = HomeNav.ConfigurationScreen.route){
        ConfigurationScreen(navController = navController)
    }
}