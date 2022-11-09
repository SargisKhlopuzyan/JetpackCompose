package com.example.jetpackcompose.part_26_compose_navigation_just_got_so_much_easier

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.jetpackcompose.part_26_compose_navigation_just_got_so_much_easier.destinations.PostScreenDestination
import com.example.jetpackcompose.part_26_compose_navigation_just_got_so_much_easier.destinations.ProfileScreenDestination
import com.example.jetpackcompose.ui.part_26.User
import com.example.jetpackcompose.ui.theme.ComposeNavDestinationsDemoTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import java.time.LocalDateTime

class ComposeNavigationJustGotSoMuchEasierActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavDestinationsDemoTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}

/**
@RequiresApi(Build.VERSION_CODES.O)
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContent {
ComposeNavDestinationsDemoTheme {
val navController = rememberNavController()
NavHost(
navController = navController,
startDestination = "login"
) {
composable("login") {
LoginScreen(navController)
}
composable(
route = "profile/{name}/{userId}/{timestamp}",
arguments = listOf(
navArgument("name") {
type = NavType.StringType
},
navArgument("userId") {
type = NavType.StringType
},
navArgument("timestamp") {
type = NavType.LongType
},
)
) {
val name = it.arguments?.getString("name")!!
val userId = it.arguments?.getString("userId")!!
val timestamp = it.arguments?.getLong("timestamp")!!

ProfileScreen(
navController = navController,
name = name,
userId = userId,
created = timestamp
)
}
composable("post/{showOnlyPostsByUser}", arguments = listOf(
navArgument("showOnlyPostsByUser") {
type = NavType.BoolType
defaultValue = false
}
)) {
val showOnlyPostsByUser =
it.arguments?.getBoolean("showOnlyPostsByUser") ?: false
PostScreen(showOnlyPostsByUser)
}
}
}
}
}
}
 */

@Destination(start = true)
@Composable
fun LoginScreen(
//    navController: NavController
    navigator: DestinationsNavigator
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login Screen")
        Button(onClick = {
//            navController.navigate("profile/philipp/userid/123456789")
            navigator.navigate(
                ProfileScreenDestination(
                    User(
                        name = "Sargis",
                        id = "userId",
                        created = LocalDateTime.now()
                    )
                )
            )
        }) {
            Text("Go to Profile Screen")
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Destination
@Composable
fun ProfileScreen(
//    navController: NavController,
    navigator: DestinationsNavigator,
    user: User
//    name: String,
//    userId: String,
//    created: Long
) {
//    val user = remember {
//        User(
//            name = name,
//            id = userId,
//            created = LocalDateTime.ofInstant(
//                Instant.ofEpochMilli(created), ZoneId.systemDefault()
//            )
//        )
//    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Profile Screen: $user", textAlign = TextAlign.Center)
        Button(onClick = {
//            navController.navigate("post/true")
            navigator.navigate(PostScreenDestination())
        }) {
            Text("Go to Post Screen")
        }
    }
}

@Destination
@Composable
fun PostScreen(
    showOnlyPostsByUser: Boolean = false
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Post Screen, $showOnlyPostsByUser")
    }
}