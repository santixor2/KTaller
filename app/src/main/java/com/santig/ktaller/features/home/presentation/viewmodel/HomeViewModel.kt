package com.santig.ktaller.features.home.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santig.ktaller.features.home.data.mapper.RepairOrderMapper
import com.santig.ktaller.features.home.domain.model.Order
import com.santig.ktaller.features.home.domain.repository.OrderRepository
import com.santig.ktaller.features.home.presentation.viewmodel.enums.OrderStatus
import com.santig.ktaller.features.home.presentation.viewmodel.event.HomeEvent
import com.santig.ktaller.features.home.presentation.viewmodel.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: OrderRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()
    private val _orderData = MutableStateFlow(Order())
    val orderData = _orderData.asStateFlow()

    val isButtonEnabled = _orderData
        .map {
            it.device.isNotBlank() && it.price.isNotBlank() && it.clientName.isNotBlank()
                    && it.description.isNotBlank()
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    init {
        observeOrders()
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.SelectStatus -> { selectStatus(event.status) }
            is HomeEvent.InsertOrder -> { insertOrder() }
            is HomeEvent.ShowBottomSheet -> { showBottomSheet(show = event.show) }
            is HomeEvent.OrderState -> { orderState(event.order) }
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

    private fun insertOrder() {
        viewModelScope.launch {
            _uiState.update { it.copy(loading = true) }
            runCatching {
                repository.insertOrder(order = _orderData.value)
            }.onSuccess {
                _uiState.update { it.copy(loading = false) }
                showBottomSheet(show = false)
            }.onFailure { exception ->
                exception.printStackTrace()
                _uiState.update { it.copy(loading = false) }
            }
        }
    }

    private fun observeOrders() {
        repository.getAllOrders()
            .onStart {
                _uiState.update { it.copy(homeLoading = true) }
            }
            .catch { exception ->
                Log.d("HOMEVIEWMODEL","Error obteniendo órdenes ==>> ${exception.printStackTrace()}")
                _uiState.update { it.copy(homeLoading = false) }
            }
            .onEach { orders ->
                val repairOrders = RepairOrderMapper.mapToUiList(orders)
                val filteredOrders = when (_uiState.value.selectedStatus) {
                    OrderStatus.ALL -> repairOrders
                    else -> repairOrders.filter {
                        it.status == _uiState.value.selectedStatus
                    }
                }
                _uiState.update {
                    it.copy(
                        allOrders = repairOrders,
                        orders = filteredOrders,
                        homeLoading = false
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    private fun showBottomSheet(show: Boolean) {
        _uiState.update { it.copy(showBottomSheet = show) }
    }

    private fun orderState(order: Order) {
        _orderData.update {
            order
        }
    }
}
