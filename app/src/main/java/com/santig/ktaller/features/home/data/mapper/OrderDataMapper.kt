package com.santig.ktaller.features.home.data.mapper

import com.santig.ktaller.features.home.data.local.OrderEntity
import com.santig.ktaller.features.home.domain.model.Order
import com.santig.ktaller.features.home.presentation.viewmodel.enums.OrderStatus

object OrderDataMapper {
    fun mapToEntity(order: Order): OrderEntity {
        return OrderEntity(
            id = order.id,
            name = order.clientName,
            modalDevice = order.device,
            price = order.price.toDouble(),
            status = OrderStatus.RECEIVED.displayName,
            description = order.description,
            createdAt = System.currentTimeMillis(),
            save = order.save
        )
    }

    fun mapToDomain(entity: OrderEntity): Order {
        return Order(
            id = entity.id,
            clientName = entity.name,
            device = entity.modalDevice,
            status = entity.status,
            createdAt = entity.createdAt,
            price = entity.price.toString(),
            description = entity.description,
            save = entity.save
        )
    }
}
