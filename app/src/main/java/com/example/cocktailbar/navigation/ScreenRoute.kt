package com.example.cocktailbar.navigation

sealed class ScreenRoute(val route: String) {
    object MainScreen: ScreenRoute("main_screen")
    object DetailedScreen: ScreenRoute("detailed_screen/{id}"){
        fun passId(id: Int): String{
            return "detailed_screen/$id"
        }
    }
    object EditCocktailScreen: ScreenRoute("edit_cocktail_screen?id={id}"){
        fun passId(id: Int = 0): String{
            return "edit_cocktail_screen?id=$id"
        }
    }
    object CocktailListScreen: ScreenRoute("cocktail_list_screen")
}