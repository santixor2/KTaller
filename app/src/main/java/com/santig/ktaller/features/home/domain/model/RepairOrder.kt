package com.santig.ktaller.features.home.domain.model

import com.santig.ktaller.features.home.presentation.viewmodel.enums.OrderStatus

data class RepairOrder(
    val id: Int = 0,
    val clientName: String = "",
    val device: String = "",
    val price: String = "",
    val date: String = "",
    val description: String = "",
    val createdAt: Long  = 0,
    val status: OrderStatus = OrderStatus.ALL
)
