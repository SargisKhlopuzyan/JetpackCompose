package com.example.jetpackcompose.part_10_full_guide_to_jetpack_compose_effect_handlers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

@Composable
fun FunSideEffect(nonComposeCounter: Int) {
    SideEffect {
        println("Called after every successful recomposition")
    }
}