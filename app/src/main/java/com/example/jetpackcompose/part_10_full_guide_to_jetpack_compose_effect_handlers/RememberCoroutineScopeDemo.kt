package com.example.jetpackcompose.part_10_full_guide_to_jetpack_compose_effect_handlers

import androidx.compose.material.Button
import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FunRememberCoroutineScope() {
    val scope = rememberCoroutineScope()
    // ERROR
//    scope.launch {
//
//    }
    Button(onClick = {
        scope.launch {
            delay(1000)
            println("Hello World!")
        }
    }) {

    }
}