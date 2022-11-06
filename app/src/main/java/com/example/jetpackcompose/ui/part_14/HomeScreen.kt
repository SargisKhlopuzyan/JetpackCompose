package com.example.jetpackcompose.ui.part_14

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.part_14_Making_a_meditation_ui.BottomMenuContent
import com.example.jetpackcompose.part_14_Making_a_meditation_ui.Feature
import com.example.jetpackcompose.part_14_Making_a_meditation_ui.standardQuadraticTo
import com.example.jetpackcompose.ui.theme.*

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MeditationUIYouTubeTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {

    val chips = listOf("Sweet sleep", "Insomnia", "Depression")

    val features = listOf(
        Feature(
            title = "Sleep meditation",
            lightColor = BlueViolet1,
            mediumColor = BlueViolet2,
            darkColor = BlueViolet3,
            iconId = R.drawable.ic_headphone
        ),
        Feature(
            title = "Tips for sleeping",
            lightColor = LightGreen1,
            mediumColor = LightGreen2,
            darkColor = LightGreen3,
            iconId = R.drawable.ic_videocam
        ),
        Feature(
            title = "Night island",
            lightColor = OrangeYellow1,
            mediumColor = OrangeYellow2,
            darkColor = OrangeYellow3,
            iconId = R.drawable.ic_headphone
        ),
        Feature(
            title = "Calming sounds",
            lightColor = Beige1,
            mediumColor = Beige2,
            darkColor = Beige3,
            iconId = R.drawable.ic_headphone
        )
    )

    val bottomMenuContents = listOf(
        BottomMenuContent(
            title = "Home",
            iconId = R.drawable.ic_home
        ),
        BottomMenuContent(
            title = "Meditate",
            iconId = R.drawable.ic_bubble
        ),
        BottomMenuContent(
            title = "Sleep",
            iconId = R.drawable.ic_moon
        ),
        BottomMenuContent(
            title = "Music",
            iconId = R.drawable.ic_music
        ),
        BottomMenuContent(
            title = "Profile",
            iconId = R.drawable.ic_profile
        )
    )

    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column(
//            verticalArrangement = Arrangement.SpaceAround, //
            modifier = Modifier.fillMaxSize()
        ) {
            GreetingSection()
            ChipSection(chips = chips)
            CurrentMeditation()

            Box(modifier = Modifier.weight(1f)) {
                FeatureSection(features = features)
            }

            BottomMenu(
                items = bottomMenuContents
            )
        }
    }
}

@Composable
fun GreetingSection(
    name: String = "Sargis"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Good morning, $name",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.body1
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) {
                            ButtonBlue
                        } else {
                            DarkerButtonBlue
                        }
                    )
                    .padding(15.dp)
            ) {
                Text(
                    text = chips[it],
                    color = TextWhite
                )
            }
        }
    }
}

@Composable
fun CurrentMeditation(
    color: Color = LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {

        Column {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "Meditation * 3-10 min",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier
                    .size(16.dp)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeatureSection(features: List<Feature>) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Featured",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Red)
        ) {

        }

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 0.dp),
            modifier = Modifier
                .fillMaxHeight()
        ) {
            items(features.size) {
                FeatureItem(feature = features[it])
            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColoredPath1 = Offset(0f, height * 0.3f)
        val mediumColoredPath2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPath3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPath4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPath5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPath1.x, mediumColoredPath1.y)
            standardQuadraticTo(mediumColoredPath1, mediumColoredPath2)
            standardQuadraticTo(mediumColoredPath2, mediumColoredPath3)
            standardQuadraticTo(mediumColoredPath3, mediumColoredPath4)
            standardQuadraticTo(mediumColoredPath4, mediumColoredPath5)
            lineTo(width.toFloat() + 100, height.toFloat() + 100)
            lineTo(-100f, height.toFloat() + 100)
            close()
        }

        // Light colored path
        val lightColoredPath1 = Offset(0f, height * 0.35f)
        val lightColoredPath2 = Offset(width * 0.1f, height * 0.4f)
        val lightColoredPath3 = Offset(width * 0.3f, height * 0.35f)
        val lightColoredPath4 = Offset(width * 0.65f, height.toFloat())
        val lightColoredPath5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(mediumColoredPath1.x, mediumColoredPath1.y)
            standardQuadraticTo(lightColoredPath1, lightColoredPath2)
            standardQuadraticTo(lightColoredPath2, lightColoredPath3)
            standardQuadraticTo(lightColoredPath3, lightColoredPath4)
            standardQuadraticTo(lightColoredPath4, lightColoredPath5)
            lineTo(width.toFloat() + 100, height.toFloat() + 100)
            lineTo(-100f, height.toFloat() + 100)
            close()
        }

        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h2,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)

            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {

                    }
                    .background(ButtonBlue)
                    .padding(horizontal = 15.dp, vertical = 6.dp)
            )
        }
    }
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {

    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = selectedItemIndex == index,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
                onItemClick = {
                    selectedItemIndex = index
                })
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }

        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor,
            textAlign = TextAlign.Center
        )
    }
}