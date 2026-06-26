package com.santig.ktaller.features.home.presentation.viewmodel.state

import com.santig.ktaller.features.home.domain.model.RepairOrder

data class OrderDetailUiState(
    val order: RepairOrder = RepairOrder(),
    val loading: Boolean = false,
    val loadingUpdate: Boolean = false
)
