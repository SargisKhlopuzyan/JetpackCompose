package com.example.jetpackcompose.ui.part_16

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.MeditationUIYouTubeTheme

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MeditationUIYouTubeTheme {
        AnimatedDropDownScreen()
    }
}

@Composable
fun AnimatedDropDownScreen() {
    Surface(
        color = Color(0xFF101010),
        modifier = Modifier.fillMaxSize()
    ) {
        AnimatedDropDownScreen(
            text = "Hello World!",
            modifier = Modifier
                .padding(15.dp),
            content = {
                Text(
                    text = "This is now revealed!",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.Green)
                )
            }
        )
    }

}

@Composable
fun AnimatedDropDownScreen(
    text: String,
    modifier: Modifier = Modifier,
    initiallyOpened: Boolean = false,
    content: @Composable () -> Unit
) {
    var isOpen by remember {
        mutableStateOf(initiallyOpened)
    }

    var alpha = animateFloatAsState(
        targetValue = if (isOpen) 1f else 0f,
        animationSpec = tween(
            durationMillis = 300
        )
    )

    var rotateX = animateFloatAsState(
        targetValue = if (isOpen) 0f else -90f,
        animationSpec = tween(
            durationMillis = 300
        )
    )

    Column(modifier = modifier.fillMaxSize()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = text,
                color = Color.White,
                fontSize = 16.sp
            )

            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Open or close the drop down",
                tint = Color.White,
                modifier = Modifier
                    .clickable {
                        isOpen = !isOpen
                    }
                    .scale(1f, if (isOpen) -1f else 1F)
            )
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    transformOrigin = TransformOrigin(0.5f, 0f)
                    rotationX = rotateX.value
                }
                .alpha(alpha.value)
        ) {
            content()
        }
    }

}