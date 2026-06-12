package com.santig.ktaller.features.home.presentation.viewmodel.state

import com.santig.ktaller.features.home.presentation.viewmodel.enums.OrderStatus

data class HomeUiState(
    val selectedStatus: OrderStatus = OrderStatus.ALL
)
