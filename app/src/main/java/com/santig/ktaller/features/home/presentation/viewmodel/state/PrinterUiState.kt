package com.santig.ktaller.features.home.presentation.viewmodel.state

import com.santig.ktaller.core.utils.BluetoothDevice

data class PrinterUiState(
    val devices: List<BluetoothDevice> = emptyList(),
    val startDevices: BluetoothDevice? = null,
    val selectedDeviceAddress: String = "",
    val hasSavedPrinter: Boolean = false
)
