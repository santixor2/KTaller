package com.santig.ktaller.features.home.presentation.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santig.ktaller.R
import com.santig.ktaller.features.home.presentation.components.IconBackWithText
import com.santig.ktaller.features.home.presentation.components.SettingsItem
import com.santig.ktaller.features.home.presentation.components.SettingsOption

@Composable
fun ConfigurationContent(
    onBack: () -> Unit
) {
    val configItems = listOf(
        SettingsOption.Printer,
        SettingsOption.Ticket,
        SettingsOption.Feedback
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .navigationBarsPadding()
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconBackWithText(
            title = "Configuracion",
            onBackClick = onBack
        )
        configItems.forEach { items ->
            SettingsItem(
                icon = items.icon,
                text = items.title,
                onClick = {}
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "KTALLER",
            fontSize = 20.sp,
            fontWeight = FontWeight.W500,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "1.0.0",
            fontSize = 13.sp,
            fontWeight = FontWeight.W300,
            color = Color.White.copy(0.6f),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}