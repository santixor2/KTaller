package com.santig.ktaller.features.home.presentation.viewmodel.enums

enum class OrderStatus(val displayName: String) {
    BOOKMARK("FAVORITOS"),
    ALL(displayName = "TODOS"),
    RECEIVED(displayName = "RECIBIDOS"),
    DIAGNOSIS(displayName = "DIAGNOSTICO"),
    REPAIRING(displayName = "REPARANDO"),
    WAITING_PARTS(displayName = "ESPERANDO REPUESTO"),
    FIXED(displayName = "ARREGLADO"),
    RETIRED(displayName = "RETIRADO")
}