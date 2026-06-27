package com.santig.ktaller.features.home.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Order")
data class OrderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "model_device")
    val modalDevice: String,
    @ColumnInfo(name = "price")
    val price: Double,
    @ColumnInfo(name = "status")
    val status: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "created_at")
    val createdAt: Long,
    @ColumnInfo(name = "save")
    val save: Boolean
)
