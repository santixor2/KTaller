package com.santig.ktaller.features.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.santig.ktaller.features.home.presentation.viewmodel.enums.OrderStatus
import com.santig.ktaller.features.home.presentation.viewmodel.event.HomeEvent
import com.santig.ktaller.features.home.presentation.viewmodel.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.SelectStatus -> { selectStatus(event.status) }
        }
    }

    private fun selectStatus(status: OrderStatus) {
        _uiState.update { it.copy(selectedStatus = status) }
    }
}