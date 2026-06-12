package com.santig.ktaller.features.home.presentation.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santig.ktaller.core.ui.components.TopBar
import com.santig.ktaller.features.home.presentation.components.SearchBar
import com.santig.ktaller.features.home.presentation.components.StatusCategory
import com.santig.ktaller.features.home.presentation.viewmodel.enums.OrderStatus

@Composable
fun HomeContent(
    selectedStatus: OrderStatus,
    onStatusSelected: (OrderStatus) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                goToAdd = {

                },
                goToSetting = {

                }
            )
        },
        modifier = Modifier
            .navigationBarsPadding()
            .statusBarsPadding()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(color = Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            SearchBar(
                onTextChange = { }
            )
            Spacer(modifier = Modifier.height(15.dp))
            StatusCategory(
                selectedStatus = selectedStatus,
                onStatusSelected = { onStatusSelected(it) }
            )
            when (selectedStatus) {
                OrderStatus.BOOKMARK -> {
                    Text(
                        text = "BOOKMARK",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.W500,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }

                OrderStatus.ALL -> {
                    Text(
                        text = "TODOS",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.W500,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }

                OrderStatus.RECEIVED -> {
                    Text(
                        text = "RECEIVED",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.W500,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }

                OrderStatus.DIAGNOSIS -> {
                    Text(
                        text = "DIAGNOSIS",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.W500,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }

                OrderStatus.REPAIRING -> {

                }

                OrderStatus.WAITING_PARTS -> {

                }

                OrderStatus.FIXED -> {
                    Text(
                        text = "FIXED",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.W500,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }

                OrderStatus.RETIRED -> {

                }
            }
        }
    }
}