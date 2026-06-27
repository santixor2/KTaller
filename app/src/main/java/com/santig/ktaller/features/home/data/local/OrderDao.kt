package com.santig.ktaller.features.home.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(order: OrderEntity)

    @Query("SELECT * FROM `Order` ORDER BY created_at DESC")
    fun getAllOrders(): Flow<List<OrderEntity>>

    @Query("SELECT * FROM `Order` WHERE id = :id")
    suspend fun getOrderById(id: Int): OrderEntity

    @Query("UPDATE `Order` SET status = :newStatus WHERE id = :orderId")
    suspend fun updateOrderStatusById(orderId: Int, newStatus: String)

    @Query("UPDATE `Order` SET save = :newSave WHERE id = :orderId")
    suspend fun updateOrderSave(orderId: Int, newSave: Boolean)
}
