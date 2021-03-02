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

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun PuppiesListScreen(
    puppyClicked: (String) -> Unit
) {
    var puppies by remember { mutableStateOf(puppiesData) }

    Surface(color = MaterialTheme.colors.background) {
        LazyColumn {
            items(puppies.size) { index ->
                val puppy = puppies[index]
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clickable {
                            puppyClicked(puppy.id)
                        },
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Image(
                        painter = painterResource(id = puppy.imageResId),
                        contentDescription = "",
                        modifier = Modifier
                            .width(120.dp)
                            .aspectRatio(4 / 3f)
                            .weight(2f, false)
                            .clip(RoundedCornerShape(4.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .weight(4f, true)
                            .padding(start = 16.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = puppy.name, style = typography.h6)
                        Text(text = puppy.breed, style = typography.body1)
                        Text(
                            text = puppy.sex + " . " + puppy.age + " . " + puppy.distance,
                            style = typography.caption
                        )
                    }
                    Image(
                        painter = painterResource(id = getFavoriteImage(puppy.favourite)),
                        contentDescription = "",
                        modifier = Modifier
                            .weight(1f, false)
                            .padding(16.dp)
                            .wrapContentWidth()
                            .wrapContentHeight()
                            .clickable {
                                togglePuppyFavoriteState(puppy)
                                puppies = puppiesData
                            }
                    )
                }
            }
        }
    }
}

@DrawableRes
private fun getFavoriteImage(favorite: Boolean): Int {
    return when {
        favorite -> R.drawable.ic_favorite_24
        else -> R.drawable.ic_not_favorite_black_24
    }
}
