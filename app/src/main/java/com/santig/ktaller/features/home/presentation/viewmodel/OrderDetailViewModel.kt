package com.santig.ktaller.features.home.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santig.ktaller.features.home.data.mapper.RepairOrderMapper
import com.santig.ktaller.features.home.domain.model.RepairOrder
import com.santig.ktaller.features.home.domain.repository.OrderRepository
import com.santig.ktaller.features.home.presentation.navigation.HomeConstants
import com.santig.ktaller.features.home.presentation.viewmodel.event.OrderDetailEvent
import com.santig.ktaller.features.home.presentation.viewmodel.state.OrderDetailUiState
import com.santig.ktaller.features.home.presentation.viewmodel.util.OrderStatusManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class OrderDetailViewModel @Inject constructor(
    private val repository: OrderRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val args = DetailArgs(
        id = checkNotNull(savedStateHandle[HomeConstants.ID_DETAIL])
    )
    private val _uiState = MutableStateFlow(OrderDetailUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: OrderDetailEvent) {
        when (event) {
            is OrderDetailEvent.OnAdvanceStatus -> {
                updateOrder(event.order)
            }
            is OrderDetailEvent.OnSaveOrder -> {
                saveOrder(save = event.save)
            }
        }
    }

    fun getOrder() {
        viewModelScope.launch {
            _uiState.update { it.copy(loading = true) }
            runCatching {
                repository.getOrderById(id = args.id)
            }.onSuccess { domainOrder ->
                _uiState.update {
                    it.copy(loading = false, order = RepairOrderMapper.mapToUi(domainOrder))
                }
            }.onFailure { exception ->
                exception.printStackTrace()
                _uiState.update { it.copy(loading = false) }
            }
        }
    }

    private fun updateOrder(order: RepairOrder){
        val nextStatus = OrderStatusManager.getNextStatus(order)
        if (nextStatus == order.status) return
        viewModelScope.launch {
            _uiState.update { it.copy(loadingUpdate = true) }
            runCatching {
                repository.updateOrderStatus(id = args.id, status = nextStatus.displayName)
            }.onSuccess {
                getOrder()
                _uiState.update { it.copy(loadingUpdate = false) }
            }.onFailure {
                _uiState.update { it.copy(loadingUpdate = false) }
            }
        }
    }

    private fun saveOrder(save : Boolean){
        viewModelScope.launch {
            runCatching {
                repository.updateOrderSave(id = args.id, save = save)
            }.onSuccess {
                getOrder()
            }
        }
    }
}

data class DetailArgs(
    val id: Int
)
