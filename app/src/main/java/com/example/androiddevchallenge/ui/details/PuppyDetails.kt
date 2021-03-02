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
package com.example.androiddevchallenge.ui.details

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.puppylist.puppiesData
import com.example.androiddevchallenge.ui.puppylist.togglePuppyFavoriteState
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun PuppyDetails(
    id: String
) {
    var puppies by remember { mutableStateOf(puppiesData) }
    val puppy = puppies.find { it.id == id }
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            if (puppy == null) {
                Text(text = "Unable to get puppy details :(")
            } else {
                Column {
                    Box {
                        Image(
                            painter = painterResource(id = puppy.imageResId),
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(4 / 3f),
                            contentScale = ContentScale.Crop
                        )
                        Image(
                            painter = painterResource(id = getFavoriteImage(puppy.favourite)),
                            contentDescription = "",
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(16.dp)
                                .wrapContentWidth()
                                .wrapContentHeight()
                                .clickable {
                                    togglePuppyFavoriteState(puppy)
                                    puppies = puppiesData
                                }
                        )
                    }

                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = puppy.name, style = typography.h6)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Breed: ${puppy.breed}", style = typography.body1)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Sex: ${puppy.sex}", style = typography.caption)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Distance: ${puppy.distance}", style = typography.caption)
                    }
                }
            }
        }
    }
}

@DrawableRes
private fun getFavoriteImage(favorite: Boolean): Int {
    return when {
        favorite -> R.drawable.ic_favorite_24
        else -> R.drawable.ic_not_favorite_24
    }
}
