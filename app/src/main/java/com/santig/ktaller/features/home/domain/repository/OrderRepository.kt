package com.santig.ktaller.features.home.domain.repository

import com.santig.ktaller.features.home.domain.model.Order
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    suspend fun insertOrder(order: Order)
    fun getAllOrders(): Flow<List<Order>>
    suspend fun getOrderById(id: Int): Order
    suspend fun updateOrderStatus(id: Int, status: String)
    suspend fun updateOrderSave(id : Int, save : Boolean)
}
