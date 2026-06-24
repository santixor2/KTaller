package com.santig.ktaller.features.home.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.santig.ktaller.core.ui.components.LoadingScreen
import com.santig.ktaller.features.home.presentation.content.OrderDetailContent
import com.santig.ktaller.features.home.presentation.viewmodel.OrderDetailViewModel

@Composable
fun OrderDetailScreen(
    navController: NavHostController,
    viewModel: OrderDetailViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getOrder()
    }
    OrderDetailContent(
        order = uiState.order,
        onBack = {
            navController.popBackStack()
        }
    )
    if (uiState.loading) {
        LoadingScreen()
    }
}