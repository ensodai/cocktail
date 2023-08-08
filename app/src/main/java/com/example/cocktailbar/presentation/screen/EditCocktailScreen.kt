package com.example.cocktailbar.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cocktailbar.data.dataBase.CocktailInfo
import com.example.cocktailbar.navigation.ScreenRoute
import com.example.cocktailbar.presentation.viewModel.EditCocktailScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditCocktailScreen(cocktailID: Int?, navController: NavHostController) {
    Log.d(cocktailID.toString(), cocktailID.toString())
    val viewModel = hiltViewModel<EditCocktailScreenViewModel>()

    var editCocktailName by remember { mutableStateOf("") }
    var editDescription by remember { mutableStateOf("") }
    var editRecipe by remember { mutableStateOf("") }
    var editIngredient by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(all = 8.dp)) {

        TextField(
            value = editCocktailName,
            onValueChange = { editCocktailName = it },
            label = { Text("Title") },
            modifier = Modifier.padding(all = 4.dp)
        )
        TextField(
            value = editDescription,
            onValueChange = { editDescription = it },
            label = { Text("Description") },
            modifier = Modifier.padding(all = 4.dp)
        )
        TextField(
            value = editRecipe,
            onValueChange = { editRecipe = it },
            label = { Text("Recipe") },
            modifier = Modifier.padding(all = 4.dp)
        )
        TextField(
            value = editIngredient,
            onValueChange = { editIngredient = it },
            label = { Text("Ingredient") },
            modifier = Modifier.padding(all = 4.dp)
        )

        Button(
            onClick = {
                if (cocktailID == 0) {
                    viewModel.addCocktail(
                        cocktail = CocktailInfo(
                            cocktailName = editCocktailName,
                            description = editDescription,
                            ingredient = editIngredient,
                            recipe = editRecipe,
                            id = cocktailID!!
                        )
                    )
                } else {
                    viewModel.updateCocktail(
                        cocktail = CocktailInfo(
                            cocktailName = editCocktailName,
                            description = editDescription,
                            ingredient = editIngredient,
                            recipe = editRecipe,
                            id = cocktailID!!
                        )
                    )
                }
                navController.navigate(route = ScreenRoute.CocktailListScreen.route)
            },
        ) {
            Text(text = "Save")
        }
        Button(onClick = {
            navController.navigate(route = ScreenRoute.CocktailListScreen.route)
        }) {
            Text(text = "Cancel")
        }

    }

}

@Composable
fun DeleteButton(){

}