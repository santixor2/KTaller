package com.santig.ktaller.features.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    Navigation(navController = navController)
}