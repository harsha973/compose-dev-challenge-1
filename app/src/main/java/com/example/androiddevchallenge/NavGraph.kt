/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
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
        composable(PUPPIES) { PuppiesListScreen(puppyClicked = actions.puppyClicked) }
        composable(
            "$PUPPY_DETAILS/{$PUPPY_DETAILS_ID_KEY}",
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
        navController.navigate("$PUPPY_DETAILS/$id") {
            this.anim {
                enter = R.anim.nav_default_enter_anim
                exit = R.anim.nav_default_exit_anim
                popEnter = R.anim.nav_default_pop_enter_anim
                popExit = R.anim.nav_default_pop_exit_anim
            }
        }
    }
}
