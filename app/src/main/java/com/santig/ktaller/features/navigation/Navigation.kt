package com.santig.ktaller.features.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.santig.ktaller.features.home.presentation.navigation.HomeNav
import com.santig.ktaller.features.home.presentation.navigation.homeGraph

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HomeNav.HomeScreen.route
    ) {
        homeGraph(navController = navController)
    }
}