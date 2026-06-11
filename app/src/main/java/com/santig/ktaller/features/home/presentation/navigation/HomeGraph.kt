package com.santig.ktaller.features.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.santig.ktaller.features.home.presentation.content.HomeScreenContent

fun NavGraphBuilder.homeGraph(
    navController: NavHostController
) {
    composable(route = HomeNav.HomeScreen.route) {
        HomeScreenContent()
    }
}