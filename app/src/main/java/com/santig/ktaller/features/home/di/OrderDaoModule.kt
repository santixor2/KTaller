package com.santig.ktaller.features.home.di

import com.santig.ktaller.core.storage.AppDatabase
import com.santig.ktaller.features.home.data.local.OrderDao
import com.santig.ktaller.features.home.data.repository.OrderRepositoryImpl
import com.santig.ktaller.features.home.domain.repository.OrderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object OrderDaoModule {

    @Provides
    fun providesOrderDao(db: AppDatabase) : OrderDao {
        return db.orderDao()
    }

    @Provides
    fun provideOrderRepository(
        dao: OrderDao
    ): OrderRepository {
        return OrderRepositoryImpl(dao)
    }

}
