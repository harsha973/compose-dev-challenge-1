package com.example.androiddevchallenge

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.androiddevchallenge.MainDestinations.PUPPIES
import com.example.androiddevchallenge.MainDestinations.PUPPY_DETAILS
import com.example.androiddevchallenge.MainDestinations.PUPPY_DETAILS_ID_KEY
import com.example.androiddevchallenge.ui.details.PuppyDetails
import com.example.androiddevchallenge.ui.puppylist.PuppiesListScreen

object MainDestinations {
    const val PUPPIES = "puppies"
    const val PUPPY_DETAILS = "puppyDetails"
    const val PUPPY_DETAILS_ID_KEY = "puppyId"
}

@Composable
fun NavGraph(startDestination: String = PUPPIES) {
    val navController = rememberNavController()

    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(PUPPIES) { PuppiesListScreen(actions.puppyClicked) }
        composable(
            "${PUPPY_DETAILS}/{$PUPPY_DETAILS_ID_KEY}",
            arguments = listOf(navArgument(PUPPY_DETAILS_ID_KEY) { type = NavType.StringType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            PuppyDetails(id = arguments.getString(PUPPY_DETAILS_ID_KEY)!!)
        }
    }
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
    val puppyClicked: (String) -> Unit = { id ->
        navController.navigate("$PUPPY_DETAILS/$id")
    }
}