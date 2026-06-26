package com.santig.ktaller.features.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santig.ktaller.features.home.domain.model.RepairOrder
import com.santig.ktaller.features.home.presentation.viewmodel.enums.OrderStatus

@Composable
fun StepsProgress(
    order: RepairOrder,
) {
    val currentStep = when (order.status) {
        OrderStatus.RECEIVED -> 1
        OrderStatus.DIAGNOSIS -> 2
        OrderStatus.REPAIRING -> 3
        OrderStatus.WAITING_PARTS -> 4
        OrderStatus.FIXED -> 5
        OrderStatus.RETIRED -> 6
        else -> 1
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        StepsV2(currentStep = currentStep)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Progreso Actual",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = order.status.displayName,
            color = Color(0xFFF59E0B),
            fontSize = 20.sp,
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}