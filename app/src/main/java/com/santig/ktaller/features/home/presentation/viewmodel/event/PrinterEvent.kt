package com.santig.ktaller.features.home.presentation.viewmodel.event

import com.santig.ktaller.core.utils.BluetoothDevice

sealed interface PrinterEvent {
    data class SelectDevice(val address: String) : PrinterEvent
    data class LoadDevices(val devices: List<BluetoothDevice>) : PrinterEvent
}
