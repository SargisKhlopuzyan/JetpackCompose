package com.example.jetpackcompose

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {

    val numbers: Array<String> = arrayOf()

    var names = mutableStateListOf(*numbers)

    fun delayAndChange() {
        viewModelScope.launch {
            delay(3000)
            names.clear()
            names.addAll(arrayOf("a", "b", "c", "d"))
        }
    }
}