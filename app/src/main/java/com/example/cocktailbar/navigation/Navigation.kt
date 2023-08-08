package com.example.cocktailbar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.cocktailbar.presentation.screen.CocktailListScreen
import com.example.cocktailbar.presentation.screen.DetailedScreen
import com.example.cocktailbar.presentation.screen.EditCocktailScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.CocktailListScreen.route
    ) {
        composable(route = ScreenRoute.CocktailListScreen.route) {
            CocktailListScreen(navController = navController)
        }
        composable(
            route = ScreenRoute.DetailedScreen.route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) {
            it.arguments?.getInt("id")?.let { it1 ->
                DetailedScreen(
                    cocktailID = it1,
                    navController = navController
                )
            }
        }
        composable(
            route = ScreenRoute.EditCocktailScreen.route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
                defaultValue = 0
            })
        ){
            EditCocktailScreen(
                cocktailID = it.arguments?.getInt("id"),
                navController = navController
            )
        }
    }
}