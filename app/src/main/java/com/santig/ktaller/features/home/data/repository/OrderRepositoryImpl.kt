package com.santig.ktaller.features.home.data.repository

import com.santig.ktaller.features.home.data.local.OrderDao
import com.santig.ktaller.features.home.data.mapper.OrderDataMapper
import com.santig.ktaller.features.home.domain.model.Order
import com.santig.ktaller.features.home.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val dao: OrderDao
) : OrderRepository {
    override suspend fun insertOrder(order: Order) {
        val entity = OrderDataMapper.mapToEntity(order)
        dao.insert(entity)
    }

    override fun getAllOrders(): Flow<List<Order>> {
        return dao.getAllOrders().map { entities ->
            entities.map(OrderDataMapper::mapToDomain)
        }
    }

    override suspend fun getOrderById(id: Int): Order {
        val entity = dao.getOrderById(id)
        return OrderDataMapper.mapToDomain(entity)
    }

    override suspend fun updateOrderStatus(id: Int, status: String) {
        dao.updateOrderStatusById(orderId = id, newStatus = status)
    }
}
