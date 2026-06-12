package com.santig.ktaller.features.home.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.santig.ktaller.features.home.presentation.content.HomeContent
import com.santig.ktaller.features.home.presentation.viewmodel.HomeViewModel
import com.santig.ktaller.features.home.presentation.viewmodel.event.HomeEvent

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
       HomeContent(
        uiState = uiState,
        selectedStatus = uiState.selectedStatus,
        onStatusSelected = { status ->
            viewModel.onEvent(event = HomeEvent.SelectStatus(status))
        }
    )
}