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
package com.example.androiddevchallenge.ui.puppylist

import com.example.androiddevchallenge.R
import kotlin.random.Random

data class Puppy(
    val name: String,
    val age: String,
    val breed: String,
    val imageResId: Int,
    val distance: String,
    val favourite: Boolean,
    val sex: String,
    val id: String = Random.nextInt().toString(),
)

var puppiesData = listOf(
    Puppy(
        "LULU",
        age = "4 months",
        breed = "Pit Bull",
        distance = "2 miles",
        favourite = false,
        sex = "Male",
        imageResId = R.drawable.pitbull_baby
    ),
    Puppy(
        "Chalie",
        age = "1 year",
        breed = "Affenpinscher",
        distance = "50 miles",
        favourite = false,
        sex = "Male",
        imageResId = R.drawable.affenpinscher_1yrs
    ),
    Puppy(
        "Lola",
        age = "1 month",
        breed = "Husky",
        distance = "50 miles",
        favourite = false,
        sex = "Female",
        imageResId = R.drawable.husky_puppy_1_mo
    ),
    Puppy(
        "Sophie",
        age = "6 months",
        breed = "Labrador",
        distance = "50 miles",
        favourite = false,
        sex = "Female",
        imageResId = R.drawable.labrador_puppy
    ),
    Puppy(
        "Maggie",
        age = "4 months",
        breed = "pomeranian",
        distance = "50 miles",
        favourite = false,
        sex = "Female",
        imageResId = R.drawable.puppy_pomeranian
    ),
    Puppy(
        "Toby",
        age = "5 months",
        breed = "German Shepherd",
        distance = "1 miles",
        favourite = false,
        sex = "Male",
        imageResId = R.drawable.german_shepherd_puppy
    ),
    Puppy(
        "Buddy",
        age = "2 months",
        breed = "Golden Retriever",
        distance = "2 miles",
        favourite = false,
        sex = "Male",
        imageResId = R.drawable.golden_retriever
    )
)

fun togglePuppyFavoriteState(puppy: Puppy) {
    puppiesData = puppiesData.map { item ->
        if (item.id == puppy.id) {
            return@map puppy.copy(favourite = !puppy.favourite)
        }

        item
    }.toList()
}
