package com.example.dogimagegenerator.presentation

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
fun MainScreen() {


    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {


        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                Color(66, 134, 244)
            )
        ) {
            Text(text = "Generate Dog!")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                Color(66, 134, 244)
            )
        ) {
            Text(text = "My Recently Generated Dogs!")
        }


    }
}