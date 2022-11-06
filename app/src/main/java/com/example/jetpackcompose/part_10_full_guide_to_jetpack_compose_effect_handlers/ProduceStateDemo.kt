package com.example.jetpackcompose.part_10_full_guide_to_jetpack_compose_effect_handlers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.produceState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

@Composable
fun FunProduceState(countUpTo: Int): State<Int> {
    return produceState(initialValue = 0) {
        while (value < countUpTo) {
            delay(1000)
            value++
        }
    }
}

// vs

@Composable
fun FunProduceState2(countUpTo: Int): State<Int> {
    var value = 0
    return flow<Int> {

        while (value < countUpTo) {
            delay(1000)
            value++
            emit(value)
        }
    }.collectAsState(initial = 0)
}