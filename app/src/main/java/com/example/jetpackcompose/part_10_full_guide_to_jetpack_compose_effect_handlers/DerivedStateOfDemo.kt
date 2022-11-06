package com.example.jetpackcompose.part_10_full_guide_to_jetpack_compose_effect_handlers

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun FunDerivedStateOf() {
    var counter by remember {
        mutableStateOf(0)
    }

//    val counterText = "The counter is $counter"
//    val counterText = "The counter is " + counter

    val counterText by derivedStateOf {
        "The counter is $counter"
    }

    Button(onClick = {
        counter++
    }) {
        Text(text = counterText)
    }
}