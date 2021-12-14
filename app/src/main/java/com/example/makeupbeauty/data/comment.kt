package com.example.makeupbeauty.data

import androidx.compose.ui.window.SecureFlagPolicy

data class comment(
    val focusable: Boolean = false,
    val dismissOnBackPress: Boolean = true,
    val dismissOnClickOutside: Boolean = true,
    val securePolicy: SecureFlagPolicy = SecureFlagPolicy.Inherit)

