package com.santig.ktaller.core.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.santig.ktaller.features.home.data.local.OrderDao
import com.santig.ktaller.features.home.data.local.OrderEntity

@Database(
    entities = [OrderEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun orderDao(): OrderDao
}
