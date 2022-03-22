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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxSize(0.7f)
                    .padding(16.dp)
                    .border(5.dp, Color.Magenta)
                    .padding(5.dp)
                    .border(5.dp, Color.Blue)
                    .padding(5.dp)
                    .border(5.dp, Color.Red)
                    .padding(5.dp),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Hello World",
                    modifier = Modifier
                        .border(5.dp, Color.Yellow)
                        .padding(5.dp)
                        .offset(20.dp, 20.dp)
                        .border(10.dp, Color.Gray)
                        .padding(10.dp)
                        .clickable {
                            println("clickable")
                        }
                )

                Spacer(modifier = Modifier.height(50.dp))
                Text(text = "*****World*****")
                Text(text = "- - - ! - - -")
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
    }
}