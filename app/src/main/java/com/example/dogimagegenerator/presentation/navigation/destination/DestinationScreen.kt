package com.example.dogimagegenerator.presentation.navigation.destination

sealed class DestinationScreen (val route : String) {
    object MainScreen : DestinationScreen("home")
    object GenerateDogScreen : DestinationScreen("generate")
    object MyRecentlyGeneratedImageScreen : DestinationScreen("recentImage")
}