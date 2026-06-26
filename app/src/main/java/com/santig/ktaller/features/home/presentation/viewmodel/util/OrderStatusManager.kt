package com.santig.ktaller.features.home.presentation.viewmodel.util

import com.santig.ktaller.features.home.domain.model.RepairOrder
import com.santig.ktaller.features.home.presentation.viewmodel.enums.OrderStatus

object OrderStatusManager {
    private val statusSequence = listOf(
        OrderStatus.RECEIVED,
        OrderStatus.DIAGNOSIS,
        OrderStatus.REPAIRING,
        OrderStatus.WAITING_PARTS,
        OrderStatus.FIXED,
        OrderStatus.RETIRED
    )

    fun getNextStatus(order: RepairOrder): OrderStatus {
        val currentStatus = order.status
        val currentIndex = statusSequence.indexOf(currentStatus)
        if (currentIndex == -1 || currentIndex == statusSequence.lastIndex) {
            return currentStatus
        }
        return statusSequence[currentIndex + 1]
    }
}