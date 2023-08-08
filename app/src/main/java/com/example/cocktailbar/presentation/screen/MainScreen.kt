package com.example.cocktailbar.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.cocktailbar.navigation.Navigation

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Navigation(navController = navController)
}