package com.santig.ktaller.features.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santig.ktaller.features.home.domain.model.Order

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    onDismiss: () -> Unit,
    order: Order,
    onOrderChange: (Order) -> Unit,
    isButtonEnabled: Boolean,
    loading: Boolean,
    insertOrder: () -> Unit
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
                        text = "Nueva orden",
                        color = Color.White,
                        fontSize = 20.sp,
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
                CustomTextField(
                    title = "Nombre del cliente",
                    holder = "Cliente",
                    onTextChange = { onOrderChange(order.copy(clientName = it)) }
                )
                Spacer(modifier = Modifier.height(15.dp))
                CustomTextField(
                    title = "Nombre del dispositivo",
                    holder = "Dispositivo",
                    onTextChange = { onOrderChange(order.copy(device = it)) }
                )
                Spacer(modifier = Modifier.height(15.dp))
                CustomTextField(
                    title = "Precio estimado",
                    holder = "0.00",
                    isNumeric = true,
                    onTextChange = { onOrderChange(order.copy(price = it)) }
                )
                Spacer(modifier = Modifier.height(15.dp))
                CustomTextField(
                    title = "Breve descripcion / nota",
                    holder = "descripcion",
                    onTextChange = { onOrderChange(order.copy(description = it)) }
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = insertOrder,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                        .padding(horizontal = 16.dp)
                        .background(color = Color(0xFF6B5DE8), shape = RoundedCornerShape(20.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    shape = RoundedCornerShape(20.dp),
                    enabled = isButtonEnabled
                ) {
                    if (loading) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize()
                        )
                    } else {
                        Text(
                            text = "Guardar",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W400
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomSheet() {
    BottomSheet(
        onDismiss = {},
        order = Order(),
        onOrderChange = {},
        isButtonEnabled = true,
        insertOrder = {},
        loading = true
    )
}