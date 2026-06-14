package com.santig.ktaller.features.home.data.mapper

import com.santig.ktaller.core.utils.DateUtils.toFormattedDate
import com.santig.ktaller.features.home.domain.model.Order
import com.santig.ktaller.features.home.domain.model.RepairOrder
import com.santig.ktaller.features.home.presentation.viewmodel.enums.OrderStatus

object RepairOrderMapper {
    fun mapToUi(order: Order): RepairOrder {
        return RepairOrder(
            id = order.id,
            clientName = order.clientName,
            device = order.device,
            price = order.price,
            description = order.description,
            createdAt = order.createdAt.toFormattedDate(),
            status = OrderStatus.entries.firstOrNull {
                it.displayName == order.status
            } ?: OrderStatus.ALL
        )
    }

    fun mapToUiList(orders: List<Order>): List<RepairOrder> {
        return orders.map(::mapToUi)
    }
}
