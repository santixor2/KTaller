package com.santig.ktaller.features.home.presentation.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.santig.ktaller.core.ui.components.TopBar
import com.santig.ktaller.features.home.presentation.components.SearchBar
import com.santig.ktaller.features.home.presentation.components.StatusCardItem
import com.santig.ktaller.features.home.presentation.components.StatusCategory
import com.santig.ktaller.features.home.presentation.viewmodel.enums.OrderStatus
import com.santig.ktaller.features.home.presentation.viewmodel.state.HomeUiState

@Composable
fun HomeContent(
    selectedStatus: OrderStatus,
    onStatusSelected: (OrderStatus) -> Unit,
    goToAdd: () -> Unit,
    uiState: HomeUiState
) {
    Scaffold(
        topBar = {
            TopBar(
                goToAdd = goToAdd,
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
            Spacer(modifier = Modifier.height(15.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = uiState.orders,
                    key = { order -> order.id }
                ) { order ->
                    StatusCardItem(order = order)
                }
            }
        }
    }
}