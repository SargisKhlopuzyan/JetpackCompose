package com.example.jetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.part_14_Making_a_meditation_ui.MeditationUiActivity
import com.example.jetpackcompose.part_15_how_to_make_a_timer.TimerActivity
import com.example.jetpackcompose.part_16_how_to_make_a_3d_animated_drop_down.AnimatedDropDownActivity
import com.example.jetpackcompose.part_17_instagram_profile_ui.InstagramProfileUIActivity
import com.example.jetpackcompose.part_18_navigation_for_beginners.NavigationActivity
import com.example.jetpackcompose.part_19_animated_splash_screen.AnimatedSplashScreenActivity
import com.example.jetpackcompose.part_20_bottom_navigation_with_badges.BottomNavigationWithBadgesActivity
import com.example.jetpackcompose.part_21_multi_layer_parallax_scroll_effect.MultiLayerParallaxScrollEffectActivity
import com.example.jetpackcompose.part_22_multi_select_lazy_column.MultiSelectLazyColumnActivity
import com.example.jetpackcompose.part_23_do_proper_permission_handling.DoProperPermissionHandlingActivity
import com.example.jetpackcompose.part_24_migrate_xml_compose.MigrateXMLComposeActivity
import com.example.jetpackcompose.part_25_clean_hheming_in_compose.CleanThemingInComposeActivity
import com.example.jetpackcompose.part_26_compose_navigation_just_got_so_much_easier.ComposeNavigationJustGotSoMuchEasierActivity
import com.example.jetpackcompose.ui.theme.ButtonBlue
import com.example.jetpackcompose.ui.theme.DeepBlue
import com.example.jetpackcompose.ui.theme.MeditationUIYouTubeTheme

class MainActivity : ComponentActivity() {

    val viewModel: MyViewModel by viewModels()
    val launchedEffectViewModel: LaunchedEffectViewModel by viewModels()

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navigationTitles = listOf(
            "Meditation UI",
            "Timer",
            "Animated Drop Down",
            "Instagram Profile UI",
            "Navigation",
            "Animated Splash Screen",
            "Bottom Navigation With Badges",
            "Multi Layer Parallax Scroll Effect",
            "Multi Select LazyColumn",
            "Do Proper Permission Handling",
            "Migrate XML Compose",
            "Clean Theming In Compose",
            "Compose Navigation Just Got So Much Easier",
        )

        setContent {
            MeditationUIYouTubeTheme {
                LazyVerticalGrid(
                    cells = GridCells.Fixed(2),
                    contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .background(DeepBlue)
                ) {
                    items(navigationTitles.size) {
                        Text(
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(7.5.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(ButtonBlue)
                                .clickable {
                                    when (it) {
                                        0 -> startActivity(
                                            Intent(
                                                this@MainActivity,
                                                MeditationUiActivity::class.java
                                            )
                                        )
                                        1 -> startActivity(
                                            Intent(
                                                this@MainActivity,
                                                TimerActivity::class.java
                                            )
                                        )
                                        2 -> startActivity(
                                            Intent(
                                                this@MainActivity,
                                                AnimatedDropDownActivity::class.java
                                            )
                                        )
                                        3 -> startActivity(
                                            Intent(
                                                this@MainActivity,
                                                InstagramProfileUIActivity::class.java
                                            )
                                        )
                                        4 -> startActivity(
                                            Intent(
                                                this@MainActivity,
                                                NavigationActivity::class.java
                                            )
                                        )
                                        5 -> startActivity(
                                            Intent(
                                                this@MainActivity,
                                                AnimatedSplashScreenActivity::class.java
                                            )
                                        )
                                        6 -> startActivity(
                                            Intent(
                                                this@MainActivity,
                                                BottomNavigationWithBadgesActivity::class.java
                                            )
                                        )
                                        7 -> startActivity(
                                            Intent(
                                                this@MainActivity,
                                                MultiLayerParallaxScrollEffectActivity::class.java
                                            )
                                        )
                                        8 -> startActivity(
                                            Intent(
                                                this@MainActivity,
                                                MultiSelectLazyColumnActivity::class.java
                                            )
                                        )
                                        9 -> startActivity(
                                            Intent(
                                                this@MainActivity,
                                                DoProperPermissionHandlingActivity::class.java
                                            )
                                        )
                                        10 -> startActivity(
                                            Intent(
                                                this@MainActivity,
                                                MigrateXMLComposeActivity::class.java
                                            )
                                        )
                                        11 -> startActivity(
                                            Intent(
                                                this@MainActivity,
                                                CleanThemingInComposeActivity::class.java
                                            )
                                        )
                                        12 -> startActivity(
                                            Intent(
                                                this@MainActivity,
                                                ComposeNavigationJustGotSoMuchEasierActivity::class.java
                                            )
                                        )
                                    }
                                }
                                .padding(7.5.dp),
                            text = navigationTitles[it],
                            color = Color.White
                        )
                    }
                }

//            FunSnackbar()
//            FunLists()
//            FunLists_LazyColumn(viewModel)
//            FunConstraintLayout()
//            FunFullGuideToJetpackComposeEffectHandlers(launchedEffectViewModel)

//            FunDerivedStateOf()
//            FunSnapshotFlow()
//            FunSimpleAnimations()

//            FunCircularProgressBar()

//            FunHowToMakeADraggableMusicKnob()

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    FunSnackbar()
//    FunLists()
//    FunLists_LazyColumn(viewModel)
//    FunConstraintLayout()
//    FunFullGuideToJetpackComposeEffectHandlers(launchedEffectViewModel)
}