package com.sargis.khlopuzyan.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
//        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.Green)
            .fillMaxHeight(0.5f)
            .fillMaxWidth()
//            .width(600.dp)
//            .requiredWidth(600.dp)
//            .padding(top = 50.dp)
            .border(5.dp, Color.Magenta)
            .padding(5.dp)
            .border(5.dp, Color.Blue)
            .padding(5.dp)
            .border(10.dp, Color.Red)
            .padding(10.dp)

    ) {
        Text(
            text = "Hello123456789",
            modifier = Modifier
//                .offset(0.dp, 20.dp)
                .clickable {

                }
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text(

            modifier = Modifier
                .background(color = Color.Red),
            text = "World"
        )
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