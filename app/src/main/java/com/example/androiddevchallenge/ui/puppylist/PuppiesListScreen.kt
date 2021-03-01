package com.example.androiddevchallenge.ui.puppylist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.typography
import java.util.*
import com.example.androiddevchallenge.R

@Composable
fun PuppiesListScreen(puppyClicked: (String) -> Unit) {
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
                            .clip(RoundedCornerShape(4.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
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
                }
            }
        }
    }
}

data class Puppy(
    val name: String,
    val age: String,
    val breed: String,
    val imageResId: Int,
    val distance: String,
    val favourite: Boolean,
    val sex: String,
    val id: String = UUID.randomUUID().toString(),
)

val puppies = listOf(
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