package com.santig.ktaller.features.home.presentation.viewmodel.enums

import androidx.compose.ui.graphics.Color

enum class OrderStatus(val displayName: String, val color: Color) {
    BOOKMARK("FAVORITOS", Color(0xFF3F51B5)),
    ALL(displayName = "TODOS", Color(0xFF8BC34A)),
    RECEIVED(displayName = "RECIBIDOS", Color(0xFF2196F3)),
    DIAGNOSIS(displayName = "DIAGNOSTICO", Color(0xFF009688)),
    REPAIRING(displayName = "REPARANDO", Color(0xFFFFC107)),
    WAITING_PARTS(displayName = "ESPERANDO REPUESTO", Color(0xFF673AB7)),
    FIXED(displayName = "ARREGLADO", Color(0xFFE91E63)),
    RETIRED(displayName = "RETIRADO", Color(0xFFFF5722))
}