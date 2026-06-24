package com.santig.ktaller.features.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.santig.ktaller.features.home.presentation.screen.ConfigurationScreen
import com.santig.ktaller.features.home.presentation.screen.HomeScreen
import com.santig.ktaller.features.home.presentation.screen.OrderDetailScreen

fun NavGraphBuilder.homeGraph(
    navController: NavHostController
) {
    composable(route = HomeNav.HomeScreen.route) {
        HomeScreen(navController = navController)
    }
    composable(route = HomeNav.ConfigurationScreen.route) {
        ConfigurationScreen(navController = navController)
    }
    composable(
        route = HomeNav.OrderDetailScreen.route,
        arguments = listOf(navArgument(HomeConstants.ID_DETAIL) { type = NavType.IntType })
    ) {
        OrderDetailScreen(navController = navController)
    }
}