package com.santig.ktaller.features.home.presentation.viewmodel.event

import com.santig.ktaller.features.home.domain.model.RepairOrder

sealed interface OrderDetailEvent {
    data class OnAdvanceStatus(val order: RepairOrder) : OrderDetailEvent
}