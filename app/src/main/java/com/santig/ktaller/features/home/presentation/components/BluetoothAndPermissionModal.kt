package com.santig.ktaller.features.home.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun BluetoothAndPermissionModal(
    onClose: () -> Unit
) {
    Dialog(
        onDismissRequest = { },
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
    ) {
        Surface(
            modifier = Modifier
                .wrapContentHeight()
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(10.dp)
                ),
            shape = RoundedCornerShape(10.dp),
            color = Color.Black,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Permiso de Bluetooth",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Para utilizar esta funcionalidad, es indispensable contar con el Bluetooth \nhabilitado y conceder los permisos de \nacceso correspondientes. Al presionar \nel botón de Bluetooth, se solicitará la \nautorización de los permisos del sistema requeridos para continuar.",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.White.copy(0.6f),
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(15.dp))
                Button(
                    onClick = onClose,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(horizontal = 32.dp)
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(10.dp)
                        ),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)

                ) {
                    Text(
                        text = "Cerrar",
                        fontSize = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBluetoothAndPermissionModal() {
    BluetoothAndPermissionModal(onClose = {})
}
