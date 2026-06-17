package com.santig.ktaller.features.home.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.santig.ktaller.features.home.presentation.content.ConfigurationContent

@Composable
fun ConfigurationScreen(
    navController: NavHostController
) {
    ConfigurationContent(
        onBack = { navController.popBackStack() }
    )
}