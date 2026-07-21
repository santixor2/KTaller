package com.santig.ktaller.features.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.santig.ktaller.features.home.presentation.viewmodel.event.PrinterEvent
import com.santig.ktaller.features.home.presentation.viewmodel.state.PrinterUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PrinterViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(PrinterUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: PrinterEvent) {
        when (event) {
            is PrinterEvent.SelectDevice -> {
                _uiState.update { it.copy(selectedDeviceAddress = event.address) }
            }
            is PrinterEvent.LoadDevices -> {
                _uiState.update { it.copy(devices = event.devices) }
            }
        }
    }

}
