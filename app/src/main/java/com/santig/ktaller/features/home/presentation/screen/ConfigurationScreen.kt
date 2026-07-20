package com.santig.ktaller.features.home.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.santig.ktaller.features.home.presentation.components.SettingsOption
import com.santig.ktaller.features.home.presentation.content.ConfigurationContent
import com.santig.ktaller.features.home.presentation.navigation.HomeNav

@Composable
fun ConfigurationScreen(
    navController: NavHostController
) {
    var isBackClicked by remember { mutableStateOf(false) }
    ConfigurationContent(
        onBack = {
            if (!isBackClicked){
                isBackClicked = true
                navController.popBackStack()
            }
        },
        onNavigate = {
            when(it){
                is SettingsOption.Printer -> {
                    navController.navigate(HomeNav.PrinterScreen.route)
                }
                is SettingsOption.Feedback -> {

                }
                is SettingsOption.Ticket -> {

                }
            }
        }
    )
}
