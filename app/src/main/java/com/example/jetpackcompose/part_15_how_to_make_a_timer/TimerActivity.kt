package com.example.jetpackcompose.part_15_how_to_make_a_timer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcompose.ui.part_15.TimerScreen
import com.example.jetpackcompose.ui.theme.MeditationUIYouTubeTheme

class TimerActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationUIYouTubeTheme {
                TimerScreen()
            }
        }
    }
}