package com.example.jetpackcompose.part_10_full_guide_to_jetpack_compose_effect_handlers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

@Composable
fun FunDisposableEffect() {
    val lifecycleOwner = LocalLifecycleOwner.current

//    val observer = LifecycleEventObserver { source, event ->
//        if (event == Lifecycle.Event.ON_PAUSE) {
//            println("On pause called")
//        }
//    }

    DisposableEffect(key1 = lifecycleOwner) {

        val observer = LifecycleEventObserver { source, event ->
            if (event == Lifecycle.Event.ON_PAUSE) {
                println("On pause called")
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}