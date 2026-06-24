package com.santig.ktaller.features.home.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Steps(
    size: Int
) {
    val progress = (size.toFloat() / 4.0f).coerceIn(0.0f, 1.0f)
    val animatedProgress by animateFloatAsState(
        targetValue = progress
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        Text(
            text = "Progreso del Servicio",
            fontSize = 13.sp,
            fontWeight = FontWeight.W500,
            color = Color.Black.copy(0.9f)
        )
        Text(
            text = "$size/4 Completado",
            fontSize = 13.sp,
            fontWeight = FontWeight.W500,
            color = Color.Black.copy(0.9f)
        )
    }
    Spacer(modifier = Modifier.height(4.dp))
    LinearProgressIndicator(
        progress = { animatedProgress },
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth()
            .height(10.dp)
            .clip(RoundedCornerShape(16.dp)),
        color = Color.Green.copy(0.7f),
        trackColor = Color.LightGray,
        drawStopIndicator = {},
        gapSize = 0.dp,
        strokeCap = StrokeCap.Square
    )
}

@Composable
fun StepsV2(
    currentStep: Int
) {
    val totalSteps = 6
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Progreso del Servicio",
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            color = Color.White
        )
        Text(
            text = "$currentStep/$totalSteps",
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            color = Color.White
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        for (stepIndex in 1..totalSteps) {
            val targetColor = when {
                stepIndex < currentStep -> Color(0xFF22C55E)
                stepIndex == currentStep -> Color(0xFFF59E0B)
                else -> Color.Gray
            }
            val animatedColor by animateColorAsState(
                targetValue = targetColor,
                animationSpec = tween(durationMillis = 300)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(12.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(animatedColor)
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun PreviewSteps() {
    Column() {
        StepsV2(currentStep = 4)
    }
}