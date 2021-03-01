package com.example.androiddevchallenge.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.puppylist.puppies
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun PuppyDetails(id: String) {
    val puppy = puppies.find { it.id == id } ?: puppies[0]
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Image(
                    painter = painterResource(id = puppy.imageResId),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(4 / 3f)
                        .clip(RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(text = "Name ${puppy.name}", style = typography.h6)
                Text(text = "Breed ${puppy.breed}", style = typography.body1)
                Text(text = "Sex ${puppy.sex}", style = typography.caption)
                Text(text = "Distance ${puppy.distance}", style = typography.caption)
            }
        }
    }
}