package com.example.dogimagegenerator.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    navigateToGenerateScreen : () -> Unit,
    navigateToRecentPhotosScreen : () -> Unit
) {


    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {


        Text(text = "Random Dog Generator!")

        Spacer(modifier = Modifier.height(80.dp))

        Button(
            onClick = { navigateToGenerateScreen()},
            colors = ButtonDefaults.buttonColors(
                Color(66, 134, 244)
            )
        ) {
            Text(text = "Generate Dogs!")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navigateToRecentPhotosScreen() },
            colors = ButtonDefaults.buttonColors(
                Color(66, 134, 244)
            )
        ) {
            Text(text = "My Recently Generated Dogs!")
        }


    }
}