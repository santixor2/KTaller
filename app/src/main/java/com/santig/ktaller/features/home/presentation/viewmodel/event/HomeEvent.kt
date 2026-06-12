package com.santig.ktaller.features.home.presentation.viewmodel.event

import com.santig.ktaller.features.home.presentation.viewmodel.enums.OrderStatus
sealed interface HomeEvent {
    data class SelectStatus(val status: OrderStatus) : HomeEvent
}