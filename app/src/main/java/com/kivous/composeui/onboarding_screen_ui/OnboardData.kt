package com.kivous.composeui.onboarding_screen_ui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class OnboardData(
    @DrawableRes
    val image: Int,
    val background: Color,
    val mainColor: Color,
    val title: String,
    val desc: String,
)