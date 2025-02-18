package com.example.dogimagegenerator.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.dogimagegenerator.presentation.DogImageViewModel

@Composable
fun GenerateDogScreen( viewModel: DogImageViewModel = hiltViewModel()) {

    val result = viewModel.image.value

    if(result.isLoading){
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ){
            CircularProgressIndicator()
        }
    }

    if(result.error.isNotBlank()){
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ){
            Log.d("Error", "Data -> ${result.error}")
            Text(text = result.error)
        }
    }
    
    

    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        

        AsyncImage(model = result.data?.imageUrl, contentDescription = "Dog Image", modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .padding(vertical = 8.dp))


        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { viewModel.getImage() },
            colors = ButtonDefaults.buttonColors(
                Color(66, 134, 244)
            )
        ) {

            Text(text = "Get Image")

        }
    }



}