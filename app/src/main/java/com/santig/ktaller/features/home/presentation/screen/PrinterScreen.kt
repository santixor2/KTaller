package com.santig.ktaller.features.home.presentation.screen

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.santig.ktaller.core.utils.PrinterManager
import com.santig.ktaller.features.home.presentation.components.BluetoothAndPermissionModal
import com.santig.ktaller.features.home.presentation.components.DeviceListSheet
import com.santig.ktaller.features.home.presentation.content.PrinterContent
import com.santig.ktaller.features.home.presentation.viewmodel.PrinterViewModel
import com.santig.ktaller.features.home.presentation.viewmodel.event.PrinterEvent

@Composable
fun PrinterScreen(
    navController: NavHostController,
    viewModel: PrinterViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var isBackClicked by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var showModal by remember { mutableStateOf(false) }
    var showSheet by remember { mutableStateOf(false) }
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            viewModel.onEvent(
                event = PrinterEvent.LoadDevices(PrinterManager.getPairedPrinters(context))
            )
        }
    }
    LaunchedEffect(Unit) {
        if (!PrinterManager.isBluetoothEnabled(context)) {
            showModal = true
        }
        PrinterManager.getSavedPrinter(context)?.let {
            viewModel.onEvent(event = PrinterEvent.StartDevice(it))
        }
    }
    PrinterContent(
        uiState = uiState,
        show = uiState.startDevices != null,
        onBack = {
            if (!isBackClicked) {
                isBackClicked = true
                navController.popBackStack()
            }
        },
        onClick = {
            if (PrinterManager.hasBluetoothConnectPermission(context)) {
                if (PrinterManager.isBluetoothEnabled(context)) {
                    viewModel.onEvent(
                        event = PrinterEvent.LoadDevices(PrinterManager.getPairedPrinters(context))
                    )
                    showSheet = true
                } else {
                    showModal = true
                }
            } else {
                permissionLauncher.launch(Manifest.permission.BLUETOOTH_CONNECT)
            }
        },
        onClickPrinter = {}
    )

    if (showModal) {
        BluetoothAndPermissionModal(
            onClose = {
                showModal = false
            }
        )
    }

    if (showSheet) {
        DeviceListSheet(
            uiState = uiState,
            onEvent = { viewModel.onEvent(event = it) },
            onDismiss = {
                showSheet = false
            },
            onClick = {
                val isSaved = PrinterManager.savePrinter(
                    context = context,
                    name = uiState.devices[0].name,
                    macAddress = uiState.devices[0].address
                )
                if (isSaved) {
                    showSheet = false
                    PrinterManager.getSavedPrinter(context)?.let {
                        viewModel.onEvent(event = PrinterEvent.StartDevice(it))
                    }
                }
            }
        )
    }
}
