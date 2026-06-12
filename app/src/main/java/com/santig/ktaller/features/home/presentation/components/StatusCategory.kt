package com.santig.ktaller.features.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santig.ktaller.R
import com.santig.ktaller.features.home.presentation.viewmodel.enums.OrderStatus

@Composable
fun StatusCategory(
    selectedStatus: OrderStatus,
    onStatusSelected: (OrderStatus) -> Unit
) {
    val categories = OrderStatus.entries.toTypedArray()
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        items(categories) { status ->
            if (status == OrderStatus.BOOKMARK) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bookmark),
                    contentDescription = null,
                    tint = if (selectedStatus == status) Color(0xFF673AB7) else Color.White,
                    modifier = Modifier
                        .size(36.dp)
                        .clickable(onClick = { onStatusSelected(status) })
                )
            } else {
                CategoryChip(
                    text = status.displayName,
                    onClick = { onStatusSelected(status) },
                    selected = selectedStatus == status
                )
            }
        }
    }
}
@Composable
fun CategoryChip(text: String, onClick: (String) -> Unit, selected: Boolean) {
    Box(
        modifier = Modifier
            .background(
                if (selected) Color(0xFF673AB7) else Color(0xFF1E1F22),
                RoundedCornerShape(0)
            )
            .clickable { onClick(text) }
            .padding(horizontal = 20.dp, vertical = 4.dp)
    ) {
        Text(text = text, color = if (selected) Color.White else Color.White, fontSize = 14.5.sp)
    }
}
@Preview(showBackground = false)
@Composable
fun PreviewStatusCategory() {
    StatusCategory(selectedStatus = OrderStatus.ALL, onStatusSelected = {})
}
