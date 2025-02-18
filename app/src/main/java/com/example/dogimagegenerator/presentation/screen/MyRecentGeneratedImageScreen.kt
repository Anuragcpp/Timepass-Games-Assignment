package com.example.dogimagegenerator.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.dogimagegenerator.presentation.DogImageViewModel

@Composable
fun MyRecentlyGeneratedImageScreen(
    viewModel: DogImageViewModel
) {

    val cachedImages by viewModel.cachedDogImages.collectAsState(initial = emptyList())
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 5.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {

            items(cachedImages) {dogImage ->
                Log.d("Image URL", "MyRecentlyGeneratedImageScreen: ${dogImage.imageUrl} ")
//                Image(
//                    painter = rememberAsyncImagePainter(
//                    dogImage.imageUrl
//                    ),
//                    contentDescription = "Cached Dog Image",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(300.dp)
//                )
                AsyncImage(
                    model = dogImage.imageUrl,
                    contentDescription = "Dog Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { viewModel.clearCache() },
            colors = ButtonDefaults.buttonColors(Color(66, 134, 244))
        ) {
            Text("Clear Dogs")
        }



    }
}