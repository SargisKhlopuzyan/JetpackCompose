package com.sargis.khlopuzyan.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            previewContent()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        previewContent()
    }
}

@Composable
fun previewContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(300.dp)
            .fillMaxSize()
//            .width(100.dp)
    ) {
        funRow()
        funColumn()
    }
}

@Composable
fun funRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .background(color = Color.Green)
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
//            .fillMaxSize(1.0f)
    ) {
        Text(text = "AAA")
        Text(text = "BBB")

        Text(text = "CCC")
        Text(text = "DDD")

        Text(text = "EEE")
        Text(text = "FFF")
    }
}

@Composable
fun funColumn() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = Color.Blue)
            .fillMaxHeight(1.0f)
            .fillMaxWidth()
//            .fillMaxHeight()
//            .fillMaxSize(0.5f)
    ) {
        Text(text = "aaa")
        Text(text = "bbb")

        Text(text = "ccc")
        Text(text = "ddd")

        Text(text = "e e e")
        Text(text = "f f f")
    }
}