package com.example.jetpackcompose.part_10_full_guide_to_jetpack_compose_effect_handlers

import androidx.compose.runtime.*
import com.example.jetpackcompose.LaunchedEffectViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect

private var i = 0

@Composable
fun FunFullGuideToJetpackComposeEffectHandlers(launchedEffectViewModel: LaunchedEffectViewModel) {

    var text by remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = true) {
        launchedEffectViewModel.sharedFlow.collect { event ->
            when (event) {
                is LaunchedEffectViewModel.ScreenEvents.ShowSnackbar -> {

                }
                is LaunchedEffectViewModel.ScreenEvents.Navigate -> {

                }
            }
        }

        delay(1000)
        println("The text is $text")
    }
}