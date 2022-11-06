package com.example.jetpackcompose.part_14_Making_a_meditation_ui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Feature(
    val title: String,
    @DrawableRes val iconId: Int,
    @DrawableRes val lightColor: Color,
    @DrawableRes val mediumColor: Color,
    @DrawableRes val darkColor: Color
)
