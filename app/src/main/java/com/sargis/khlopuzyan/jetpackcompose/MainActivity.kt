package com.sargis.khlopuzyan.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.sargis.khlopuzyan.jetpackcompose.ui.theme.JetpackComposeTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()

            Scaffold(scaffoldState = scaffoldState) {

//                var counter by remember {
//                    mutableStateOf(0)
//                }

                var counter = produceState(initialValue = 0) {
                    delay(3000L)
                    value = 4
                }

                if (counter.value % 5 == 0 && counter.value > 0) {
//                    scope.launch {
//                        scaffoldState.snackbarHostState.showSnackbar("Hello")
//                    }

                    LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
                        scaffoldState.snackbarHostState.showSnackbar("Hello")
                    }
                }

                Button(onClick = {

                }) {
                    Text(text = "Click me: ${counter.value}")
                }
            }
        }
    }
}

var i = 0

@Composable
fun MyComposable(backPressedDispatcher: OnBackPressedDispatcher) {

    SideEffect {
        i++
    }

    val callback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

            }
        }
    }

    DisposableEffect(key1 = backPressedDispatcher) {
        backPressedDispatcher.addCallback(callback)
        onDispose {
            callback.remove()
        }
    }

    Button(onClick = {

    }) {
        Text(text = "Click me")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
    }
}