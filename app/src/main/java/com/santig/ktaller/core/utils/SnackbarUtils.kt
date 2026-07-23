package com.santig.ktaller.core.utils

import androidx.compose.material3.SnackbarHostState

suspend fun SnackbarHostState.showSnackBar(
    message: String,
    actionLabel: String? = null
) {
    this.currentSnackbarData?.dismiss()
    this.showSnackbar(
        message = message,
        actionLabel = actionLabel
    )
}
