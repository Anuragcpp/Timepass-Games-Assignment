package com.example.dogimagegenerator.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dogimagegenerator.presentation.DogImageViewModel
import com.example.dogimagegenerator.presentation.screen.MainScreen
import com.example.dogimagegenerator.presentation.navigation.destination.DestinationScreen
import com.example.dogimagegenerator.presentation.screen.GenerateDogScreen
import com.example.dogimagegenerator.presentation.screen.MyRecentlyGeneratedImageScreen
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun MainNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModel : DogImageViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = DestinationScreen.MainScreen.route) {

        composable(DestinationScreen.MainScreen.route){
            MainScreen(
                navigateToGenerateScreen = {navController.navigate(DestinationScreen.GenerateDogScreen.route)},
                navigateToRecentPhotosScreen = {navController.navigate(DestinationScreen.MyRecentlyGeneratedImageScreen.route)}
            )
        }

        composable(DestinationScreen.GenerateDogScreen.route){
            GenerateDogScreen()
        }

        composable(DestinationScreen.MyRecentlyGeneratedImageScreen.route){
            MyRecentlyGeneratedImageScreen(viewModel)
        }
    }
}