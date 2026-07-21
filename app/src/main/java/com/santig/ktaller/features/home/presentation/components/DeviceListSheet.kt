package com.santig.ktaller.features.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santig.ktaller.R
import com.santig.ktaller.features.home.presentation.viewmodel.event.PrinterEvent
import com.santig.ktaller.features.home.presentation.viewmodel.state.PrinterUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceListSheet(
    onDismiss: () -> Unit,
    uiState: PrinterUiState,
    onEvent: (PrinterEvent) -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    BoxWithConstraints {
        val sheetHeight = maxHeight * 2 / 3
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState,
            dragHandle = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black)
                        .padding(vertical = 18.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Dispositivos vinculados",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500
                    )
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(sheetHeight)
                    .background(Color.Black)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                uiState.devices.forEach { item ->
                    DeviceItem(
                        icon = R.drawable.ic_bluetooth,
                        text = item.name,
                        isSelected = uiState.selectedDeviceAddress == item.address,
                        onClick = { onEvent(PrinterEvent.SelectDevice(address = item.address)) }
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
                Spacer(modifier = Modifier.weight(1f))
                if (uiState.selectedDeviceAddress.isNotBlank()){
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(horizontal = 24.dp)
                            .background(color = Color.Black, shape = RoundedCornerShape(10.dp))
                            .border(
                                width = 1.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "Guardar",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W400
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}
