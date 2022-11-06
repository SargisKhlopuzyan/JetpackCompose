package com.example.jetpackcompose.part_16_how_to_make_a_3d_animated_drop_down

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpackcompose.ui.part_16.AnimatedDropDownScreen

class AnimatedDropDownActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AnimatedDropDownScreen()
        }
    }
}