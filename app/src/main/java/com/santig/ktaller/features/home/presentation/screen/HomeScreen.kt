package com.santig.ktaller.features.home.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.santig.ktaller.features.home.presentation.components.BottomSheet
import com.santig.ktaller.features.home.presentation.content.HomeContent
import com.santig.ktaller.features.home.presentation.navigation.HomeNav
import com.santig.ktaller.features.home.presentation.viewmodel.HomeViewModel
import com.santig.ktaller.features.home.presentation.viewmodel.event.HomeEvent

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val orderData by viewModel.orderData.collectAsState()
    val isButtonEnabled by viewModel.isButtonEnabled.collectAsState()
    HomeContent(
        uiState = uiState,
        selectedStatus = uiState.selectedStatus,
        onStatusSelected = { status ->
            viewModel.onEvent(event = HomeEvent.SelectStatus(status))
        },
        goToAdd = {
            viewModel.onEvent(event = HomeEvent.ShowBottomSheet(show = true))
        },
        goToSetting = { navController.navigate(HomeNav.ConfigurationScreen.route) }
    )
    if (uiState.showBottomSheet) {
        BottomSheet(
            order = orderData,
            isButtonEnabled = isButtonEnabled,
            loading = uiState.loading,
            onDismiss = {
                viewModel.onEvent(event = HomeEvent.ShowBottomSheet(show = false))
            },
            onOrderChange = { viewModel.onEvent(event = HomeEvent.OrderState(order = it)) },
            insertOrder = {viewModel.onEvent(event = HomeEvent.InsertOrder)}
        )
    }
}