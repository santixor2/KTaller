package com.santig.ktaller.features.home.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.santig.ktaller.core.ui.components.LoadingScreen
import com.santig.ktaller.features.home.presentation.content.OrderDetailContent
import com.santig.ktaller.features.home.presentation.viewmodel.OrderDetailViewModel
import com.santig.ktaller.features.home.presentation.viewmodel.event.OrderDetailEvent

@Composable
fun OrderDetailScreen(
    navController: NavHostController,
    viewModel: OrderDetailViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var isBackClicked by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        viewModel.getOrder()
    }
    OrderDetailContent(
        order = uiState.order,
        uiState = uiState,
        onEvent = { event -> viewModel.onEvent(event = event) },
        onClickBookmark = { viewModel.onEvent(event = OrderDetailEvent.OnSaveOrder(it)) },
        onBack = {
            if (!isBackClicked) {
                isBackClicked = true
                navController.popBackStack()
            }
        }
    )
    if (uiState.loading) {
        LoadingScreen()
    }
}