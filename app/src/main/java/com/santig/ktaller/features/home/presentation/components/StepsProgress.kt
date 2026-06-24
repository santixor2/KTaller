package com.santig.ktaller.features.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StepsProgress(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        StepsV2(currentStep = 2)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Estado Actual",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "REPARANDO",
            color = Color(0xFFF59E0B),
            fontSize = 20.sp,
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(horizontal = 50.dp)
                .background(color = Color(0xFF6B5DE8), shape = RoundedCornerShape(0.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(
                text = "Cambiar progreso",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400
            )
        }
    }
}