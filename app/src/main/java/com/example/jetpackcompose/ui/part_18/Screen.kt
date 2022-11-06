package com.example.jetpackcompose.ui.part_18

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                if (it.isNotEmpty()) {
                    append("/$it")
                }
            }
        }
    }
}