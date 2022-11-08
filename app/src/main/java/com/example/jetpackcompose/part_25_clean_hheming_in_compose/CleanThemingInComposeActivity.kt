package com.example.jetpackcompose.part_25_clean_hheming_in_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.jetpackcompose.ui.part_24.LocalSpacing
import com.example.jetpackcompose.ui.part_24.spacing
import com.example.jetpackcompose.ui.theme.CleanThemingInComposeTheme

class CleanThemingInComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CleanThemingInComposeTheme {
                Surface(
                    color = MaterialTheme.colors.background,
//                    modifier = Modifier.padding(LocalSpacing.current.medium)
                    modifier = Modifier.padding(MaterialTheme.spacing.medium)
                ) {
                    LocalSpacing.current.medium
                }

            }
        }
    }
}


//fun MaterialTheme.