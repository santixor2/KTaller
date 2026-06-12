package com.santig.ktaller.features.home.presentation.viewmodel.state

import com.santig.ktaller.features.home.domain.model.RepairOrder
import com.santig.ktaller.features.home.presentation.viewmodel.enums.OrderStatus

data class HomeUiState(
    val selectedStatus: OrderStatus = OrderStatus.ALL,
    val orders: List<RepairOrder> = emptyList(),
    val allOrders: List<RepairOrder> = emptyList()
)
