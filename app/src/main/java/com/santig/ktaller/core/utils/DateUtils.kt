package com.santig.ktaller.core.utils

object DateUtils {
    fun Long.toFormattedDate(): String {
        val formatter = java.text.SimpleDateFormat("dd/MM/yy", java.util.Locale.getDefault())
        return formatter.format(java.util.Date(this))
    }
}