package com.example.jetpackcompose.part_14_Making_a_meditation_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcompose.ui.part_14.HomeScreen
import com.example.jetpackcompose.ui.theme.MeditationUIYouTubeTheme

class MeditationUiActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MeditationUIYouTubeTheme {
                HomeScreen()
            }
        }
    }

}