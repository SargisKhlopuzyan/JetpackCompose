package com.example.jetpackcompose.part_22_multi_select_lazy_column

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.ComposeMultiSelectTheme

class MultiSelectLazyColumnActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMultiSelectTheme {
                MultiSelectLazyColumnScreen()
            }
        }
    }


}

@Composable
fun MultiSelectLazyColumnScreen() {
    var items by remember {
        mutableStateOf(
            (1..20).map {
                ListItem(
                    title = "Item $it",
                    isSelected = false
                )
            }
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(items.size) { i ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        items = items.mapIndexed { index, listItem ->
                            if (i == index) {
                                listItem.copy(isSelected = !listItem.isSelected)
                            } else {
                                listItem
                            }
                        }
                    }
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Item ${items[i].title}",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )

                if (items[i].isSelected) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Selected",
                        modifier = Modifier.size(20.dp),
                        tint = Color.Green
                    )
                }
            }
        }
    }
}