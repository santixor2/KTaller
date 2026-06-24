package com.santig.ktaller.features.home.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santig.ktaller.features.home.data.mapper.RepairOrderMapper
import com.santig.ktaller.features.home.domain.repository.OrderRepository
import com.santig.ktaller.features.home.presentation.navigation.HomeConstants
import com.santig.ktaller.features.home.presentation.viewmodel.state.OrderDetailUiState
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
}

data class DetailArgs(
    val id: Int
)
