package com.santig.ktaller.features.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.santig.ktaller.features.home.domain.model.RepairOrder
import com.santig.ktaller.features.home.presentation.viewmodel.enums.OrderStatus
import com.santig.ktaller.features.home.presentation.viewmodel.event.HomeEvent
import com.santig.ktaller.features.home.presentation.viewmodel.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val fakeList = listOf(
        RepairOrder(
            id = 1,
            clientName = "Mike Chen",
            device = "Samsung Galaxy S24",
            price = "$ 75,00",
            date = "1 day ago",
            status = OrderStatus.RECEIVED
        ),
        RepairOrder(
            id = 2,
            clientName = "Jane Doe",
            device = "iPhone 15 Pro",
            price = "$ 120,00",
            date = "2 hours ago",
            status = OrderStatus.FIXED
        ),
        RepairOrder(
            id = 3,
            clientName = "Jane Doe",
            device = "iPhone 15 Pro",
            price = "$ 120,00",
            date = "2 hours ago",
            status = OrderStatus.ALL
        ),
        RepairOrder(
            id = 4,
            clientName = "Jane Doe",
            device = "iPhone 15 Pro",
            price = "$ 120,00",
            date = "2 hours ago",
            status = OrderStatus.WAITING_PARTS
        ),
        RepairOrder(
            id = 5,
            clientName = "Jane Doe",
            device = "iPhone 15 Pro",
            price = "$ 120,00",
            date = "2 hours ago",
            status = OrderStatus.RETIRED
        ),
        RepairOrder(
            id = 6,
            clientName = "Jane Doe",
            device = "iPhone 15 Pro",
            price = "$ 120,00",
            date = "2 hours ago",
            status = OrderStatus.BOOKMARK
        ),
        RepairOrder(
            id = 7,
            clientName = "Jane Doe",
            device = "iPhone 15 Pro",
            price = "$ 120,00",
            date = "2 hours ago",
            status = OrderStatus.FIXED
        ),
        RepairOrder(
            id = 8,
            clientName = "Jane Doe",
            device = "iPhone 15 Pro",
            price = "$ 120,00",
            date = "2 hours ago",
            status = OrderStatus.DIAGNOSIS
        ),
        RepairOrder(
            id = 9,
            clientName = "Jane Doe",
            device = "iPhone 15 Pro",
            price = "$ 120,00",
            date = "2 hours ago",
            status = OrderStatus.FIXED
        ),
        RepairOrder(
            id = 10,
            clientName = "Jane Doe",
            device = "iPhone 15 Pro",
            price = "$ 120,00",
            date = "2 hours ago",
            status = OrderStatus.REPAIRING
        ),
        RepairOrder(
            id = 11,
            clientName = "Jane Doe",
            device = "iPhone 15 Pro",
            price = "$ 120,00",
            date = "2 hours ago",
            status = OrderStatus.RETIRED
        )
    )

    private val _uiState = MutableStateFlow(HomeUiState(orders = fakeList, allOrders = fakeList))
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.SelectStatus -> {
                selectStatus(event.status)
            }
        }
    }

    private fun selectStatus(status: OrderStatus) {
        _uiState.update { current ->
            val filteredList = if (status == OrderStatus.ALL) {
                current.allOrders
            } else {
                current.allOrders.filter { it.status == status }
            }
            current.copy(selectedStatus = status, orders = filteredList)
        }
    }
}