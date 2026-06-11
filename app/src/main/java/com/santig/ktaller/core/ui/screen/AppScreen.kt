package com.santig.ktaller.core.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.santig.ktaller.core.ui.viewmodel.StartScreenViewModel
import com.santig.ktaller.core.ui.viewmodel.UiState
import com.santig.ktaller.features.navigation.AppNavigation

@Composable
fun AppScreen(
    viewModel: StartScreenViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    when (state) {
        UiState.Welcome -> {
            WelcomeScreen(
                onClick = {
                    viewModel.updateUiState(state = UiState.Home)
                }
            )
        }

        UiState.Home -> {
            AppNavigation()
        }
    }
}