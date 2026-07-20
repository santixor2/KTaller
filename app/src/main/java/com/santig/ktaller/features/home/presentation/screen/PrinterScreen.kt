package com.santig.ktaller.features.home.presentation.screen

import android.bluetooth.BluetoothManager
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.santig.ktaller.features.home.presentation.content.PrinterContent

@Composable
fun PrinterScreen(
    navController: NavHostController
) {
    var isBackClicked by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var showModal by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        val bluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        val isEnabled = bluetoothManager.adapter?.isEnabled == true
        if (!isEnabled) {
            showModal = true
        }
    }
    PrinterContent(
        onBack = {
            if (!isBackClicked) {
                isBackClicked = true
                navController.popBackStack()
            }
        }
    )
}
