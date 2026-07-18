package com.santig.ktaller.features.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santig.ktaller.R

sealed class SettingsOption(
    val icon: Int,
    val title: String
) {
    data object Printer : SettingsOption(
        icon = R.drawable.ic_printer,
        title = "Impresora"
    )

    data object Ticket : SettingsOption(
        icon = R.drawable.ic_ticket,
        title = "Ticket"
    )

    data object Feedback : SettingsOption(
        icon = R.drawable.ic_feedback,
        title = "Feedback"
    )
}

@Composable
fun SettingsItem(
    icon: Int,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
                color = Color.White,
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(R.drawable.ic_back),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            thickness = 0.5.dp,
            color = Color.White
        )
    }
}

@Preview(showBackground = false)
@Composable
private fun PreviewSettingsItem() {
    SettingsItem(
        icon = R.drawable.ic_setting,
        text = "Ticket",
        onClick = {}
    )
}
