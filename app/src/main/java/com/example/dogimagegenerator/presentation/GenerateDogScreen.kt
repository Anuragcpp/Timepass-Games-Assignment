package com.example.dogimagegenerator.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

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
            Text(text = result.error)
        }
    }
    
    

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ){
        
        Button(onClick = { viewModel.getImage() }) {
            
            Text(text = "Get Image")
            
        }
        AsyncImage(model = result.data?.imageUrl, contentDescription = "Dog Image", modifier = Modifier
            .fillMaxSize()
            .height(280.dp)
            .padding(vertical = 8.dp))
    }



}