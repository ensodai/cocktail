package com.example.cocktailbar.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cocktailbar.navigation.ScreenRoute
import com.example.cocktailbar.presentation.viewModel.CocktailListScreenViewModel

@Composable
fun CocktailListScreen(navController: NavHostController) {

    var continueDetailedScreen by remember() { mutableStateOf(false) }
    var continueEditScreen by remember() { mutableStateOf(false) }
    var cocktailID by remember() { mutableStateOf(0) }
    val viewModel = hiltViewModel<CocktailListScreenViewModel>()
    viewModel.getAllCocktails()
    val allCocktails by viewModel.allCocktails.collectAsState()



    LaunchedEffect(continueDetailedScreen) {
        if (continueDetailedScreen) navController.navigate(
            route = ScreenRoute.DetailedScreen.passId(cocktailID)
        )
    }
    LaunchedEffect(continueEditScreen) {
        if (continueEditScreen) navController.navigate(route = ScreenRoute.EditCocktailScreen.passId())
    }

    Column() {
        LazyColumn() {

            allCocktails?.let {
                items(it.size) { itemCount ->

                    CocktailsCard(
                        click = {
                            cocktailID = allCocktails!![itemCount].id
                            continueDetailedScreen = true
                        },
                        cocktailName = allCocktails!![itemCount].cocktailName
                    )
                }
                item{
                    AddButton(click = {
                        continueEditScreen = true
                    })
                }
//                item {
//                    Button(onClick = { viewModel.deleteAll() }) {
//                        Text(text = "DELETE ALL")
//                    }
//                }


            }
        }


    }

}

@Composable
fun CocktailsCard(
    click: () -> Unit,
    cocktailName: String
) {
    Card(
        modifier = Modifier
            .padding(all = 8.dp)
            .clickable {
                click()
            }
            .fillMaxWidth()
    ) {
        Text(
            text = cocktailName,
            modifier = Modifier.padding(all = 8.dp)
        )
    }
}

@Composable
fun AddButton(click: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Button(
            onClick = { click() },
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier.size(50.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "content description")
        }
    }

}