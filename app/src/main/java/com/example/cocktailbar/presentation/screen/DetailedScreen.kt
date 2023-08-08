package com.example.cocktailbar.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cocktailbar.navigation.ScreenRoute
import com.example.cocktailbar.presentation.viewModel.DetailedScreenViewModel

@Composable
fun DetailedScreen(cocktailID: Int, navController: NavHostController) {
    val viewModel = hiltViewModel<DetailedScreenViewModel>()
    viewModel.getCocktailById(cocktailID)
    val cocktail by viewModel.cocktail.collectAsState()
    cocktail?.let {
        Column() {
            Text(text = cocktail!!.cocktailName)
            Text(text = cocktail!!.description)
            Text(text = cocktail!!.ingredient)
            Text(text = cocktail!!.recipe)
            Button(onClick = {
                navController.navigate(route = ScreenRoute.EditCocktailScreen.passId(cocktailID))
            }) {
                Text(text = "Edit")
            }

        }
    }



}